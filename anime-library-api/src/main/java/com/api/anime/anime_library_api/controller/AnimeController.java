package com.api.anime.anime_library_api.controller;

import com.api.anime.anime_library_api.domain.dto.AtualizacaoAnimeDTO;
import com.api.anime.anime_library_api.domain.dto.DetalhamentoAnimeDTO;
import com.api.anime.anime_library_api.domain.dto.ListagemAnimeDTO;
import com.api.anime.anime_library_api.domain.entity.Anime;
import com.api.anime.anime_library_api.domain.repository.AnimeRepository;
import com.api.anime.anime_library_api.domain.dto.RegistroAnimeDTO;
import com.api.anime.anime_library_api.domain.entity.Genero;
import com.api.anime.anime_library_api.domain.repository.GeneroRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("animes")
public class AnimeController {

    @Autowired
    private AnimeRepository animeRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Anime> registrar(@RequestBody @Valid RegistroAnimeDTO dados) {
        // Obtém ou cria gêneros com base nos nomes fornecidos na requisição
        List<Genero> generos = dados.generos().stream()
                .map(nomeGenero -> generoRepository.findByNome(nomeGenero)
                        .orElseGet(() -> generoRepository.save(new Genero(null, nomeGenero))))
                .collect(Collectors.toList());

        // Cria o novo anime com a lista de gêneros
        Anime anime = new Anime(dados, generos);
        animeRepository.save(anime);

        return ResponseEntity.status(HttpStatus.CREATED).body(anime);
    }

    @PostMapping("/{animeId}/avaliar")
    public ResponseEntity<Void> avaliarAnime(@PathVariable Long animeId, @RequestBody Double novaNota) {
        Anime anime = animeRepository.getReferenceById(animeId);
        anime.adicionarNota(novaNota);
        animeRepository.save(anime);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<ListagemAnimeDTO>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        Page<ListagemAnimeDTO> page = animeRepository.findAllByAtivoTrue(paginacao).map(ListagemAnimeDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhamentoAnimeDTO> detalharAnime(@PathVariable Long id){
        Anime anime = animeRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhamentoAnimeDTO(anime));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhamentoAnimeDTO> atualizar(@RequestBody @Valid AtualizacaoAnimeDTO dados, @PathVariable Long id) {
        Anime anime = animeRepository.getReferenceById(id);
        anime.atualizarInformacoes(dados);

        // Criando uma lista de gêneros a partir dos nomes fornecidos
        List<Genero> generos = new ArrayList<>();

        dados.generos().forEach(nomeGenero -> {
            // Verifica se o gênero já existe, caso contrário cria um novo
            generos.add(generoRepository.findByNome(String.valueOf(nomeGenero))
                    .orElseGet(() -> generoRepository.save(new Genero(null, nomeGenero.toString()))));
        });

        anime.setGeneros(generos);  // Definindo a lista de gêneros no anime

        return ResponseEntity.ok(new DetalhamentoAnimeDTO(anime));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desativar(@PathVariable Long id) {
        Anime anime = animeRepository.getReferenceById(id);
        anime.desativar();
        return ResponseEntity.ok(new DetalhamentoAnimeDTO(anime));
    }

    @PutMapping("/{id}/ativar")
    @Transactional
    public ResponseEntity ativar(@PathVariable Long id) {
        Anime anime = animeRepository.getReferenceById(id);
        anime.ativar();
        return ResponseEntity.ok(new DetalhamentoAnimeDTO(anime));
    }

}

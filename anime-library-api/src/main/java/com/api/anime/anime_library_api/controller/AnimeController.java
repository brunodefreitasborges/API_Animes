package com.api.anime.anime_library_api.controller;

import com.api.anime.anime_library_api.domain.entity.Anime;
import com.api.anime.anime_library_api.domain.repository.AnimeRepository;
import com.api.anime.anime_library_api.domain.anime.DadosRegistroAnime;
import com.api.anime.anime_library_api.domain.entity.Genero;
import com.api.anime.anime_library_api.domain.repository.GeneroRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Anime> registrar(@RequestBody @Valid DadosRegistroAnime dados) {
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

}

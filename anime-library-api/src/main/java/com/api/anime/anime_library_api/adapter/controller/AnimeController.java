package com.api.anime.anime_library_api.adapter.controller;

import com.api.anime.anime_library_api.application.dto.*;
import com.api.anime.anime_library_api.application.usecase.*;
import com.api.anime.anime_library_api.domain.entity.Anime;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("animes")
public class AnimeController {

    private final RegistrarAnimeUseCase registrarAnimeUseCase;
    private final AvaliarAnimeUseCase avaliarAnimeUseCase;
    private final ListarAnimesUseCase listarAnimesUseCase;
    private final DetalharAnimeUseCase detalharAnimeUseCase;
    private final AtualizarAnimeUseCase atualizarAnimeUseCase;
    private final DesativarAnimeUseCase desativarAnimeUseCase;
    private final AtivarAnimeUseCase ativarAnimeUseCase;
    private final ListarAnimesPorGeneroUseCase listarAnimesPorGeneroUseCase;
    private final AdicionarGeneroUseCase adicionarGeneroUseCase;

    @Autowired
    public AnimeController(RegistrarAnimeUseCase registrarAnimeUseCase, AvaliarAnimeUseCase avaliarAnimeUseCase, ListarAnimesUseCase listarAnimesUseCase, DetalharAnimeUseCase detalharAnimeUseCase, AtualizarAnimeUseCase atualizarAnimeUseCase, DesativarAnimeUseCase desativarAnimeUseCase, AtivarAnimeUseCase ativarAnimeUseCase, ListarAnimesPorGeneroUseCase listarAnimesPorGeneroUseCase, AdicionarGeneroUseCase adicionarGeneroUseCase) {
        this.registrarAnimeUseCase = registrarAnimeUseCase;
        this.avaliarAnimeUseCase = avaliarAnimeUseCase;
        this.listarAnimesUseCase = listarAnimesUseCase;
        this.detalharAnimeUseCase = detalharAnimeUseCase;
        this.atualizarAnimeUseCase = atualizarAnimeUseCase;
        this.desativarAnimeUseCase = desativarAnimeUseCase;
        this.ativarAnimeUseCase = ativarAnimeUseCase;
        this.listarAnimesPorGeneroUseCase = listarAnimesPorGeneroUseCase;
        this.adicionarGeneroUseCase = adicionarGeneroUseCase;
    }




    @PostMapping
    @Transactional
    public ResponseEntity<Anime> registrar(@RequestBody @Valid RegistroAnimeDTO dados) {
        Anime anime = registrarAnimeUseCase.registrar(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(anime);
    }

    @PostMapping("/{id}/avaliar")
    public ResponseEntity<Void> avaliar(@PathVariable Long id, @RequestBody AvaliarDTO dados) {
        avaliarAnimeUseCase.avaliar(id, dados);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<Page<ListarAnimeDTO>> listarAnimePorGenero(@PathVariable String genero, @PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        Page<ListarAnimeDTO> page = listarAnimesPorGeneroUseCase.listaGenero(genero, paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping
    public ResponseEntity<Page<ListarAnimeDTO>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        Page<ListarAnimeDTO> page = listarAnimesUseCase.listar(paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhamentoAnimeDTO> detalhar(@PathVariable Long id){
        Anime anime = detalharAnimeUseCase.detalhar(id);
        return ResponseEntity.ok(new DetalhamentoAnimeDTO(anime));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhamentoAnimeDTO> atualizar(@RequestBody @Valid AtualizacaoAnimeDTO dados, @PathVariable Long id) {
        Anime anime = atualizarAnimeUseCase.atualizar(dados, id);
        return ResponseEntity.ok(new DetalhamentoAnimeDTO(anime));
    }


    @PutMapping("/{id}/ativar")
    @Transactional
    public ResponseEntity<DetalhamentoAnimeDTO> ativar(@PathVariable Long id) {
        Anime anime = ativarAnimeUseCase.ativar(id);
        return ResponseEntity.ok(new DetalhamentoAnimeDTO(anime));
    }

    @PutMapping("/{id}/{genero}")
    @Transactional
    public ResponseEntity<Void> adicionarGenero(@PathVariable Long id, @PathVariable String genero) {
        adicionarGeneroUseCase.adicionarGenero(id, genero);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhamentoAnimeDTO> desativar(@PathVariable Long id) {
        Anime anime = desativarAnimeUseCase.desativar(id);
        return ResponseEntity.ok(new DetalhamentoAnimeDTO(anime));
    }
}

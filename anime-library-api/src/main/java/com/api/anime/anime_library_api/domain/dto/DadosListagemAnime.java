package com.api.anime.anime_library_api.domain.dto;

import com.api.anime.anime_library_api.domain.entity.Anime;
import com.api.anime.anime_library_api.domain.entity.Genero;

import java.util.List;
import java.util.stream.Collectors;

public record DadosListagemAnime(Long id, String titulo, String autor, Double nota, String sinopse, List<String> generos) {

    public DadosListagemAnime(Anime anime) {
        this(
                anime.getId(),
                anime.getTitulo(),
                anime.getAutor(),
                anime.getNota(),
                anime.getSinopse(),
                anime.getGeneros().stream()
                        .map(Genero::getNome)
                        .collect(Collectors.toList()));
    }
}


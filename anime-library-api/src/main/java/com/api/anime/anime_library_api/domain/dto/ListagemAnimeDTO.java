package com.api.anime.anime_library_api.domain.dto;

import com.api.anime.anime_library_api.domain.entity.Anime;

public record ListagemAnimeDTO(Long id, String titulo) {

    public ListagemAnimeDTO(Anime anime) {
        this(
                anime.getId(),
                anime.getTitulo());
    }
}


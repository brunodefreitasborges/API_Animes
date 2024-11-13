package com.api.anime.anime_library_api.application.dto;

import com.api.anime.anime_library_api.domain.entity.Anime;

public record ListarAnimeDTO(Long id, String titulo, Double nota) {

    public ListarAnimeDTO(Anime anime) {
        this(
                anime.getId(),
                anime.getTitulo(),
                anime.getNota());
    }
}


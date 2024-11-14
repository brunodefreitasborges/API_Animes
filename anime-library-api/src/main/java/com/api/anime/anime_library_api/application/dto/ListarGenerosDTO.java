package com.api.anime.anime_library_api.application.dto;

import com.api.anime.anime_library_api.domain.entity.Genero;

public record ListarGenerosDTO(String nome) {
    public ListarGenerosDTO(Genero genero) {
        this(genero.getNome());
    }
}

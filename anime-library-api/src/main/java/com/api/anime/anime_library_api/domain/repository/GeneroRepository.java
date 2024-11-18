package com.api.anime.anime_library_api.domain.repository;

import com.api.anime.anime_library_api.domain.entity.Genero;

import java.util.Optional;

public interface GeneroRepository {

    Optional<Genero> findByNome(String nome);

}

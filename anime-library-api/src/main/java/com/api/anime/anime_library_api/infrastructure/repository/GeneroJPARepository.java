package com.api.anime.anime_library_api.infrastructure.repository;

import com.api.anime.anime_library_api.domain.entity.Genero;
import com.api.anime.anime_library_api.domain.repository.GeneroRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneroJPARepository extends JpaRepository<Genero, Long>, GeneroRepository {

    @Override
    Optional<Genero> findByNome(String nome);

}

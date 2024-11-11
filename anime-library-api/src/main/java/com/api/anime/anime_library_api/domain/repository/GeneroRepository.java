package com.api.anime.anime_library_api.domain.repository;

import com.api.anime.anime_library_api.domain.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
    Optional<Genero> findByNome(String nome);
}

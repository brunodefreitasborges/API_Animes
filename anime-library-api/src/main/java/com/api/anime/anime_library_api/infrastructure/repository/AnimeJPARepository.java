package com.api.anime.anime_library_api.infrastructure.repository;

import com.api.anime.anime_library_api.domain.entity.Anime;
import com.api.anime.anime_library_api.domain.repository.AnimeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeJPARepository extends JpaRepository<Anime, Long>, AnimeRepository {

    @Override
    Page<Anime> findAllByAtivoTrue(Pageable paginacao);

    @Override
    Page<Anime> findByGenerosNomeIgnoreCaseAndAtivoTrue(String nomeGenero, Pageable pageable);

}

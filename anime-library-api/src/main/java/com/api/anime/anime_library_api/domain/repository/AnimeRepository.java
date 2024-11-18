package com.api.anime.anime_library_api.domain.repository;

import com.api.anime.anime_library_api.domain.entity.Anime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnimeRepository {

    Page<Anime> findAllByAtivoTrue(Pageable paginacao);

    Page<Anime> findByGenerosNomeIgnoreCaseAndAtivoTrue(String nomeGenero, Pageable pageable);
}

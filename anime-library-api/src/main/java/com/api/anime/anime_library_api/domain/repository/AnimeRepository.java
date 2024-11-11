package com.api.anime.anime_library_api.domain.repository;

import com.api.anime.anime_library_api.domain.entity.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
}
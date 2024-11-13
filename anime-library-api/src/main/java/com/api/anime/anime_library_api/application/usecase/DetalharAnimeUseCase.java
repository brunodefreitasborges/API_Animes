package com.api.anime.anime_library_api.application.usecase;

import com.api.anime.anime_library_api.domain.entity.Anime;
import com.api.anime.anime_library_api.domain.repository.AnimeRepository;
import org.springframework.stereotype.Service;

@Service
public class DetalharAnimeUseCase {

    private final AnimeRepository animeRepository;

    public DetalharAnimeUseCase(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public Anime detalhar(Long id) {
        return animeRepository.getReferenceById(id);
    }
}

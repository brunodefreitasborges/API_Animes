package com.api.anime.anime_library_api.application.usecase;

import com.api.anime.anime_library_api.domain.entity.Anime;
import com.api.anime.anime_library_api.domain.repository.AnimeRepository;
import com.api.anime.anime_library_api.domain.repository.GeneroRepository;
import org.springframework.stereotype.Service;

@Service
public class AtivarAnimeUseCase {

    private final AnimeRepository animeRepository;

    public AtivarAnimeUseCase(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public Anime ativar(Long id) {
        Anime anime = animeRepository.getReferenceById(id);
        anime.ativar();
        return anime;
    }
}

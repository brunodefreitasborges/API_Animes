package com.api.anime.anime_library_api.application.usecase;

import com.api.anime.anime_library_api.domain.entity.Anime;
import com.api.anime.anime_library_api.domain.repository.AnimeRepository;
import org.springframework.stereotype.Service;

@Service
public class DesativarAnimeUseCase {

    private final AnimeRepository animeRepository;

    public DesativarAnimeUseCase(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public Anime desativar(Long id) {
        Anime anime = animeRepository.getReferenceById(id);
        anime.desativar();
        return anime;
    }
}

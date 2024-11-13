package com.api.anime.anime_library_api.application.usecase;

import com.api.anime.anime_library_api.application.dto.AvaliarDTO;
import com.api.anime.anime_library_api.domain.entity.Anime;
import com.api.anime.anime_library_api.domain.repository.AnimeRepository;
import org.springframework.stereotype.Service;

@Service
public class AvaliarAnimeUseCase {

    private final AnimeRepository animeRepository;

    public AvaliarAnimeUseCase(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public void avaliar(Long id, AvaliarDTO novaNota) {
        Anime anime = animeRepository.getReferenceById(id);
        anime.adicionarNota(novaNota.nota());
        animeRepository.save(anime);
    }
}

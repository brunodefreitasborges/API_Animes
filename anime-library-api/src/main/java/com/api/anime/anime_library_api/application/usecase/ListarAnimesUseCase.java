package com.api.anime.anime_library_api.application.usecase;

import com.api.anime.anime_library_api.application.dto.ListarAnimeDTO;
import com.api.anime.anime_library_api.infrastructure.repository.AnimeJPARepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarAnimesUseCase {

    private final AnimeJPARepository animeJPARepository;

    public ListarAnimesUseCase(AnimeJPARepository animeJPARepository) {
        this.animeJPARepository = animeJPARepository;
    }

    public Page<ListarAnimeDTO> listar(Pageable pageable) {
        return animeJPARepository.findAllByAtivoTrue(pageable).map(ListarAnimeDTO::new);
    }
}

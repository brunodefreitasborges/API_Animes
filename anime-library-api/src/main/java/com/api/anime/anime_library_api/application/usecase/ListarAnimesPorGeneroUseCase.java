package com.api.anime.anime_library_api.application.usecase;

import com.api.anime.anime_library_api.application.dto.ListarAnimeDTO;
import com.api.anime.anime_library_api.domain.entity.Anime;
import com.api.anime.anime_library_api.infrastructure.repository.AnimeJPARepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarAnimesPorGeneroUseCase {

    private final AnimeJPARepository animeJPARepository;

    public ListarAnimesPorGeneroUseCase(AnimeJPARepository animeJPARepository) {
        this.animeJPARepository = animeJPARepository;
    }

    public Page<ListarAnimeDTO> listaGenero(String genero, Pageable pageable) {
        // A consulta deve retornar um Page<Anime> com base no gênero e no estado ativo
        Page<Anime> animes = animeJPARepository.findByGenerosNomeIgnoreCaseAndAtivoTrue(genero, pageable);

        // Mapeamento manual de Anime para ListarAnimeDTO
        List<ListarAnimeDTO> animesDTO = animes.getContent().stream()
                .map(ListarAnimeDTO::new)
                .collect(Collectors.toList());

        // Retorna o Page com a lista de DTOs
        return new PageImpl<>(animesDTO, pageable, animes.getTotalElements());
    }



}

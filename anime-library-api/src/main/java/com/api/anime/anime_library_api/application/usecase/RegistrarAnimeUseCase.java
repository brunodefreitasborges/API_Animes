package com.api.anime.anime_library_api.application.usecase;

import com.api.anime.anime_library_api.application.dto.RegistroAnimeDTO;
import com.api.anime.anime_library_api.domain.entity.Anime;
import com.api.anime.anime_library_api.domain.entity.Genero;
import com.api.anime.anime_library_api.infrastructure.repository.AnimeJPARepository;
import com.api.anime.anime_library_api.infrastructure.repository.GeneroJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrarAnimeUseCase {

    private final AnimeJPARepository animeJPARepository;
    private final GeneroJPARepository generoJPARepository;

    public RegistrarAnimeUseCase(AnimeJPARepository animeJPARepository, GeneroJPARepository generoJPARepository) {
        this.animeJPARepository = animeJPARepository;
        this.generoJPARepository = generoJPARepository;
    }

    public Anime registrar(RegistroAnimeDTO dados) {
        List<Genero> generos = dados.generos().stream()
                .map(nomeGenero -> generoJPARepository.findByNome(nomeGenero)
                        .orElseGet(() -> generoJPARepository.save(new Genero(null, nomeGenero))))
                .collect(Collectors.toList());

        Anime anime = new Anime(dados, generos);
        animeJPARepository.save(anime);

        return anime;
    }
}

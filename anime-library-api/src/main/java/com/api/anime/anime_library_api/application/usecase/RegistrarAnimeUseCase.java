package com.api.anime.anime_library_api.application.usecase;

import com.api.anime.anime_library_api.application.dto.RegistroAnimeDTO;
import com.api.anime.anime_library_api.domain.entity.Anime;
import com.api.anime.anime_library_api.domain.entity.Genero;
import com.api.anime.anime_library_api.domain.repository.AnimeRepository;
import com.api.anime.anime_library_api.domain.repository.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrarAnimeUseCase {

    private final AnimeRepository animeRepository;
    private final GeneroRepository generoRepository;

    public RegistrarAnimeUseCase(AnimeRepository animeRepository, GeneroRepository generoRepository) {
        this.animeRepository = animeRepository;
        this.generoRepository = generoRepository;
    }

    public Anime registrar(RegistroAnimeDTO dados) {
        List<Genero> generos = dados.generos().stream()
                .map(nomeGenero -> generoRepository.findByNome(nomeGenero)
                        .orElseGet(() -> generoRepository.save(new Genero(null, nomeGenero))))
                .collect(Collectors.toList());

        Anime anime = new Anime(dados, generos);
        animeRepository.save(anime);

        return anime;
    }

}

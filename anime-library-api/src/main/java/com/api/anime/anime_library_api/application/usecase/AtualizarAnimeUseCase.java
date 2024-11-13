package com.api.anime.anime_library_api.application.usecase;

import com.api.anime.anime_library_api.application.dto.AtualizacaoAnimeDTO;
import com.api.anime.anime_library_api.domain.entity.Anime;
import com.api.anime.anime_library_api.domain.entity.Genero;
import com.api.anime.anime_library_api.domain.repository.AnimeRepository;
import com.api.anime.anime_library_api.domain.repository.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtualizarAnimeUseCase {

    private final AnimeRepository animeRepository;
    private final GeneroRepository generoRepository;

    public AtualizarAnimeUseCase(AnimeRepository animeRepository, GeneroRepository generoRepository) {
        this.animeRepository = animeRepository;
        this.generoRepository = generoRepository;
    }

    public Anime atualizar(AtualizacaoAnimeDTO dados, Long id) {
        Anime anime = animeRepository.getReferenceById(id);
        anime.atualizarInformacoes(dados);

        // Criando uma lista de gêneros a partir dos nomes fornecidos
        List<Genero> generos = new ArrayList<>();

        dados.generos().forEach(nomeGenero -> {
            // Verifica se o gênero já existe, caso contrário cria um novo
            generos.add(generoRepository.findByNome(String.valueOf(nomeGenero))
                    .orElseGet(() -> generoRepository.save(new Genero(null, nomeGenero.toString()))));
        });

        anime.setGeneros(generos);  // Definindo a lista de gêneros no anime

        return anime;
    }
}

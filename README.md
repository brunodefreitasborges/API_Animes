# API_Animes
API de Biblioteca de Animes

Base URL
/api/animes

Estrutura da Entidade Anime
Cada anime possui:

ID (Integer): Identificador único do anime.
Título (String): Nome do anime.
Autor(a) (String): Nome do autor ou autora do anime.
Avaliação (Float): Nota média de avaliação do anime (de 0 a 5 estrelas).
Sinopse (String): Breve descrição sobre o anime.
Gêneros (List<String>): Lista de gêneros (ex: ação, aventura).
Endpoints


1. Criar um Anime - DONE

Endpoint: POST /api/animes
Descrição: Adiciona um novo anime à biblioteca.
Corpo da Requisição:
{
"titulo": "One Piece",
"autor": "Eiichiro Oda",
"sinopse": "One Piece segue as aventuras de Monkey D. Luffy e sua tripulação em busca do tesouro lendário 'One Piece' para se tornarem os Reis dos Piratas. A história se passa em um vasto mundo repleto de ilhas, piratas, Marinha e uma grande diversidade de personagens e poderes.",
"generos": [
"ACAO",
"AVENTURA",
"COMEDIA",
"DRAMA",
"FANTASIA"
]
}
Resposta: JSON com os dados do anime registrado.


2. Listar Todos os Animes - DONE

Endpoint: GET /api/animes
Descrição: Retorna uma lista de todos os animes na biblioteca, com nome e id.


3. Obter Anime por ID - DONE

Endpoint: GET /api/animes/{id}
Descrição: Retorna os detalhes de um anime específico.
Parâmetros:
id (Integer): ID do anime.


4. Atualizar um Anime - TODO

Endpoint: PUT /api/animes/{id}
Descrição: Atualiza informações de um anime específico.
Parâmetros:
id (Integer): ID do anime.
Corpo da Requisição:
{
"titulo" : "uma peça",
"generos" : [
{ "nome": "ACAO" },
{ "nome": "AVENTURA" },
{ "nome": "COMEDIA" },
{ "nome": "DRAMA" },
{ "nome": "FANTASIA" }
]
}

5. Remover um Anime - TODO

Endpoint: DELETE /api/animes/{id}
Descrição: Remove um anime da biblioteca.
Parâmetros:
id (Integer): ID do anime.
Funcionalidades Específicas


6. Avaliar um Anime - DONE

Endpoint: POST /api/animes/{id}/avaliacao
Descrição: Permite que o usuário adicione uma nova avaliação para um anime. A nota é somada ao total, e a média é recalculada.
Parâmetros:
id (Integer): ID do anime.
Corpo da Requisição:
{
  4.5
}


7. Listar Animes de um Autor - TODO

Endpoint: GET /api/autores/{autorId}/animes
Descrição: Retorna todos os animes associados a um autor específico.
Parâmetros:
autorId (Integer): ID do autor.
Possíveis Extensões Futuras
Filtrar Animes por Gênero: Endpoint que permita a filtragem de animes com base no gênero.
Ordenar Animes por Avaliação: Endpoint para listar animes em ordem de avaliação (do mais alto ao mais baixo).
Adicionar Comentários: Endpoint para adicionar comentários aos animes, permitindo uma interação mais detalhada.

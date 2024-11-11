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


1. Criar um Anime

Endpoint: POST /api/animes
Descrição: Adiciona um novo anime à biblioteca.
Corpo da Requisição:
{
  "titulo": "Naruto",
  "autor": "Masashi Kishimoto",
  "sinopse": "Naruto Uzumaki é um jovem ninja...",
  "generos": ["Ação", "Aventura"]
}
Resposta: JSON com os dados do anime cr


2. Listar Todos os Animes

Endpoint: GET /api/animes
Descrição: Retorna uma lista de todos os animes na biblioteca.


3. Obter Anime por ID

Endpoint: GET /api/animes/{id}
Descrição: Retorna os detalhes de um anime específico.
Parâmetros:
id (Integer): ID do anime.


4. Atualizar um Anime

Endpoint: PUT /api/animes/{id}
Descrição: Atualiza informações de um anime específico.
Parâmetros:
id (Integer): ID do anime.
Corpo da Requisição: JSON com os campos a serem atualizados (ex: título, sinopse, autor).


5. Remover um Anime

Endpoint: DELETE /api/animes/{id}
Descrição: Remove um anime da biblioteca.
Parâmetros:
id (Integer): ID do anime.
Funcionalidades Específicas


6. Avaliar um Anime

Endpoint: POST /api/animes/{id}/avaliacao
Descrição: Permite que o usuário adicione uma nova avaliação para um anime. A nota é somada ao total, e a média é recalculada.
Parâmetros:
id (Integer): ID do anime.
Corpo da Requisição:
{
  "nota": 4.5
}


7. Listar Animes de um Autor

Endpoint: GET /api/autores/{autorId}/animes
Descrição: Retorna todos os animes associados a um autor específico.
Parâmetros:
autorId (Integer): ID do autor.
Possíveis Extensões Futuras
Filtrar Animes por Gênero: Endpoint que permita a filtragem de animes com base no gênero.
Ordenar Animes por Avaliação: Endpoint para listar animes em ordem de avaliação (do mais alto ao mais baixo).
Adicionar Comentários: Endpoint para adicionar comentários aos animes, permitindo uma interação mais detalhada.

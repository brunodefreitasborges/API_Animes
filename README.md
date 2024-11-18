# Anime Library API

A API para gerenciar uma biblioteca de animes, permitindo o registro, avaliação, listagem, atualização, desativação e adição de gêneros aos animes. A API também oferece a funcionalidade de buscar animes por gênero.

## Funcionalidades

### **Anime**

- **Registrar Anime**
  - **Endpoint**: `POST /animes`
  - **Descrição**: Registra um novo anime na biblioteca.
  - **Parâmetros**: `RegistroAnimeDTO` (Título, sinopse, nota inicial 0, etc.)
  - **Resposta**: Retorna o anime recém-criado.

- **Avaliar Anime**
  - **Endpoint**: `POST /animes/{id}/avaliar`
  - **Descrição**: Avalia um anime e altera sua nota com base na avaliação fornecida.
  - **Parâmetros**: `AvaliarDTO` (nota de 0 a 5 estrelas)
  - **Resposta**: Retorna uma resposta de sucesso.

- **Listar Animes**
  - **Endpoint**: `GET /animes`
  - **Descrição**: Lista todos os animes na biblioteca com paginação.
  - **Parâmetros**: `Pageable` (página e número de itens por página)
  - **Resposta**: Retorna uma lista paginada de animes.

- **Detalhar Anime**
  - **Endpoint**: `GET /animes/{id}`
  - **Descrição**: Retorna os detalhes de um anime específico.
  - **Parâmetros**: `id` (ID do anime)
  - **Resposta**: Retorna detalhes como título, sinopse e avaliação média.

- **Atualizar Anime**
  - **Endpoint**: `PUT /animes/{id}`
  - **Descrição**: Atualiza as informações de um anime existente.
  - **Parâmetros**: `AtualizacaoAnimeDTO` (novos dados do anime)
  - **Resposta**: Retorna o anime atualizado.

- **Ativar Anime**
  - **Endpoint**: `PUT /animes/{id}/ativar`
  - **Descrição**: Ativa um anime previamente desativado.
  - **Parâmetros**: `id` (ID do anime)
  - **Resposta**: Retorna o anime ativado.

- **Desativar Anime**
  - **Endpoint**: `DELETE /animes/{id}`
  - **Descrição**: Desativa um anime, fazendo com que ele não apareça nas listagens futuras.
  - **Parâmetros**: `id` (ID do anime)
  - **Resposta**: Retorna o anime desativado.

- **Adicionar Gênero ao Anime**
  - **Endpoint**: `PUT /animes/{id}/{genero}`
  - **Descrição**: Associa um gênero a um anime.
  - **Parâmetros**: `id` (ID do anime), `genero` (nome do gênero)
  - **Resposta**: Retorna uma resposta de sucesso.

### **Gêneros**

- **Listar Gêneros**
  - **Endpoint**: `GET /generos`
  - **Descrição**: Lista todos os gêneros disponíveis na biblioteca com paginação.
  - **Parâmetros**: `Pageable` (página e número de itens por página)
  - **Resposta**: Retorna uma lista paginada de gêneros.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para o desenvolvimento da API.
- **JPA (Java Persistence API)**: Gerenciamento de dados no banco de dados.
- **Spring Data**: Acesso fácil ao banco de dados.
- **Spring Security**: Gerenciamento de segurança e autenticação.
- **Jakarta Validation**: Validação de dados de entrada.
- **Pageable**: Paginação de respostas em listagens de animes e gêneros.

## Como Usar

1. Clone o repositório:

```bash
git clone https://github.com/seuusuario/anime-library-api.git

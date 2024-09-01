# Sistema de Biblioteca Caseira
## Modelagem e Diagramação Sistema Biblioteca Caseira.
### O objetivo deste documento é especificar os requisitos para o desenvolvimento de um sistema de biblioteca caseira que permitirá ao usuário cadastrar livros e editores, além de realizar pesquisas detalhadas sobre os livros cadastrados.

```mermaid
classDiagram
    class Livro {
        +String titulo
        +String autor
        +String assunto
        +String anoPublicacao
        +String ISBN
        +int numeroPaginas
        +Editora editora
        +cadastrarLivro()
        +editarLivro()
        +excluirLivro()
    }

    class Editora {
        +String nome
        +String endereco
        +String telefone
        +String email
        +cadastrarEditora()
        +editarEditora()
        +excluirEditora()
    }

    Livro "1" -- "N" Editora : editora
```

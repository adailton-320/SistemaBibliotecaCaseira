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

    class Usuario {
        - nome: String
        - email: String
        - senha: String
        - livrosEmprestados: List<Livro>
    }

    class Emprestimo {
        - livro: Livro
        - usuario: Usuario
        - dataEmprestimo: Date
        - dataDevolucaoPrevista: Date
        - dataDevolucaoReal: Date
    }
	Usuario "1" -- "N" Emprestimo : realiza
	Livro "1" -- "N" Editora : editora
```

 ## Implementação do Sistema

### Tecnologias

### - **Java:** Linguagem principal para desenvolvimento do sistema.
### - **JSF (JavaServer Faces):** Framework para criação da interface de usuário.
### - **PrimeFaces:** Biblioteca de componentes UI para JSF.
### - **JPA (Hibernate):** Para mapeamento objeto-relacional e persistência de dados.

	
	

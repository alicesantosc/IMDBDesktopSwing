# IMDb Clone em Java Swing

Este é um projeto de clone do IMDb desenvolvido em Java Swing como parte de um projeto acadêmico.

## Funcionalidades Principais

- **Pesquisa de Filmes:** Permite aos usuários pesquisar filmes por título, gênero ou ator.
- **Visualização de Detalhes:** Mostra informações detalhadas sobre cada filme, incluindo elenco, diretor, sinopse e avaliações.
- **Avaliações e Comentários:** Usuários podem avaliar filmes e deixar comentários.
- **Perfil do Usuário:** Opção para criar um perfil de usuário para salvar filmes favoritos e histórico de avaliações.

## Tecnologias Utilizadas

- **Java Swing:** Interface gráfica para interação com o usuário.
- **MySQL:** Banco de dados para armazenamento de informações dos filmes, usuários e avaliações.
- **JDBC:** Conexão com o banco de dados MySQL para operações de leitura e escrita.
- **Maven:** Gerenciamento de dependências e construção do projeto.

## Como Executar o Projeto

1. **Configuração do Ambiente:**
   - Certifique-se de ter o JDK e o MySQL instalados na sua máquina.

2. **Configuração do Banco de Dados:**
   - Importe o arquivo SQL fornecido (`database.sql`) para criar o esquema e as tabelas necessárias no MySQL.

3. **Configuração do Projeto:**
   - Abra o projeto no IntelliJ IDEA ou Eclipse.
   - Configure as informações de conexão com o banco de dados no arquivo `src/main/java/com/imdb/database/Database.java`.

4. **Execução:**
   - Compile e execute o arquivo `src/main/java/com/imdb/Main.java`.
   - A aplicação será iniciada com a tela principal do IMDb Clone.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir um pull request ou relatar problemas.

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

# Sistema de Gestão de Estudantes (SGE)

## Descrição

Este é um projeto de um Sistema de Gestão de Estudantes (SGE) desenvolvido em Java, como parte de um exercício de Programação Orientada a Objetos. O sistema permite o gerenciamento de alunos, professores, cursos e turmas, além de funcionalidades como lançamento de notas e geração de relatórios.

## Funcionalidades

O sistema oferece as seguintes funcionalidades:

- **Cadastro de Usuários:**
  - Cadastrar Alunos
  - Cadastrar Professores
  - Cadastrar Administradores
- **Cadastro de Cursos:**
  - Cadastrar Cursos Presenciais
  - Cadastrar Cursos a Distância (EAD)
- **Gerenciamento de Turmas:**
  - Criar turmas associando um professor e um curso
  - Adicionar e remover alunos de uma turma
- **Avaliações:**
  - Lançar avaliações com notas para os alunos de uma turma
- **Relatórios:**
  - Gerar relatórios individuais para alunos e professores
  - Gerar relatórios de cursos
  - Gerar resumos de turmas com a lista de alunos e suas avaliações
- **Autenticação:**
  - Sistema de autenticação para usuários (alunos, professores e administradores)

## Estrutura do Projeto

O projeto está organizado nos seguintes pacotes:

- `interfaces`: Contém as interfaces `Autenticacao` e `Relatorio`.
- `model`: Contém as classes de modelo do sistema, como `Aluno`, `Professor`, `Curso`, `Turma`, etc.
- `repository`: Contém as classes responsáveis pelo armazenamento e recuperação de dados em memória, como `UsuarioRepository`, `CursoRepository` e `TurmaRepository`.
- `service`: Contém as classes de serviço que orquestram as regras de negócio, como `TurmaService` and `RelatorioService`.
- `ui`: Contém a classe `Main`, responsável pela interação com o usuário via console.

## Como Executar

1.  Compile os arquivos `.java`.
2.  Execute a classe `Main` para iniciar o sistema.

```bash
javac ui/Main.java
java ui.Main
```

## Exemplo de Uso

Ao iniciar o programa, um menu principal é exibido, permitindo que o usuário interaja com o sistema e utilize suas funcionalidades. O sistema já inicia com alguns dados cadastrados para facilitar os testes.

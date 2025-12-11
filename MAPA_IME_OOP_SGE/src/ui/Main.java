package ui;

import model.*;
import interfaces.Autenticacao;
import interfaces.Relatorio;
import repository.CursoRepository;
import repository.TurmaRepository;
import repository.UsuarioRepository;
import service.RelatorioService;
import service.TurmaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static TurmaRepository turmaRepository = new TurmaRepository();
    private static UsuarioRepository usuarioRepository = new UsuarioRepository();
    private static CursoRepository cursoRepository = new CursoRepository(); // Novo
    private static TurmaService turmaService = new TurmaService(turmaRepository);
    private static RelatorioService relatorioService = new RelatorioService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("ADS - IMERSAO PROFISSIONAL - OOP - GUSTavo CAMARA SOARES DE OLIVEIRA");

        setupInicialDeDados();
        exibirMenuPrincipal();

        scanner.close();
        System.out.println("\n--- Fim do Programa ---");
    }

    private static void setupInicialDeDados() {
        // Alunos
        Aluno aluno1 = new Aluno("Maria Silva", "aluno.maria", "senha123", "2023001", "Engenharia de Software");
        Aluno aluno2 = new Aluno("João Santos", "aluno.joao", "senha456", "2023002", "Ciência da Computação");
        Aluno aluno3 = new Aluno("Ana Paula", "aluno.ana", "senha789", "2023003", "Engenharia de Software");
        usuarioRepository.adicionarUsuario(aluno1);
        usuarioRepository.adicionarUsuario(aluno2);
        usuarioRepository.adicionarUsuario(aluno3);

        // Professores
        Professor professor1 = new Professor("Dr. Ana Costa", "prof.ana", "prof123", "Inteligência Artificial", "P1001");
        Professor professor2 = new Professor("Msc. Pedro Almeida", "prof.pedro", "prof456", "Redes de Computadores", "P1002");
        usuarioRepository.adicionarUsuario(professor1);
        usuarioRepository.adicionarUsuario(professor2);

        // Administrador
        Administrador admin = new Administrador("Admin Geral", "admin", "admin123");
        usuarioRepository.adicionarUsuario(admin);

        // Cursos
        Curso curso1 = new CursoPresencial("Engenharia de Software", "ES001", 3600, "Sala 101B");
        Curso cursoEAD = new CursoEAD("Ciência de Dados", "CD001", 2800, "Plataforma Brightspace");
        cursoRepository.adicionarCurso(curso1);
        cursoRepository.adicionarCurso(cursoEAD);

        // Turma
        Turma turmaES = turmaService.criarTurma("T-ES-2023-1", professor1, curso1);
        turmaService.adicionarAlunoNaTurma(turmaES, aluno1);
        turmaService.adicionarAlunoNaTurma(turmaES, aluno2);
        turmaService.adicionarAlunoNaTurma(turmaES, aluno3);
        turmaService.removerAlunoDaTurma(turmaES, aluno2); // Aluno 2 removido para simular cenário

        // Avaliações
        Avaliacao av1 = new Avaliacao("Prova 1 - Algoritmos");
        av1.atribuirNota(8.5);
        turmaService.lancarAvaliacao(turmaES, aluno1, av1);
    }

    private static void exibirMenuPrincipal() {
        int opcao;
        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Cadastrar Curso");
            System.out.println("4. Criar Turma");
            System.out.println("5. Gerenciar Alunos em Turma");
            System.out.println("6. Lançar Avaliação");
            System.out.println("7. Gerar Relatórios");
            System.out.println("8. Testar Autenticação");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            String input = scanner.nextLine();
            try {
                opcao = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                opcao = -1; // Opção inválida
                System.out.println("Entrada inválida. Por favor, digite um número.");
            }

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    cadastrarProfessor();
                    break;
                case 3:
                    cadastrarCurso();
                    break;
                case 4:
                    criarTurma();
                    break;
                case 5:
                    gerenciarAlunosEmTurma();
                    break;
                case 6:
                    lancarAvaliacao();
                    break;
                case 7:
                    gerarRelatorios();
                    break;
                case 8:
                    testarAutenticacao();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 9);
    }

    private static void cadastrarAluno() {
        System.out.println("\n--- Cadastrar Aluno ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Curso: ");
        String curso = scanner.nextLine();

        Aluno novoAluno = new Aluno(nome, login, senha, matricula, curso);
        usuarioRepository.adicionarUsuario(novoAluno);
        System.out.println("Aluno " + nome + " cadastrado com sucesso!");
    }

    private static void cadastrarProfessor() {
        System.out.println("\n--- Cadastrar Professor ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        System.out.print("Registro: ");
        String registro = scanner.nextLine();

        Professor novoProfessor = new Professor(nome, login, senha, especialidade, registro);
        usuarioRepository.adicionarUsuario(novoProfessor);
        System.out.println("Professor " + nome + " cadastrado com sucesso!");
    }

    private static void cadastrarCurso() {
        System.out.println("\n--- Cadastrar Curso ---");
        int tipo;
        try {
            System.out.print("Tipo (1-Presencial, 2-EAD): ");
            tipo = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida para o tipo de curso. Por favor, digite 1 ou 2.");
            return;
        }

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        int cargaHoraria;
        try {
            System.out.print("Carga Horária: ");
            cargaHoraria = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida para a carga horária. Por favor, digite um número inteiro.");
            return;
        }

        Curso novoCurso = null;
        if (tipo == 1) {
            System.out.print("Sala: ");
            String sala = scanner.nextLine();
            novoCurso = new CursoPresencial(nome, codigo, cargaHoraria, sala);
        } else if (tipo == 2) {
            System.out.print("Plataforma Virtual: ");
            String plataforma = scanner.nextLine();
            novoCurso = new CursoEAD(nome, codigo, cargaHoraria, plataforma);
        } else {
            System.out.println("Tipo de curso inválido.");
            return;
        }

        if (novoCurso != null) {
            cursoRepository.adicionarCurso(novoCurso);
            System.out.println("Curso " + nome + " cadastrado com sucesso!");
        }
    }

    private static void criarTurma() {
        System.out.println("\n--- Criar Turma ---");
        System.out.print("Código da Turma: ");
        String codigoTurma = scanner.nextLine();

        System.out.print("Login do Professor: ");
        String loginProfessor = scanner.nextLine();
        Professor professor = (Professor) usuarioRepository.buscarUsuarioPorLogin(loginProfessor);
        if (professor == null) {
            System.out.println("Professor não encontrado.");
            return;
        }

        System.out.print("Código do Curso: ");
        String codigoCurso = scanner.nextLine();
        Curso curso = cursoRepository.buscarCursoPorCodigo(codigoCurso);
        if (curso == null) {
            System.out.println("Curso não encontrado.");
            return;
        }

        Turma novaTurma = turmaService.criarTurma(codigoTurma, professor, curso);
        System.out.println("Turma " + novaTurma.getCodigo() + " criada com sucesso!");
    }

    private static void gerenciarAlunosEmTurma() {
        System.out.println("\n--- Gerenciar Alunos em Turma ---");
        System.out.print("Código da Turma: ");
        String codigoTurma = scanner.nextLine();
        Turma turma = turmaRepository.buscarTurmaPorCodigo(codigoTurma);
        if (turma == null) {
            System.out.println("Turma não encontrada.");
            return;
        }

        int opcao;
        try {
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Remover Aluno");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, digite 1 ou 2.");
            return;
        }

        System.out.print("Login do Aluno: ");
        String loginAluno = scanner.nextLine();
        Aluno aluno = (Aluno) usuarioRepository.buscarUsuarioPorLogin(loginAluno);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        if (opcao == 1) {
            turmaService.adicionarAlunoNaTurma(turma, aluno);
            System.out.println("Aluno " + aluno.getNome() + " adicionado à turma " + turma.getCodigo());
        } else if (opcao == 2) {
            turmaService.removerAlunoDaTurma(turma, aluno);
            System.out.println("Aluno " + aluno.getNome() + " removido da turma " + turma.getCodigo());
        } else {
            System.out.println("Opção inválida.");
        }
    }

    private static void lancarAvaliacao() {
        System.out.println("\n--- Lançar Avaliação ---");
        System.out.print("Código da Turma: ");
        String codigoTurma = scanner.nextLine();
        Turma turma = turmaRepository.buscarTurmaPorCodigo(codigoTurma);
        if (turma == null) {
            System.out.println("Turma não encontrada.");
            return;
        }

        System.out.print("Login do Aluno: ");
        String loginAluno = scanner.nextLine();
        Aluno aluno = (Aluno) usuarioRepository.buscarUsuarioPorLogin(loginAluno);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.print("Descrição da Avaliação: ");
        String descricao = scanner.nextLine();
        double nota;
        try {
            System.out.print("Nota: ");
            nota = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida para a nota. Por favor, digite um número.");
            return;
        }

        Avaliacao avaliacao = new Avaliacao(descricao);
        avaliacao.atribuirNota(nota);
        turmaService.lancarAvaliacao(turma, aluno, avaliacao);
        System.out.println("Avaliação lançada com sucesso para " + aluno.getNome() + " na turma " + turma.getCodigo());
    }

    private static void gerarRelatorios() {
        System.out.println("\n--- Gerar Relatórios ---");
        List<Relatorio> entidadesParaRelatorio = new ArrayList<>();

        // Adiciona todos os usuários (alunos, professores, admin)
        for (Usuario user : usuarioRepository.listarTodosUsuarios()) {
            if (user instanceof Relatorio) {
                entidadesParaRelatorio.add((Relatorio) user);
            }
        }

        // Adiciona todos os cursos
        entidadesParaRelatorio.addAll(cursoRepository.listarTodosCursos());

        // Adiciona todas as turmas (se Turma implementar Relatorio)
        // if (Turma implements Relatorio) {
        //    entidadesParaRelatorio.addAll(turmaRepository.listarTodasTurmas());
        // }
        // Turma não implementa Relatorio, então vamos gerar um resumo da turma
        for (Turma turma : turmaRepository.listarTodasTurmas()) {
            System.out.println("\n" + turmaService.gerarResumoTurma(turma));
            // Para cada aluno na turma, listar suas avaliações
            for (Aluno aluno : turma.getListaAlunos()) {
                System.out.println(turmaService.listarAvaliacoesDoAlunoNaTurma(turma, aluno));
            }
        }


        System.out.println(relatorioService.gerarRelatoriosMultiplos(entidadesParaRelatorio));
    }

    private static void testarAutenticacao() {
        System.out.println("\n--- Testar Autenticação ---");
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Usuario usuario = usuarioRepository.buscarUsuarioPorLogin(login);

        if (usuario instanceof Autenticacao) {
            Autenticacao autenticavel = (Autenticacao) usuario;
            if (autenticavel.autenticar(login, senha)) {
                System.out.println("Autenticação bem-sucedida para " + usuario.getNome() + " (" + usuario.getClass().getSimpleName() + ")");
            } else {
                System.out.println("Falha na autenticação para " + usuario.getNome() + ". Credenciais inválidas.");
            }
        } else {
            System.out.println("Usuário não encontrado ou não autenticável.");
        }
    }
}
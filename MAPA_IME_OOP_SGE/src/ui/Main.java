package ui;

import model.*;
import interfaces.Autenticacao;
import interfaces.Relatorio;
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
    private static TurmaService turmaService = new TurmaService(turmaRepository);
    private static RelatorioService relatorioService = new RelatorioService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("ADS - IMERSAO PROFISSIONAL - OOP - GUSTAVO CAMARA SOARES DE OLIVEIRA");

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
            System.out.println("1. Gerar Relatórios");
            System.out.println("2. Testar Autenticação");
            System.out.println("3. Sair");
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
                    gerarRelatorios();
                    break;
                case 2:
                    testarAutenticacao();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
    }

    private static void gerarRelatorios() {
        System.out.println("\n--- Gerar Relatórios ---");
        List<Relatorio> entidadesParaRelatorio = new ArrayList<>();

        // Adiciona alguns alunos, professores e cursos para o relatório
        entidadesParaRelatorio.add((Relatorio) usuarioRepository.buscarUsuarioPorLogin("aluno.maria"));
        entidadesParaRelatorio.add((Relatorio) usuarioRepository.buscarUsuarioPorLogin("prof.ana"));
        entidadesParaRelatorio.add(turmaRepository.buscarTurmaPorCodigo("T-ES-2023-1").getCurso()); // Curso Presencial
        entidadesParaRelatorio.add(new CursoEAD("Ciência de Dados", "CD001", 2800, "Plataforma Brightspace")); // Novo curso EAD

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
public class Main {
    public static void main(String[] args) {
        //NAO REMOVER
        System.out.println("ADS - IMERSAO PROFISSIONAL - OOP - GUSTAVO CAMARA SOARES DE OLIVEIRA");

        // --- Setup dos Objetos ---
        Aluno aluno1 = new Aluno("Maria Silva", "aluno.maria", "senha123", "2023001", "Engenharia de Software");
        Aluno aluno2 = new Aluno("João Santos", "aluno.joao", "senha456", "2023002", "Ciência da Computação");
        Aluno aluno3 = new Aluno("Ana Paula", "aluno.ana", "senha789", "2023003", "Engenharia de Software");

        Professor professor1 = new Professor("Dr. Ana Costa", "prof.ana", "prof123", "Inteligência Artificial", "P1001");
        Curso curso1 = new CursoPresencial("Engenharia de Software", "ES001", 3600, "Sala 101B");

        Turma turmaES = new Turma("T-ES-2023-1", professor1, curso1);
        turmaES.adicionarAluno(aluno1);
        turmaES.adicionarAluno(aluno2);
        turmaES.adicionarAluno(aluno3);
        turmaES.removerAluno(aluno2);

        // --- Fase 6: Testando Relatórios ---
        System.out.println("\n--- Fase 6: Testando Relatórios ---");

        Curso cursoEAD = new CursoEAD("Ciência de Dados", "CD001", 2800, "Plataforma Brightspace");

        Relatorio[] entidades = {aluno1, professor1, curso1, cursoEAD};

        System.out.println("### Início da Geração de Relatórios ###");
        for (Relatorio entidade : entidades) {
            System.out.println("----------------------------------------");
            System.out.println(entidade.gerarRelatorio());
        }
        System.out.println("----------------------------------------");
        System.out.println("### Fim da Geração de Relatórios ###");


        System.out.println("\n--- Fim dos testes ---");
    }
}
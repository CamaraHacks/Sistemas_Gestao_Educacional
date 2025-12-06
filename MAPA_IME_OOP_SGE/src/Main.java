//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //NAO REMOVER
        System.out.println("ADS - IMERSAO PROFISSIONAL - OOP - GUSTAVO CAMARA SOARES DE OLIVEIRA");

        // Testando a classe Aluno
        Aluno aluno1 = new Aluno("Maria Silva", "2023001", "Engenharia de Software");
        System.out.println("Aluno 1: " + aluno1);

        Aluno aluno2 = new Aluno("João Santos", "2023002", "Ciência da Computação");
        System.out.println("Aluno 2: " + aluno2);

        Aluno aluno3 = new Aluno("Ana Paula", "2023003", "Engenharia de Software");
        System.out.println("Aluno 3: " + aluno3);

        // Testando a classe Professor
        Professor professor1 = new Professor("Dr. Ana Costa", "Inteligência Artificial", "P1001");
        System.out.println("Professor 1: " + professor1);

        Professor professor2 = new Professor("Msc. Pedro Almeida", "Redes de Computadores", "P1002");
        System.out.println("Professor 2: " + professor2);

        // Testando a classe Curso
        Curso curso1 = new Curso("Engenharia de Software", "ES001", 3600);
        System.out.println("Curso 1: " + curso1);
        Curso curso2 = new Curso("Ciência da Computação", "CC001", 3200);
        System.out.println("Curso 2: " + curso2);

        System.out.println("\n--- Testando a classe Turma ---");
        // Criando uma turma
        Turma turmaES = new Turma("T-ES-2023-1", professor1, curso1);
        System.out.println("Turma criada: " + turmaES);

        // Adicionando alunos
        turmaES.adicionarAluno(aluno1);
        turmaES.adicionarAluno(aluno2);
        turmaES.adicionarAluno(aluno3);
        turmaES.adicionarAluno(aluno1); // Tentando adicionar o mesmo aluno novamente

        System.out.println("\nResumo da Turma após adicionar alunos:");
        System.out.println(turmaES.gerarResumo());

        // Removendo um aluno
        turmaES.removerAluno(aluno2);
        turmaES.removerAluno(new Aluno("Aluno Inexistente", "99999", "Nenhum")); // Tentando remover aluno que não existe

        System.out.println("\nResumo da Turma após remover um aluno:");
        System.out.println(turmaES.gerarResumo());

        System.out.println("\n--- Fim dos testes ---");
    }
}
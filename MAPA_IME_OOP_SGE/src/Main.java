public class Main {
    public static void main(String[] args) {
        //NAO REMOVER
        System.out.println("ADS - IMERSAO PROFISSIONAL - OOP - GUSTAVO CAMARA SOARES DE OLIVEIRA");

        // --- Setup dos Objetos ---
          Curso curso1 = new CursoPresencial("Engenharia de Software", "ES001", 3600, "Sala 101B");

               // --- Fase 4: Testando Herança e Polimorfismo ---
        System.out.println("\n--- Fase 4: Testando Herança e Polimorfismo ---");
        Curso cursoEAD = new CursoEAD("Ciência de Dados", "CD001", 2800, "Plataforma Brightspace");

        System.out.println(curso1.detalharCurso());
        System.out.println("\n" + cursoEAD.detalharCurso());

        System.out.println("\n--- Fim dos testes ---");
    }
}
public class Avaliacao {
    private double nota;
    private String descricao;

    public Avaliacao(String descricao) {
        this.descricao = descricao;
        this.nota = -1; // Nota não atribuída
    }

    public void atribuirNota(double valor) {
        if (valor >= 0 && valor <= 10) {
            this.nota = valor;
            System.out.println("Nota " + valor + " atribuída para a avaliação: " + descricao);
        } else {
            System.out.println("Erro: A nota deve estar entre 0 e 10. Valor recebido: " + valor);
        }
    }

    public double getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Avaliacao{"
                + "descricao='" + descricao + '\'' +
                ", nota=" + (nota == -1 ? "N/A" : nota) +
                '}';
    }
}
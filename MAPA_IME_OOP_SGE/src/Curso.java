public abstract class Curso {
    private String nome;
    private String codigo;
    private int cargaHoraria;

    public Curso(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public abstract String detalharCurso();

    @Override
    public String toString() {
        return "Curso{"
               + "nome='" + nome + "'" + ","
               + "codigo='" + codigo + "'" + ","
               + "cargaHoraria=" + cargaHoraria +
               '}';
    }
}
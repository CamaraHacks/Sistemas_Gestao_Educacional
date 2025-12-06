public class CursoPresencial extends Curso {
    private String sala;

    public CursoPresencial(String nome, String codigo, int cargaHoraria, String sala) {
        super(nome, codigo, cargaHoraria);
        this.sala = sala;
    }

    public String getSala() {
        return sala;
    }

    @Override
    public String gerarRelatorio() {
        return "Relatório do Curso Presencial: " + getNome() + " (Cód: " + getCodigo() + ")\n" +
               " - Carga Horária: " + getCargaHoraria() + " horas\n" +
               " - Sala: " + sala;
    }
}

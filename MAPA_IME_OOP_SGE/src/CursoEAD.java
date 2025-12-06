public class CursoEAD extends Curso {
    private String plataformaVirtual;

    public CursoEAD(String nome, String codigo, int cargaHoraria, String plataformaVirtual) {
        super(nome, codigo, cargaHoraria);
        this.plataformaVirtual = plataformaVirtual;
    }

    public String getPlataformaVirtual() {
        return plataformaVirtual;
    }

    @Override
    public String detalharCurso() {
        return "Curso EAD: " + getNome() + " (Cód: " + getCodigo() + ")\n" +
               "Carga Horária: " + getCargaHoraria() + " horas\n" +
               "Plataforma: " + plataformaVirtual;
    }
}

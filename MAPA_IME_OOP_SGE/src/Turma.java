import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno> listaAlunos;

    public Turma(String codigo, Professor professor, Curso curso) {
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
        this.listaAlunos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Curso getCurso() {
        return curso;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void adicionarAluno(Aluno aluno) {
        if (aluno != null && !listaAlunos.contains(aluno)) {
            listaAlunos.add(aluno);
            System.out.println("Aluno " + aluno.getNome() + " adicionado à turma " + codigo);
        } else if (aluno != null) {
            System.out.println("Aluno " + aluno.getNome() + " já está na turma " + codigo);
        }
    }

    public void removerAluno(Aluno aluno) {
        if (aluno != null && listaAlunos.remove(aluno)) {
            System.out.println("Aluno " + aluno.getNome() + " removido da turma " + codigo);
        } else if (aluno != null) {
            System.out.println("Aluno " + aluno.getNome() + " não encontrado na turma " + codigo);
        }
    }

    public String gerarResumo() {
        return "Turma Código: " + codigo +
               "\nProfessor: " + professor.getNome() +
               "\nCurso: " + curso.getNome() +
               "\nQuantidade de Alunos: " + listaAlunos.size();
    }

    @Override
    public String toString() {
        return "Turma{"
               + "codigo='" + codigo + "'\n" +
               ", professor=" + professor.getNome() + "\n" +
               ", curso=" + curso.getNome() + "\n" +
               ", quantidadeAlunos=" + listaAlunos.size() +
               "\n}";
    }
}

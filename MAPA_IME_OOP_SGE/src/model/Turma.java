package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno> listaAlunos;
    private Map<Aluno, List<Avaliacao>> avaliacoes;

    public Turma(String codigo, Professor professor, Curso curso) {
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
        this.listaAlunos = new ArrayList<>();
        this.avaliacoes = new HashMap<>();
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
            avaliacoes.put(aluno, new ArrayList<>());
            System.out.println("Aluno " + aluno.getNome() + " adicionado à turma " + codigo);
        } else if (aluno != null) {
            System.out.println("Aluno " + aluno.getNome() + " já está na turma " + codigo);
        }
    }

    public void removerAluno(Aluno aluno) {
        if (aluno != null && listaAlunos.remove(aluno)) {
            avaliacoes.remove(aluno);
            System.out.println("Aluno " + aluno.getNome() + " removido da turma " + codigo);
        } else if (aluno != null) {
            System.out.println("Aluno " + aluno.getNome() + " não encontrado na turma " + codigo);
        }
    }

    public void lancarAvaliacao(Aluno aluno, Avaliacao avaliacao) {
        if (aluno != null && listaAlunos.contains(aluno)) {
            avaliacoes.get(aluno).add(avaliacao);
            System.out.println("Avaliação '" + avaliacao.getDescricao() + "' lançada para o aluno " + aluno.getNome());
        } else {
            System.out.println("Não foi possível lançar a avaliação. Aluno não encontrado na turma.");
        }
    }

    public String listarAvaliacoesDoAluno(Aluno aluno) {
        if (aluno != null && avaliacoes.containsKey(aluno)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Avaliações de ").append(aluno.getNome()).append(" na turma ").append(codigo).append(":\n");
            List<Avaliacao> lista = avaliacoes.get(aluno);
            if (lista.isEmpty()) {
                sb.append("Nenhuma avaliação lançada.\n");
            } else {
                for (Avaliacao av : lista) {
                    sb.append("- ").append(av).append("\n");
                }
            }
            return sb.toString();
        }
        return "Aluno não encontrado na turma.";
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

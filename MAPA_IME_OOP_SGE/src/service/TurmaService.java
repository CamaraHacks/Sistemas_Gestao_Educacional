package service;

import model.Aluno;
import model.Avaliacao;
import model.Curso;
import model.Professor;
import model.Turma;
import repository.TurmaRepository;

public class TurmaService {
    private TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public Turma criarTurma(String codigo, Professor professor, Curso curso) {
        Turma turma = new Turma(codigo, professor, curso);
        turmaRepository.adicionarTurma(turma);
        return turma;
    }

    public void adicionarAlunoNaTurma(Turma turma, Aluno aluno) {
        if (turma != null && aluno != null) {
            turma.adicionarAluno(aluno);
        }
    }

    public void removerAlunoDaTurma(Turma turma, Aluno aluno) {
        if (turma != null && aluno != null) {
            turma.removerAluno(aluno);
        }
    }

    public void lancarAvaliacao(Turma turma, Aluno aluno, Avaliacao avaliacao) {
        if (turma != null && aluno != null && avaliacao != null) {
            turma.lancarAvaliacao(aluno, avaliacao);
        }
    }

    public String listarAvaliacoesDoAlunoNaTurma(Turma turma, Aluno aluno) {
        if (turma != null && aluno != null) {
            return turma.listarAvaliacoesDoAluno(aluno);
        }
        return "Turma ou Aluno inválido.";
    }

    public String gerarResumoTurma(Turma turma) {
        if (turma != null) {
            return turma.gerarResumo();
        }
        return "Turma inválida.";
    }
}

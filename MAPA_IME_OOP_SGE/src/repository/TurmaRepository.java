package repository;

import model.Aluno;
import model.Turma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurmaRepository {
    private static List<Turma> turmas = new ArrayList<>();

    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }

    public Turma buscarTurmaPorCodigo(String codigo) {
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigo)) {
                return turma;
            }
        }
        return null;
    }

    public List<Turma> listarTodasTurmas() {
        return new ArrayList<>(turmas);
    }
}

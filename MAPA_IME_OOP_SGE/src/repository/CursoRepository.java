package repository;

import model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoRepository {
    private static List<Curso> cursos = new ArrayList<>();

    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        return null;
    }

    public List<Curso> listarTodosCursos() {
        return new ArrayList<>(cursos);
    }
}

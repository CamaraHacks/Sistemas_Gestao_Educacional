package repository;

import model.Usuario;
import model.Aluno;
import model.Professor;
import model.Administrador;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
    private static List<Usuario> usuarios = new ArrayList<>();

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario buscarUsuarioPorLogin(String login) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> listarTodosUsuarios() {
        return new ArrayList<>(usuarios);
    }
}

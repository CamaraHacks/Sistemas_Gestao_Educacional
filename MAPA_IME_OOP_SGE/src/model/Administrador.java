package model;

import interfaces.Autenticacao;

public class Administrador extends Usuario implements Autenticacao {

    public Administrador(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    @Override
    public boolean autenticar(String login, String senha) {
        return getLogin().equals(login) && getSenha().equals(senha);
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "nome='" + getNome() + "'" +
                '}';
    }
}

package model;

import interfaces.Autenticacao;
import interfaces.Relatorio;

public class Professor extends Usuario implements Autenticacao, Relatorio {
    private String especialidade;
    private String registro;

    public Professor(String nome, String login, String senha, String especialidade, String registro) {
        super(nome, login, senha);
        this.especialidade = especialidade;
        this.registro = registro;
    }

    @Override
    public boolean autenticar(String login, String senha) {
        return getLogin().equals(login) && getSenha().equals(senha);
    }

    @Override
    public String gerarRelatorio() {
        return "Relatório do Professor:\n" +
               " - Nome: " + getNome() + "\n" +
               " - Especialidade: " + getEspecialidade() + "\n" +
               " - Registro: " + getRegistro();
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getRegistro() {
        return registro;
    }

    @Override
    public String toString() {
        return "Professor{" +
               "nome='" + getNome() + '\'' +
               ", especialidade='" + especialidade + '\'' +
               ", registro='" + registro + '\'' +
               '}';
    }
}
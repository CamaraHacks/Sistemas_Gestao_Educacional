package model;

import interfaces.Relatorio;

public abstract class Curso implements Relatorio {
    private String nome;
    private String codigo;
    private int cargaHoraria;

    public Curso(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public abstract String gerarRelatorio();

    @Override
    public String toString() {
        return "Curso{"
               + "nome='" + nome + "'" + ","
               + "codigo='" + codigo + "'" + ","
               + "cargaHoraria=" + cargaHoraria +
               '}';
    }
}
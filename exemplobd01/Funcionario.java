package com.example.exemplobd01;

public class Funcionario {

    private long codigo;
    private String nome;
    private String cargo;

    public Funcionario(long codigo, String nome, String cargo) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return codigo + " - " + nome + " - " + cargo;
    }
}

package com.example.le1questao7;

public class Funcionario {
    private int codigo;
    private String nome;
    private String sexo;
    private String cargo;

    public Funcionario(int codigo, String nome, String sexo, String cargo) {
        this.codigo = codigo;
        this.nome = nome;
        this.sexo = sexo;
        this.cargo = cargo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}

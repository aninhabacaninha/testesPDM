package com.example.le1questao7;

public class Funcionario {
    private int codigo;
    private String nome;
    private String sexo;
    private int idade;
    private String cargo;

    public Funcionario() {
    }

    public Funcionario(int codigo, String nome, String sexo, int idade, String cargo) {
        this.codigo = codigo;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}

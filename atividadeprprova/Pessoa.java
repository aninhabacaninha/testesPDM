package com.example.atividadeprprova;

import java.util.Date;

public class Pessoa {
    private long id;
    private String nome;
    private int idade;
    private Date dataNasc;

    public Pessoa(long id, String nome, int idade, Date dataNasc) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.dataNasc = dataNasc;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public Date getDataNasc() { return dataNasc; }
    public void setDataNasc(Date dataNasc) { this.dataNasc = dataNasc; }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", dataNasc=" + dataNasc +
                '}';
    }
}

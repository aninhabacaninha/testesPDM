package com.example.anaclaraannasophia;

public class Usuario {
    private long id;
    private String nomeUsuario;
    private String email;
    private int senha;

    public Usuario(long id, String nomeUsuario, String email, int senha) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nomeUsuario, String email, int senha) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getSenha() { return senha; }
    public void setSenha(int senha) { this.senha = senha; }

    public String toString() {
        return "Usuario { " +
                "id = " + id +
                ", nome = '" + nomeUsuario + "'" +
                ", email = '" + email + "'" +
                ", senha = '" + senha + "'" +
                "}";
    }
}
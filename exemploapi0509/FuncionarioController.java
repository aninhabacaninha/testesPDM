package com.example.exemploapi0509;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {

    private final List<Funcionario> funcionarios;
    private Context contexto;
    private static FuncionarioController instancia = null;

    private FuncionarioController(Context contexto)
    {
        this.contexto = contexto;
        funcionarios = new ArrayList<>();
    }

    public static FuncionarioController getInstancia(Context contexto){
        if (instancia == null)
            instancia = new FuncionarioController(contexto);
        return instancia;
    }

    public boolean cadastrar(Funcionario funcionario){
        FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio(contexto);
        long resultado = funcionarioRepositorio.inserir(funcionario);
        if (resultado != -1)
            return true;
        else
            return false;
    }

    public List<Funcionario> buscarTodos(){
        FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio(contexto);
        List<Funcionario> funcionarios = funcionarioRepositorio.buscarTodosFuncionarios();
        return funcionarios;
    }

    public Funcionario buscarPorPosicao(int posicao)
    {
        return funcionarios.get(posicao);
    }

    public void atualizarLista(){
        funcionarios.clear();
        funcionarios.addAll(buscarTodos());
    }



}

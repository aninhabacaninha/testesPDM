package com.example.le1questao7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListaFuncionariosAdapter extends BaseAdapter {
    Context context;
    List<Funcionario> funcionarios = new ArrayList<>();

    public ListaFuncionariosAdapter(Context context, List<Funcionario> funcionarios) {
        this.context = context;
        this.funcionarios = funcionarios;
    }

    @Override
    public int getCount() {
        return funcionarios.size();
    }

    @Override
    public Funcionario getItem(int position) {
        return funcionarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return funcionarios.get(position).getCodigo();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context)
                .inflate(
                        R.layout.item_lista_funcionarios,
                        parent,
                        false);
        TextView textViewNome = v.findViewById(R.id.item_lista_funcionarios_textView_nome);
        TextView textViewSexo = v.findViewById(R.id.item_lista_funcionarios_textView_sexo);
        TextView textViewCargo = v.findViewById(R.id.item_lista_funcionarios_textView_cargo);

        Funcionario funcionario = funcionarios.get(position);
        textViewNome.setText(funcionario.getNome());
        textViewSexo.setText((funcionario.getSexo()=='M'?"Masculino":"Feminino"));
        textViewCargo.setText(funcionario.getCargo());

        return v;
    }
}

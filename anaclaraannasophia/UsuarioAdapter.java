package com.example.anaclaraannasophia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UsuarioAdapter extends BaseAdapter {

    Context context;
    List<Usuario> usuarios = new ArrayList<>();
    UsuarioRepositorio usuRep;

    public UsuarioAdapter(Context context) {
        this.context = context;
        usuRep.buscarTodos();
        atualizarLista();
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Usuario getItem(int position) {
        return usuarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return usuarios.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context)
                .inflate(
                        R.layout.item_lista,
                        parent,
                        false
                );

        TextView txtVNome = v.findViewById(R.id.textView_nome);
        TextView txtVEmail = v.findViewById(R.id.textView_email);
        TextView txtVSenha = v.findViewById(R.id.textView_senha);

        Usuario usuario = usuarios.get(position);
        txtVNome.setText(usuario.getNomeUsuario());
        txtVEmail.setText(usuario.getEmail());
        txtVSenha.setText(usuario.getSenha());

        return v;
    }

    private void atualizarLista() {
        usuarios.clear();
        usuarios.addAll(usuRep.buscarTodos());
        notifyDataSetChanged();
    }
}
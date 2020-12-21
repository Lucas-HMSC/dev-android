package com.example.listadetarefas.helper;

import com.example.listadetarefas.model.Tarefa;

import java.util.List;

public interface I_TarefaDAO {

    public boolean salvar(Tarefa tarefa);
    public boolean atualizar(Tarefa tarefa);
    public boolean deletar(Tarefa tarefa);
    public List<Tarefa> listar();
}

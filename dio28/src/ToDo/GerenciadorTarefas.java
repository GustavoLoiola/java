package ToDo;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {
    private List<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefas(Tarefa novaTarefa) {
        tarefas.add(novaTarefa);
    }

    public void listarTarefas() {
        if(this.tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa foi cadastrada!");
            return;
        }
        System.out.println("==================================");
        this.tarefas.forEach(System.out::println);
        System.out.println("==================================");
    }

    public void atualizarTarefas(Tarefa nomeTarefa, Byte option) {
        if(option == 1) {
            nomeTarefa.setStatus(Status.EM_ANDAMENTO);
        }
        else if(option == 2) {
            nomeTarefa.setStatus(Status.CONCLUIDA);
        }
        else {
            System.out.println("Erro! opção inválida.");
        }
    }

    public void exibirStatus() {
        if(tarefas.isEmpty()) {
            System.out.println("Não existem tarefas na lista para poder listar os Status.");
            return;
        }

        System.out.println("==================================");
        for (Tarefa tarefa : tarefas) {
            System.out.println("Tarefa: " + tarefa.getNome() + " | Status: " + tarefa.getStatus());
            System.out.println("==================================");
        }
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }
}
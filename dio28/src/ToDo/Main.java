package ToDo;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        GerenciadorTarefas gerenciador = new GerenciadorTarefas();

        while(true) {
            System.out.println("==================================");
            System.out.println("TO-DO LIST");
            System.out.println("==================================");
            System.out.println("1 - Adicionar Tarefa");
            System.out.println("2 - Listar Tarefas");
            System.out.println("3 - Atualizar Status de uma tarefa");
            System.out.println("4 - Exibir Status das tarefas");
            System.out.println("0 - Sair");
            System.out.println("Digite o número da opção que deseja selecionar: ");
            byte option = input.nextByte();
            input.nextLine();
            if(option == 0) {
                System.out.println("Fim do programa!");
                break;
            }

            if(option == 1) {
                Tarefa novaTarefa = new Tarefa();
                System.out.println("Digite o nome da tarefa que deseja adicionar: ");
                String nomeTarefa = input.nextLine();
                novaTarefa.setNome(nomeTarefa);
                System.out.println("Digite a descrição da tarefa que deseja adicionar: ");
                String descTarefa = input.nextLine();
                novaTarefa.setDesc(descTarefa);

                gerenciador.adicionarTarefas(novaTarefa);

                System.out.println("Tarefa adicionada com sucesso!");
            }
            if(option == 2) {
                gerenciador.listarTarefas();
            }
            if(option == 3) {
                System.out.println("Digite o nome da tarefa em que deseja atualizar os status: ");
                String tarefaParaAtualizar = input.nextLine();

                System.out.println("A tarefa esta em andamento ou foi concluída?");
                System.out.println("1 - Em andamento");
                System.out.println("2 - Concluída");

                Byte opcaoStatus = input.nextByte();
                input.nextLine();
                boolean encontrado = false;

                for (int i = 0; i < gerenciador.getTarefas().size(); i++) {
                    Tarefa atual = gerenciador.getTarefas().get(i);


                    if(atual.getNome().equals(tarefaParaAtualizar)) {
                        gerenciador.atualizarTarefas(atual, opcaoStatus);
                        System.out.println("Tarefa atualizada com sucesso!");
                        encontrado = true;
                        break;
                    }
                }
                if(!encontrado) {
                    System.out.println("Tarefa não encontrada!");
                }
            }
            if(option == 4) {
                gerenciador.exibirStatus();
            }
        }
    input.close();

    }
}
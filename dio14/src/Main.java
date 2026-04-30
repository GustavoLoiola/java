import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Usuario> usuarios = new ArrayList<>();

        Scanner entrada = new Scanner(System.in);

        int proxId = 1;

        while(true) {
            System.out.println("---CADASTRO DE USUÁRIOS---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Ver todos os usuarios");
            System.out.println("3 - Buscar por Id");
            System.out.println("4 - Editar usuário");
            System.out.println("5 - Excluir usuário");
            System.out.println("0 - Sair");
            int opc = entrada.nextInt();
            entrada.nextLine();

            if (opc == 1) {
                Usuario usuario = new Usuario();

                usuario.setId(proxId++);

                System.out.println("Digite o nome do Usuário: ");
                String nome = entrada.nextLine();

                 if (nome.length()< 2) {
                     while(nome.length()< 2) {
                         System.out.println("Nome inválido! O nome deve conter pelo menos 2 caracteres.");
                         System.out.println("Digite o nome do Usuário: ");
                         nome = entrada.nextLine();
                     }
                }

                usuario.setNome(nome);

                System.out.println("Digite a idade do Usuário: ");
                int idade = entrada.nextInt();

                if (idade > 130 || idade < 0) {
                    while(idade > 130 || idade < 0) {
                        System.out.println("Idáde inválida! Por favor tente novamente!");
                        System.out.println("Digite a idade do Usuário: ");
                        idade = entrada.nextInt();
                    }
                }

                entrada.nextLine();
                usuario.setIdade(idade);

                System.out.println("Digite o email do Usuário: ");
                String email = entrada.nextLine();

                if (!email.contains("@") || !email.contains(".")) {
                    while(!email.contains("@") || !email.contains(".")) {
                        System.out.println("O email digitado não corresponde a um email válido! Tente novamente");
                        System.out.println("Digite o email do Usuário: ");
                        email = entrada.nextLine();
                    }
                }

                usuario.setEmail(email);

                usuarios.add(usuario);
                System.out.printf("Usuário %s cadastrado com sucesso!%n", usuario.getNome());
            }
            else if (opc == 2) {
                if(usuarios.isEmpty()) {
                    System.out.println("Nenhum usuário encontrado!");
                }

                else {
                    System.out.println("===============================");
                    for (Usuario u : usuarios) {
                        System.out.printf("Id: %d%n", u.getId());
                        System.out.printf("Nome: %s%n", u.getNome());
                        System.out.printf("Idade: %d%n", u.getIdade());
                        System.out.printf("Email: %s%n", u.getEmail());
                        System.out.println("===============================");
                    }
                }

            }
            else if (opc == 3) {
                boolean encontrado = false;

                System.out.println("Digite o Id do usuário: ");
                int buscaId = entrada.nextInt();
                entrada.nextLine();

                for(Usuario u : usuarios) {
                    if(u.getId() == buscaId) {
                        System.out.println("===============================");
                        System.out.printf("Id: %d%n", u.getId());
                        System.out.printf("Nome: %s%n", u.getNome());
                        System.out.printf("Idade: %d%n", u.getIdade());
                        System.out.printf("Email: %s%n", u.getEmail());
                        System.out.println("===============================");
                        encontrado = true;
                        break;
                    }
                }
                if(!encontrado) {
                    System.out.println("Não existe nenhum usuário com esse Id!");
                }
            }

            else if(opc == 4) {
                boolean encontrado = false;

                System.out.println("Digite o Id do usuário que deseja atualizar: ");
                int buscaId = entrada.nextInt();
                entrada.nextLine();

                for(Usuario u : usuarios) {
                    if (u.getId() == buscaId) {
                        System.out.println("Digite o que deseja atualizar: ");
                        System.out.println("1 - Nome");
                        System.out.println("2 - Idade");
                        System.out.println("3 - Email");

                        int attOpc = entrada.nextInt();
                        entrada.nextLine();

                        if (attOpc == 1) {
                            System.out.println("Digite o novo nome do usuário: ");
                            String novoNome = entrada.nextLine();

                            while (novoNome.length() < 2) {
                                System.out.println("Nome inválido! Tente novamente!");
                                System.out.println("Digite o novo nome do usuário: ");
                                novoNome = entrada.nextLine();
                            }

                            u.setNome(novoNome);
                            System.out.println("Nome atualizado com sucesso!");
                        } else if (attOpc == 2) {
                            System.out.println("Digite a nova idade do usuário: ");
                            int novaIdade = entrada.nextInt();

                            while (novaIdade > 120 || novaIdade < 0) {
                                System.out.println("Idade inválida! Tente novamente!");
                                System.out.println("Digite a nova idade do usuário: ");
                                novaIdade = entrada.nextInt();
                            }

                            u.setIdade(novaIdade);
                            System.out.println("Idade atualizada com sucesso!");
                        } else if (attOpc == 3) {
                            System.out.println("Digite o novo Email do usuário: ");
                            String novoEmail = entrada.nextLine();

                            while (!novoEmail.contains("@") || !novoEmail.contains(".")) {
                                System.out.println("Email inválido! Tente novamente!");
                                System.out.println("Digite o novo Email do usuário: ");
                                novoEmail = entrada.nextLine();
                            }

                            u.setEmail(novoEmail);
                            System.out.println("Email atualizado com sucesso!");
                        }
                        encontrado = true;
                        break;
                        }

                }
                    if(!encontrado) {
                        System.out.println("Não existe nenhum usuário com esse Id!");

                }
            }

            else if(opc == 5) {
                boolean encontrado = false;

                System.out.println("Digite o Id do usuário que deseja excluir: ");

                int buscaId = entrada.nextInt();
                entrada.nextLine();

                for(Usuario u : usuarios) {
                    if(u.getId() == buscaId) {
                        encontrado = true;
                        System.out.printf("Digite S para confirmar e excluir o usuário: %s%n", u.getNome());
                        String delOpc = entrada.nextLine();
                        if(delOpc.toUpperCase().equals("S")) {
                            System.out.printf("Usuário %s excluído!%n", u.getNome());
                            usuarios.remove(u);
                        }
                        else {
                            System.out.println("Usuário NÃO excluído.");
                        }
                        break;
                    }
                }
                if(!encontrado) {
                    System.out.println("Não existe nenhum usuário com esse ID.");
                }
            }

            else if (opc == 0) {
              break;
            }
            else {
                System.out.println("Opção inválida!");
            }
        }

        System.out.println("Fim do programa!");
        entrada.close();
    }
}
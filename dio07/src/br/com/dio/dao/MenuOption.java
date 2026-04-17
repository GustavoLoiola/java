package br.com.dio.dao;

import java.util.function.Consumer;
import br.UserDAO;

public enum MenuOption {

    SAVE(dao -> System.out.println("Salvar")),
    UPDATE(dao -> System.out.println("Atualizar")),
    DELETE(dao -> System.out.println("Deletar")),
    FIND_BY_ID(dao -> System.out.println("Buscar por ID")),
    FIND_ALL(dao -> System.out.println("Listar todos")),
    EXIT(dao -> System.out.println("Sair"));

    private final Consumer<UserDAO> callback;

    MenuOption(Consumer<UserDAO> callback) {
        this.callback = callback;
    }

    public void execute(UserDAO dao) {
        callback.accept(dao);
    }
}
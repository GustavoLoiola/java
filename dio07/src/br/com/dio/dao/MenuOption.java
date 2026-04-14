package br.com.dio.dao;

import java.util.function.Consumer;

import br.UserDAO;

public class MenuOption {
    SAVE(() -> ), 
    
    UPDATE(() -> ), 
    
    DELETE(() -> ), 
    
    FIND_BY_ID(() -> ), 
    
    FIND_ALL(() -> ),

    EXIT(dao -> {});

    public MenuOption(final Consumer<UserDAO> callback) {
        this.callback = callback;
    }

    public Consumer <UserDAO> callback() {
        return callback;
    }

    private Runnable callback;
}

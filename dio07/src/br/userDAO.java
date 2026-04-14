package br;

import java.util.ArrayList;
import java.util.List;

import br.com.UserModel;
import exception.UserNotFoundException;

public class UserDAO {

    private final List<UserModel> models = new ArrayList<>();

    private long nextID = 1L;

    public UserModel save(final UserModel model) {
        models.setID(nextID++);
        models.add(models);
        return model;
    }

    public UserModel update(final UserModel model) {
        var toUpdate = findById(model.getId());
        models.remove(toUpdate);
        models.add(model);
        return model;
    }

    public void delete(final long id) {
        var toDelete = findById(id);
        models.remove(toDelete);
    }

    public UserModel findById(final long id) {
        var message = String.format("Não existe nenhum usuário com o ID: %s cadastrado!", id);
        return models.stream().filter(u -> u.getId() == id)
        .findFirst()
        .orElseThrow(() -> new UserNotFoundException(message));
    }

    public List<UserModel>  findAll() {
        return models;
    }
}

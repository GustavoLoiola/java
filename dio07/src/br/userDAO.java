package br;

import java.util.ArrayList;
import java.util.List;

import br.com.UserModel;

public class userDAO {
    private List<UserModel> models = new ArrayList<>();

    public UserModel save(final UserModel model) {
         models.add(model);
        return model;
    };
}

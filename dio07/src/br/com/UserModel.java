package br.com;

import java.time.OffsetDateTime;
import java.util.Objects;

public class UserModel {
    private long id;
    private String name;
    private String email;
    private OffsetDateTime birthday;


    public UserModel(Long id, String name, String email, OffsetDateTime birthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public OffsetDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(OffsetDateTime birthday) {
        this.birthday = birthday;
    }

    
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof UserModel userModel)) return false;
        return id == userModel.id &&
               Objects.equals(name, userModel.name) &&
               Objects.equals(email, userModel.email) &&
               Objects.equals(birthday, userModel.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, birthday);
    }

    // toString
    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
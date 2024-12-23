package org.knit.lab11;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    UserDAO userDAOImpl;

    public UserService() throws SQLException {
        userDAOImpl = new UserDAOImpl();
    }

    public void registerUser(String name, String email) throws SQLException {
        if (!userDAOImpl.emailExists(email)){
            userDAOImpl.create(new User(name, email));
        }
        else {
            System.out.println("Ошибка! Пользователь с такой почтой уже существует");
        }
    }

    public List<User> listAllUsers() throws SQLException {
        return userDAOImpl.findAll();
    }

    public void deleteUser(int id) throws SQLException {
        User toDelete = userDAOImpl.findById(id);
        if (toDelete != null){
            userDAOImpl.delete(id);
        }
        else {
            System.out.println("Ошибка! пользователя с таким id нет в датабазе");
        }
    }

    public void updateUser(int id, String newName, String newEmail) throws SQLException {
        User toUpdate = userDAOImpl.findById(id);
        if (toUpdate != null){
            userDAOImpl.update(new User(id, newName, newEmail));
        }
        else {
            System.out.println("Ошибка! пользователя с таким id нет в датабазе");
        }
    }
}

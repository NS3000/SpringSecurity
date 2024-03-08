package org.example.Service;

import org.example.Entity.User;
import org.springframework.ui.Model;

import java.util.List;

public interface UserService {
    public void createUser(User user);


    public User getCurrentUser();

     public void editUser(int userId, User updateduser);

    public void deleteUser(String username);
    public List<User> listAll();

}

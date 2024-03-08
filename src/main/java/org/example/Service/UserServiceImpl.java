package org.example.Service;

import org.example.Entity.User;
import org.example.Repository.UserRepository;
import org.example.config.WebSecurityConfigDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.server.MethodNotAllowedException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(User user){
        User newUser = new User(user.getUsername(), WebSecurityConfigDB.passwordEncoder().encode(user.getPassword()),user.getRole());
        userRepository.save(newUser);
    }

    @Override
    public User getCurrentUser() {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(currentUsername);
    }


    @Override
    public void editUser(int userId, User updateduser) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setUsername(updateduser.getUsername());
        user.setPassword(updateduser.getPassword());
        user.setRole(updateduser.getRole());
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String username) {
        String currentUser= SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        if(user==null) {
            throw new UsernameNotFoundException("UserName Not Fount");
        }
        else if(!user.getUsername().equals(currentUser)){
            userRepository.deleteById(user.getId());
        }
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }
}

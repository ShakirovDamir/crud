package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    void add(User user);
    void delete(int id);
    void update(User user);
    User getById (int id);
}

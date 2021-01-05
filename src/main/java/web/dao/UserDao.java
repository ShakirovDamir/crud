package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> listUsers();
    void add(User user);
    void delete(int id);
    void update(User user);
    User getById (int id);

}

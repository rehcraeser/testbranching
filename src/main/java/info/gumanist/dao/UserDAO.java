package info.gumanist.dao;

import info.gumanist.domain.User;
import java.util.List;

public interface UserDAO {
    public void addUser(User user);
    public List<User> getAllUsers();
    public void deleteUser(Long userId);
}

package info.gumanist.service;

import java.util.List;
import info.gumanist.domain.User;

public interface UserManager {
    public void addUser(User user);
    public List<User> getAllUsers();
    public void deleteUser(Long userId);
}

package tech.ericwathome.unforgettable.user;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User addUser(User user);

    List<User> getUsers();

    Optional<User> getUser(Long userId);

    User updateUser(User user, Long userId);

    void deleteUser(Long userId);

    User getUserByUserName(String username);
}

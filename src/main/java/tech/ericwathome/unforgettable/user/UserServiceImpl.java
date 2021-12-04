package tech.ericwathome.unforgettable.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User updateUser(User user, Long userId) {
        User userDb = userRepository.findById(userId).get();

        if (Objects.nonNull(user.getUsername()) &&
        !"".equalsIgnoreCase(user.getUsername())){
            userDb.setUsername(user.getUsername());
        }

        if (Objects.nonNull(user.getFirstName()) &&
                !"".equalsIgnoreCase(user.getFirstName())){
            userDb.setFirstName(user.getFirstName());
        }

        if (Objects.nonNull(user.getLastName()) &&
                !"".equalsIgnoreCase(user.getLastName())){
            userDb.setLastName(user.getLastName());
        }

        if (Objects.nonNull(user.getEmail()) &&
                !"".equalsIgnoreCase(user.getEmail())){
            userDb.setEmail(user.getEmail());
        }

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

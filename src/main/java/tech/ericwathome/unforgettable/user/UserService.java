package tech.ericwathome.unforgettable.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();

        userRepository.findAll()
                .forEach(allUsers::add);
        return allUsers;
    }
}

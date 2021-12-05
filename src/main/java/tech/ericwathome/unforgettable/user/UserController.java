package tech.ericwathome.unforgettable.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.ericwathome.unforgettable.exceptions.UserNotFoundException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/users")
    public User addUser(@Valid @RequestBody User user){
        LOGGER.info("Inside addUser method in UserController");
        return userService.addUser(user);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        LOGGER.info("Inside getUsers method in UserController");
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable("id") Long userId) throws UserNotFoundException {
        return userService.getUser(userId);
    }

    @GetMapping("users/user/{name}")
    public User getUserByUserName(@PathVariable("name") String username){
        return userService.getUserByUserName(username);
    }

    @PutMapping("/users/{id}")
    public User editUser(@Valid @RequestBody User user, @PathVariable("id") Long userId){
        LOGGER.info("Inside editUser method in UserController");
        return userService.updateUser(user, userId);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return "User deleted successfully";
    }
}

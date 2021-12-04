package tech.ericwathome.unforgettable.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User addUser(@Valid @RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable("id") Long userId){
        return userService.getUser(userId);
    }

    @PutMapping("/users/{id}")
    public User editUser(@Valid @RequestBody User user, @PathVariable("id") Long userId){
        return userService.updateUser(user, userId);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return "User deleted successfully";
    }
}

package in.codingage.blooms.Controller;

import in.codingage.blooms.dto.UserRequest;
import in.codingage.blooms.models.User;
import in.codingage.blooms.repository.UserRepository;
import in.codingage.blooms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
   private UserService userService;
    @PatchMapping("/register")
    public String registerUser(@RequestBody UserRequest request){

        return userService.registerUser(request);
    }
     @PostMapping("/login")
    public User loginUser(@RequestParam String username, @RequestParam String password){
        return userService.loginUser(username,password);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAll();
    }
}

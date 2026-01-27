package in.codingage.blooms.service;

import in.codingage.blooms.dto.UserRequest;
import in.codingage.blooms.models.User;
import in.codingage.blooms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  @Autowired
    private UserRepository userRepository;

  public String registerUser(UserRequest request){
      if (userRepository.findByUsername(request.getUsername()).isPresent()){
          return "Error : username" + request.getUsername() + "Already exsits";
      }
      if (userRepository.findByEmail(request.getEmail()).isPresent()){
          return "Error : Email" + request.getEmail() + "is Already register ";
      }
       User newUser=new User();
      newUser.setUsername(request.getUsername());
      newUser.setPassword(request.getPassword());
      newUser.setEmail(request.getEmail());
      newUser.setProfileUrl(request.getProfileUrl());

      User savedUser=userRepository.save(newUser);
      return "Success : User registered with ID" + savedUser.getId();
      }

      public  User loginUser(String username,String password){
      User user=userRepository.findByUsername(username).orElse(null);
      if (user!=null && user.getPassword().equals(password)){
          return user;
      }
      return null;
  }
  public List<User> getAll(){
      return userRepository.findAll();
  }
}

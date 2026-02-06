package in.codingage.blooms.dto;

import javax.management.relation.Role;

public class UserResponse {
    private String id;
    private String username;
    private  String email;
    private String name;
    private  String profileUrl;
    private Role role;
    private UserResponse userResponse;

    public UserResponse(){

    }

    //constructor for easy conversation
    public UserResponse(String id,String username,String email,String name,String profileUrl){
        this.id=id;
        this.username=username;
        this.email=email;
        this.name=name;
        this.profileUrl=profileUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail(String email) {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public void setUserId(String id) {
        this.id=id;
    }

    public void setRole(Role role) {
        this.role=role;
    }

    public void add(UserResponse userResponse) {
        this.userResponse=userResponse;
    }
}

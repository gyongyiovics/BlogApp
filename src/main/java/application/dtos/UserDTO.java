package application.dtos;

import application.models.User;
import application.models.Role;

public class UserDTO {
    private String username;
    private String password;

    public UserDTO() {
    }

    /**
     * with or without role?
     */

    /*
    public UserDTO(String username, String password, Role usersRole) {
    }
    */
    public UserDTO(String username) {
        this.username = username;
    }

    public UserDTO(String username, String password) {
        this(username);
        this.password = password;
    }

    /*
    public UserDTO(User user) {
        this(user.getUsername(), user.getPassword(), user.getUsersRole());
    }
    */

    public UserDTO(User user) {
        this(user.getUsername(), user.getPassword());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

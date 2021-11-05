package application.models;

import application.dtos.UserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {
    //@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Id
    private String userName;
    private String passWord;
    @Enumerated(EnumType.STRING)
    private Role usersRole; //FK: role_table(role_name) and enum
    private boolean isLocked;
    @OneToMany(mappedBy = "owner")
    private List<Blog> ownBlogs;

    public User() {
        List<Blog> ownBlogs = new ArrayList<>();
    }


    public User(String userName, String passWord, Role usersRole) {
        this.userName = userName;
        this.passWord = passWord;
        this.usersRole = usersRole;
    }

    public User(UserDTO userDTO, Role role) {
        this(userDTO.getUsername(), userDTO.getPassword(), role);
    }

    /*public User(String userName, String passWord, Role role) {
        this.userName = userName;
        this.passWord = passWord;
        this.usersRole = role;
    }*/

    public User(long id,
                String userName,
                String passWord,
                Role usersRole,
                boolean isLocked,
                List<Blog> ownBlogs) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.usersRole = usersRole;
        this.isLocked = isLocked;
        this.ownBlogs = ownBlogs;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !isLocked;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !isLocked;
    }

    @Override
    public boolean isEnabled() {
        return !isLocked;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list = new ArrayList<>();

        for (Authority auth : usersRole.authorities) {
            list.add(new SimpleGrantedAuthority(auth.toString()));
        }

        return null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Role getUsersRole() {
        return usersRole;
    }

    public void setUsersRole(Role usersRole) {
        this.usersRole = usersRole;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean unLocked) {
        isLocked = unLocked;
    }

    public List<Blog> getOwnBlogs() {
        return ownBlogs;
    }

    public void setOwnBlogs(List<Blog> ownBlogs) {
        this.ownBlogs = ownBlogs;
    }
}

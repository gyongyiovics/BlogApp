package application.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {
    @Id
    private long id;
    private String userName;
    private String passWord;
    //@Column(columnDefinition = "DEFAULT 'UNREGISTERED'")
    @Enumerated(EnumType.STRING)
    private Role usersRole; //FK: role_table(role_name) and enum
    //private RoleName usersRole = RoleName.UNREGISTERED;
    private boolean isLocked;
    //@OneToMany(mappedBy = "owner")
    //private List<Blog> ownBlogs;
    //@OneToMany(mappedBy = "userName")
    //private List<Note> ownNotes;

    public User() {
        /*List<Blog> ownBlogs = new ArrayList<>();
        List<Note> ownNotes = new ArrayList<>();*/
    }

    public User(long id, String userName, String passWord, Role usersRole) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.usersRole = usersRole;
    }

    public User(long id,
                String userName,
                String passWord,
                Role usersRole,
                boolean isUnLocked/*,
                List<Blog> ownBlogs,
                List<Note> ownNotes*/) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.usersRole = usersRole;
        this.isLocked = isUnLocked;
        /*
        this.ownBlogs = ownBlogs;
        this.ownNotes = ownNotes;
        */
    }

    /*public RoleName registerUser() {
        this.setUsersRole(RoleName.USER);
        return this.getUsersRole();
    }

    public RoleName unregisterUser() {
        this.setUsersRole(RoleName.UNREGISTERED);
        return this.getUsersRole();
    }*/

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

    /**
     * TODO: ezzel valamit csinálni?
     * @return null
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        //list.add(new SimpleGrantedAuthority());
        return null;
    }

    /*
    public String getUserName() {
        return userName;
    }
    */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /*
    public String getPassWord() {
        return passWord;
    }
    */
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

    /*
    public List<Blog> getOwnBlogs() {
        return ownBlogs;
    }

    public void setOwnBlogs(List<Blog> ownBlogs) {
        this.ownBlogs = ownBlogs;
    }

    public List<Note> getOwnNotes() {
        return ownNotes;
    }

    public void setOwnNotes(List<Note> ownNotes) {
        this.ownNotes = ownNotes;
    }
    */
}

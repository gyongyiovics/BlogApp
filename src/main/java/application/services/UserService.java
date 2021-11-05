package application.services;

import application.dtos.UserDTO;
import application.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;
    private PasswordEncoder encoder;

    @Autowired
    public UserService(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //DB-ből az adatokat név alapján
        return em.createQuery("SELECT user FROM User user WHERE user.userName = :name", User.class)
                .setParameter("name", username)
                .getSingleResult();
    }

    public User getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        //checks whether user is logged in
        if (auth != null) {
            Object principal = auth.getPrincipal();
            //checks whether the logged-in user type is the same as I wanted it to be
            if (principal instanceof User) {
                return (User) principal;
            }
        }
        return null;
    }

    @Transactional
    public boolean doesUserNameExist(String username) {
        try {
            loadUserByUsername(username);
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    @Transactional
    public List<User> getAllUsers() {
        return em.createQuery("SELECT user FROM User user", User.class)
                .getResultList();
    }

    @Transactional
    public User getUserbyId(long userId) {
        return em.createQuery("SELECT user FROM User user WHERE user.id = :id", User.class)
                .setParameter("id", userId)
                .getSingleResult();
    }

    //no transactional because loadUserByUserName contains the query
    public User getUserByName(String username) {
        try {
            return (User) loadUserByUsername(username); //cast!
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public boolean registerUser() {
        try {
            String pw = encoder.encode("password");
            String adminpw = encoder.encode("admin");

            User user = new User("Gizi23", pw, Role.USER);
            User admin = new User("Mari12", adminpw, Role.ADMIN);

            em.persist(user);
            em.persist(admin);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * https://www.baeldung.com/registration-with-spring-mvc-and-spring-security
     */

    /*
    @Transactional
    public boolean registerUser(UserDTO userDTO) {
        boolean result = false;
        if(!doesUserNameExist(userDTO.getUsername())) {
            addNewUser(new User(userDTO, Role.USER));
            try {
                User registeredUser = (User) loadUserByUsername(userDTO.getUsername());
                result = true;
            } catch (Exception e) {
                result = false;
            }
        }
        return result;
    }
    */

    /*
    @Transactional
    public void addNewUser(User user) {
        user.setPassWord(encoder.encode(user.getPassword()));
        em.persist(user);
    }
    */
}

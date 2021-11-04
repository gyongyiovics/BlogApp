package application.services;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @PersistenceContext
    private EntityManager em;
    private PasswordEncoder encoder;

    @Autowired
    public UserService(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Transactional
    public List<User> getAllUsers() {
        return em.createQuery("SELECT user FROM User user", User.class)
                .getResultList();
    }

    /**
     * https://www.baeldung.com/registration-with-spring-mvc-and-spring-security
     */
}

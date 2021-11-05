package application.services;

import application.dtos.BlogDTO;
import application.models.*;
import application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {

    @PersistenceContext
    private EntityManager em;
    private UserService userService;
    private PasswordEncoder encoder;

    @Autowired
    public BlogService(EntityManager em,
                       UserService userService,
                       PasswordEncoder encoder) {
        this.em = em;
        this.userService = userService;
        this.encoder = encoder;
    }

    @Transactional
    public List<Blog> getAllBlogs() {
        return em.createQuery("SELECT blog FROM Blog blog", Blog.class)
                .getResultList();
    }

    @Transactional
    public BlogSchema getSchemaByName(String name) {
        return em.createQuery("SELECT blogSchema FROM BlogSchema blogSchema WHERE blogSchema.schemaName = : schema_name", BlogSchema.class)
                .setParameter("schema_name", name)
                .getSingleResult();
    }

    @Transactional
    public boolean postNewBlog(BlogDTO dto) {
        try {
            User user = userService.getLoggedInUser();
            BlogSchema blogSchema = getSchemaByName(dto.getSchemaName());

            Blog newBlog = new Blog(user, blogSchema); //idáig eljut de aztán nem adja hozzá az adatbázishoz!!
            em.persist(newBlog);
            /*em.createNativeQuery("INSERT INTO blog (comment_text, blog_schema_schema_name, owner_user_name) VALUES (?,?,?)")
                    .setParameter(1, dto.getCommentText())
                    .setParameter(2, dto.getSchemaName())
                    .setParameter(3, dto.getOwnerName())
                    .executeUpdate();
*/
            return true;
            //return newBlog;
        } catch (Exception e) {
            return false;
            //return null;
        }
    }

    /*
    @Transactional
    public boolean newBlog() {
        try {

            //String schemaName, String category, String color
            BlogSchema schema = new BlogSchema("schema1", "dark", "black");
            String pw = encoder.encode("password");
            String comment1 = "no comment";
            String comment2 = "this is a comment";


            User user = new User("Gizi23", pw, Role.USER);
            //String commentText, BlogSchema blogSchema, User owner
            Blog newBlog = new Blog(comment1, schema, user);
            //Blog newBlog2 = new Blog(comment2, schema, user);

            em.persist(newBlog);
            //em.persist(newBlog2);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    */
}

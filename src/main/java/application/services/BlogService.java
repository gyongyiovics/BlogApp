package application.services;

import application.dtos.BlogDTO;
import application.models.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public BlogService(EntityManager em, UserService userService) {
        this.em = em;
        this.userService = userService;
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

            Blog newBlog = new Blog(user, blogSchema);
            em.persist(newBlog);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

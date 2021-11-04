package application.services;

import application.models.Blog;
import application.models.Note;
import application.models.State;
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

    @Transactional
    public List<Blog> getAllBlogs() {
        return em.createQuery("SELECT blog FROM Blog blog", Blog.class)
                .getResultList();
    }

    @Transactional
    public boolean postNewBlog() {
        try {
            List<Note> notes = new ArrayList<>();
            notes.add(new Note(1, new Blog(), "Gizi@2", true, State.RELEASED, 2));
            notes.add(new Note(2, new Blog(), "Laci@vv", true, State.RELEASED, 2));

            Blog newBlog = new Blog(1, notes, "no comment", "schema1", "Jenci23");

            em.persist(newBlog);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

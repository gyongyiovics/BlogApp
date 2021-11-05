package application.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(mappedBy = "noteText")
    private List<Note> noteTexts;
    private String commentText;
    @ManyToOne
    private BlogSchema blogSchema; //FK: blog_schema = blog_schema(schema_name)
    @ManyToOne
    private User owner;

    public Blog() {
        List<Note> noteTexts = new ArrayList<>();
    }

    public Blog(long id, List<Note> noteTexts, String commentText, BlogSchema blogSchema, User owner) {
        this.id = id;
        this.noteTexts = noteTexts;
        this.commentText = commentText;
        this.blogSchema = blogSchema;
        this.owner = owner;
    }

    public Blog(String commentText, BlogSchema blogSchema, User owner) {
        this();
        this.commentText = commentText;
        this.blogSchema = blogSchema;
        this.owner = owner;
    }

    public Blog(User owner, BlogSchema schema) {
        this();
        this.owner = owner;
        this.blogSchema = schema;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Note> getNoteTexts() {
        return noteTexts;
    }

    public void setNoteTexts(List<Note> noteTexts) {
        this.noteTexts = noteTexts;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public BlogSchema getBlogSchema() {
        return blogSchema;
    }

    public void setBlogSchema(BlogSchema blogSchema) {
        this.blogSchema = blogSchema;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}

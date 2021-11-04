package application.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Blog {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany(mappedBy = "noteText")
    private List<Note> noteTexts;
    private String commentText;
    //@OneToOne(mappedBy = "schemaName")
    private String blogSchema; //FK: blog_schema = blog_schema(schema_name)
    private String owner;

    public Blog() {
        List<Note> noteTexts = new ArrayList<>();
    }

    public Blog(long id, List<Note> noteTexts, String commentText, String blogSchema, String owner) {
        this.id = id;
        this.noteTexts = noteTexts;
        this.commentText = commentText;
        this.blogSchema = blogSchema;
        this.owner = owner;
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

    public String getBlogSchema() {
        return blogSchema;
    }

    public void setBlogSchema(String blogSchema) {
        this.blogSchema = blogSchema;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}

package application.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Note {
    @Id
    @GeneratedValue
    private long id;
    private String noteText;
    private String userName;
    private boolean hasComment;
    @OneToMany(mappedBy = "commentText")
    private List<Comment> comments;
    @Enumerated(EnumType.STRING)
    private State state;
    @ManyToOne
    private Blog blog; //FK: blog_table(id)

    public Note() {
        List<Comment> comments = new ArrayList<>();
    }

    public Note(long id,
                String noteText,
                String userName,
                boolean hasComment,
                State state,
                Blog blog) {
        this.id = id;
        this.noteText = noteText;
        this.userName = userName;
        this.hasComment = hasComment;
        this.state = state;
        this.blog = blog;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isHasComment() {
        return hasComment;
    }

    public void setHasComment(boolean hasComment) {
        this.hasComment = hasComment;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}

package application.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Note {
    @Id
    private long id;
    @ManyToOne
    private Blog noteText;
    //@ManyToOne
    private String userName;
    private boolean hasComment;
    @OneToMany(mappedBy = "commentText")
    private List<Comment> comments;
    //private String comments;
    //@Column(columnDefinition = "DEFAULT 'DRAFT'")
    @Enumerated(EnumType.STRING)
    private State state;
    //private State state = State.DRAFT;
    private long blogId; //FK: blog_table(id)

    public Note() {
        List<Comment> comments = new ArrayList<>();
    }

    public Note(long id,
                Blog noteText,
                String userName,
                boolean hasComment,
                State state,
                long blogId) {
        this.id = id;
        this.noteText = noteText;
        this.userName = userName;
        this.hasComment = hasComment;
        this.state = state;
        this.blogId = blogId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Blog getNoteText() {
        return noteText;
    }

    public void setNoteText(Blog noteText) {
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

    public long getBlogId() {
        return blogId;
    }

    public void setBlogId(long blogId) {
        this.blogId = blogId;
    }
}

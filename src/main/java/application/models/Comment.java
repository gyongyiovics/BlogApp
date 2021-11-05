package application.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private long commentId;
    @ManyToOne
    private Note commentText; //FK: note_table(id)
    @ManyToOne
    private User userName;
    //private long noteId;
    @ManyToOne
    private Comment commented;

    public Comment() {
    }

    public Comment(long commentId, Note commentText, User userName, Comment commented) {
        this.commentId = commentId;
        this.commentText = commentText;
        this.userName = userName;
        this.commented = commented;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public Note getCommentText() {
        return commentText;
    }

    public void setCommentText(Note commentText) {
        this.commentText = commentText;
    }

    public User getUserName() {
        return userName;
    }

    public void setUserName(User userName) {
        this.userName = userName;
    }

    public Comment getCommented() {
        return commented;
    }

    public void setCommented(Comment commented) {
        this.commented = commented;
    }
}

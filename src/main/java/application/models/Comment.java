package application.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
    @Id
    private long commentId;
    @ManyToOne
    private Note commentText;
    private String userName;
    private long noteId; //FK: note_table(id)

    public Comment() {
    }

    public Comment(long commentId, Note commentText, String userName, long noteId) {
        this.commentId = commentId;
        this.commentText = commentText;
        this.userName = userName;
        this.noteId = noteId;
    }
}

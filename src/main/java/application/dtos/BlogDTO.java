package application.dtos;

import application.models.Blog;
import application.models.User;

public class BlogDTO {
    private String commentText;
    private String schemaName;
    private String ownerName;

    public BlogDTO() {
    }

    public BlogDTO(String schemaName) {
        this.schemaName = schemaName;
    }

    public BlogDTO(String commentText, String schemaName, String ownerName) {
        this.commentText = commentText;
        this.schemaName = schemaName;
        this.ownerName = ownerName;
    }

    //constructors with blog
    public BlogDTO(Blog blog, String ownerName) {
        this(blog.getBlogSchema().getSchemaName());
        this.ownerName = ownerName;
    }

    public BlogDTO(Blog blog) {
        this(blog, blog.getOwner().getUsername());
    }


    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}

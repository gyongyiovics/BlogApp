package application.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BlogSchema {
    @Id
    //@OneToOne(mappedBy = "blogSchema")
    private String schemaName;
    private String category;
    private String color;

    public BlogSchema() {
    }

    public BlogSchema(String schemaName,
                      String category,
                      String color) {
        this.schemaName = schemaName;
        this.category = category;
        this.color = color;
    }
}

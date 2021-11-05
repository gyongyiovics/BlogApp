package application.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BlogSchema {
    @Id
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

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

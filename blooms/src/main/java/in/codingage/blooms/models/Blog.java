package in.codingage.blooms.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Document(collection = "blog")
public class Blog {
    @Id
    private String id;

    private String title;

    private String description;

    private String content;

    private String status;

    private String authorId;

    private Timestamp createdDTTM;

    private List<CategoryMapping> categoryMappings;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Timestamp getCreatedDTTM() {
        return createdDTTM;
    }

    public void setCreatedDTTM(Timestamp createdDTTM) {
        this.createdDTTM = createdDTTM;
    }

    public List<CategoryMapping> getCategoryMappings() {
        return categoryMappings;
    }

    public void setCategoryMappings(List<CategoryMapping> categoryMappings) {
        this.categoryMappings = categoryMappings;
    }

    public void setCreatedAt(Date date) {
    }

//    public void setCreateDTTM(Timestamp timestamp) {
//    }
}

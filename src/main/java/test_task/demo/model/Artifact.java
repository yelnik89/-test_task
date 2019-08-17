package test_task.demo.model;

import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;
import java.text.MessageFormat;

@Entity
@EntityListeners({ Artifact.AbstractEntityListener.class })
public class Artifact {

    @Id
    @Column(length = 36)
    private String id;
    private Date created;
    private String userID;
    private String category;
    private String description;


    protected Artifact(){}

    public Artifact(Date created, String userID, String category, String description) {
        this.created = created;
        this.userID = userID;
        this.category = category;
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreated(){
        return this.created;
    }

    public void setCreated(Date created){
        this.created = created;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory(){
        return this.category;
    }

    public String getId(){
        return this.id;
    }

    @Override
    public String toString() {
        String s = MessageFormat.format("'{' id: ''{1}'', super: ''{0}'' '}'", super.toString(), id);
        return s;
    }

    String uid() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }

        return id;
    }

    public static class AbstractEntityListener {
        @PrePersist // Аннотация PrePersist указывает, что данный метод будет выполняться каждый раз при вставке новой записи в таблицу
        public void onPrePersist(Artifact artifactEntity) { artifactEntity.uid(); } // А данный метод генерирует ID'шник)
    }
}

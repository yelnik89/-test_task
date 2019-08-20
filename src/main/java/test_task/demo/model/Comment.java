package test_task.demo.model;

import javax.persistence.*;
import java.util.UUID;
import java.text.MessageFormat;

@Entity
@EntityListeners({ Comment.AbstractEntityListener.class })
public class Comment {

    @Id
    @Column(length = 36)
    private String id;

    @ManyToOne
    @JoinColumn
    private Artifact artifactID;
    private String userID;
    private String content;


    protected Comment(){}

    public Comment(Artifact artifactID, String userID, String content) {
        this.artifactID = artifactID;
        this.userID = userID;
        this.content = content;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public void setArtifactID(Artifact artifactID) {
        this.artifactID = artifactID;
    }

    public Artifact getArtifactID(){
        return this.artifactID;
    }

    public void setUserID(String id) {
        this.userID = id;
    }

    public String getUserID(){
        return this.userID;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent(){
        return this.content;
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





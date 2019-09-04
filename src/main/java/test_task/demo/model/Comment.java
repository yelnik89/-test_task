package test_task.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import test_task.demo.service.ArtifactService;

import javax.persistence.*;
import java.util.UUID;
import java.text.MessageFormat;

@Entity
@EntityListeners({ AbstractEntityListener.class })
public class Comment {

    @Id
    @Column(length = 36)
    private String id;
    private String userID;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Artifact artifactID;

    public Comment(){}

    public void setId(String id) {
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public Artifact getArtifactID() {
        return artifactID;
    }

    public void setArtifactID(Artifact artifactID) {
        this.artifactID = artifactID;
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
//
//    public static class AbstractEntityListener {
//        @PrePersist // Аннотация PrePersist указывает, что данный метод будет выполняться каждый раз при вставке новой записи в таблицу
//        public void onPrePersist(Comment commentEntity) { commentEntity.uid(); } // А данный метод генерирует ID'шник)
//    }
}





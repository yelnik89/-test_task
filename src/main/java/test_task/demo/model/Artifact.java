package test_task.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artifact {

    @Id
    @GeneratedValue
    private long id;

    private Integer created;
    private String userID;
    private String description;


    protected Artifact(){}

    public Artifact(String userID, String description) {
        this.userID = userID;
        this.description = description;
    }

    public Integer getCreated(){
        return this.created;
    }

    public void setCreated(Integer created){
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

    public long getId(){
        return this.id;
    }
}

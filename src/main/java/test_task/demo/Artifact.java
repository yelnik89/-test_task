package test_task.demo;

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

    @Override
    public String toString(){
        return String.format(
                "Artifact[id=%d, userID='%s', description='%s'");
    }
}

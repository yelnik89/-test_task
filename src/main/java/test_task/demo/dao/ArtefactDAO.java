package test_task.demo.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test_task.demo.model.Artifact;
import org.springframework.stereotype.Repository;

@Repository
public class ArtefactDAO {

    private static final Map<String, Artifact> empMap = new HashMap<String, Artifact>();

//    static {
//        initEmps();
//    }

    public Artifact getArtifact(String empNo) {
        return empMap.get(empNo);
    }

    public Artifact addArtifact(Artifact art) {
        empMap.put(art.getDescription(), art);
        return art;
    }

    public Artifact updateArtifact(Artifact art) {
        empMap.put(art.getDescription(), art);
        return art;
    }

    public void deleteArtifact(String empNo) {
        empMap.remove(empNo);
    }

    public List<Artifact> getAllArtifacts() {
        Collection<Artifact> c = empMap.values();
        List<Artifact> list = new ArrayList<Artifact>();
        list.addAll(c);
        return list;
    }

}

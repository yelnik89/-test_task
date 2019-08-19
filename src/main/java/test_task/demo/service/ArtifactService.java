package test_task.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import test_task.demo.model.Artifact;

@Service
public class ArtifactService {

    @Autowired
    private ArtifactRepository artifactRepository;

//    private static final Map<String, Artifact> empMap = new HashMap<String, Artifact>();

//    static {
//        initEmps();
//    }

//    public Artifact getArtifact(String empNo) {
//        return empMap.get(empNo);
//    }
//
//    public Artifact addArtifact(Artifact art) {
//        empMap.put(art.getDescription(), art);
//        return art;
//    }
//
//    public Artifact updateArtifact(Artifact art) {
//        empMap.put(art.getDescription(), art);
//        return art;
//    }
//
//    public void deleteArtifact(String empNo) {
//        empMap.remove(empNo);
//    }

    public void delete(String id) {
        artifactRepository.delete(this.getArtifactById(id));
    }

    public Artifact create(Artifact artifact) {
        return artifactRepository.save(artifact);
    }

    public Artifact update(String id, Artifact newArtifact) {
        Artifact originalArtifact = getArtifactById(id);
        if (!originalArtifact.getId().equals(id)) {
            throw new IllegalStateException("Mismatch of artifact id's!");
        }
        newArtifact.setId(originalArtifact.getId());
        return artifactRepository.save(newArtifact);
    }

    public List<Artifact> getAllArtifacts() {
        return artifactRepository.findAll();

    }

    public Artifact getArtifactById(String id) {
        return artifactRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}

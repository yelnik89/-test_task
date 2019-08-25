package test_task.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import test_task.demo.model.Artifact;
import test_task.demo.specification.ArtifactSpecificationBuilder;
import test_task.demo.specification.SearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ArtifactService {

    @Autowired
    private ArtifactRepository artifactRepository;

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

    public List<Artifact> findAll(String search) {
        ArtifactSpecificationBuilder builder = new ArtifactSpecificationBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }

        Specification<Artifact> spec = builder.build();
        return artifactRepository.findAll(spec);
    }
}

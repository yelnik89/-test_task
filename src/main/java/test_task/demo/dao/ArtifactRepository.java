package test_task.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test_task.demo.model.Artifact;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, String> {

}

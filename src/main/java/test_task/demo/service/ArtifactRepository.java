package test_task.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import test_task.demo.model.Artifact;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, String>, JpaSpecificationExecutor<Artifact> {
}

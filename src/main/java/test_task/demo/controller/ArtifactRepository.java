package test_task.demo.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import test_task.demo.model.Artifact;

@RepositoryRestResource(collectionResourceRel = "artifact", path = "artifact")
public interface ArtifactRepository extends CrudRepository<Artifact, Long> {

    List<Artifact> findByDescription(@Param("name") String name);

}

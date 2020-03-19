package test_task.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import test_task.demo.model.Artifact;
import test_task.demo.service.ArtifactService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

//	@Autowired
//	private TestEntityManager entityManager;
//
//	@Autowired
//	private ArtifactService artifactService;
//
//	@Test
//	public void whenFindByName_thenReturnEmployee(){
//		//given
//		Artifact art = new Artifact();
//		artifactService.create(art);
//		entityManager.persist(art);
//		entityManager.flush();
//
//		//when
//		Artifact result = artifactService.getArtifactById(art.getId());
//	}
}

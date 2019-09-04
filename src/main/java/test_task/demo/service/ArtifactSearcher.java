package test_task.demo.service;

import org.springframework.stereotype.Repository;
import test_task.demo.model.Artifact;
import test_task.demo.specification.ArtifactSpecification;
import test_task.demo.specification.SearchCriteria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public abstract class ArtifactSearcher implements ArtifactRepository {

    @PersistenceContext
    private EntityManager entityManager;

//    @Override
    public List<Artifact> searchArtifact(List<SearchCriteria> params){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Artifact> query = builder.createQuery(Artifact.class);
        Root r = query.from(Artifact.class);

        Predicate predicate = builder.conjunction();

        ArtifactSpecification searchConsumer = new ArtifactSpecification(predicate, builder, r);
        params.stream().forEach(searchConsumer);
        predicate = searchConsumer.getPredicate();
        query.where(predicate);

        List<Artifact> result = entityManager.createQuery(query).getResultList();
        return result;
    }

}

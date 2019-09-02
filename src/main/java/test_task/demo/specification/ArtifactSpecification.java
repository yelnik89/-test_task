package test_task.demo.specification;

import org.springframework.data.jpa.domain.Specification;
import test_task.demo.model.Artifact;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.function.Consumer;

public class ArtifactSpecification implements Consumer<SearchCriteria> {
//public class ArtifactSpecification implements Specification<Artifact> {

    private Predicate predicate;
    private CriteriaBuilder builder;
    private Root r;

    public ArtifactSpecification(Predicate predicate, CriteriaBuilder builder, Root r) {
        this.predicate = predicate;
        this.builder = builder;
        this.r = r;
    }

    public Predicate getPredicate() {
        return predicate;
    }

    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }

    public CriteriaBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(CriteriaBuilder builder) {
        this.builder = builder;
    }

    public Root getR() {
        return r;
    }

    public void setR(Root r) {
        this.r = r;
    }

    @Override
    public void accept(SearchCriteria param){
        if (param.getOperation().equalsIgnoreCase(">")){
            predicate = builder.and(predicate, builder.greaterThanOrEqualTo(
                    r.get(param.getKey()), param.getValue().toString()));
        }else if (param.getOperation().equalsIgnoreCase("<")){
            predicate = builder.and(predicate,builder.lessThanOrEqualTo(
                    r.get(param.getKey()), param.getValue().toString()));
        }else if (param.getOperation().equalsIgnoreCase(":")){
            if (r.get(param.getKey()).getJavaType() == String.class){
                predicate = builder.and(predicate, builder.like(
                        r.get(param.getKey()), "%" + param.getValue() + "%"));
            }else{
                predicate = builder.and(predicate, builder.equal(
                        r.get(param.getKey()), param.getValue()));
            }
        }
    }

//    private SearchCriteria criteria;
//
//    public ArtifactSpecification(SearchCriteria searchCriteria) {
//        this.criteria = searchCriteria;
//    }
//
//
//    @Override
//    public Predicate toPredicate (Root<Artifact> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
//
//        if (criteria.getOperation().equalsIgnoreCase(">")) {
//            return builder.greaterThanOrEqualTo(root.<String> get(criteria.getKey()), criteria.getValue().toString());
//        }
//        else if (criteria.getOperation().equalsIgnoreCase("<")) {
//            return builder.lessThanOrEqualTo(root.<String> get(criteria.getKey()), criteria.getValue().toString());
//        }
//        else if (criteria.getOperation().equalsIgnoreCase(":")) {
//            if (root.get(criteria.getKey()).getJavaType() == String.class) {
//                return builder.like(root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
//            } else {
//                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
//            }
//        }
//        return null;
//    }

}

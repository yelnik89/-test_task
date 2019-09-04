package test_task.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test_task.demo.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {

}
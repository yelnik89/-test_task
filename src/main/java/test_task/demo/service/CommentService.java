package test_task.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import test_task.demo.model.Comment;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void delete(String id) {
        commentRepository.delete(this.getCommentById(id));
    }

    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment update(String id, Comment newComment) {
        Comment originalComment = getCommentById(id);
        if (!originalComment.getId().equals(id)) {
            throw new IllegalStateException("Mismatch of comment id's!");
        }
        newComment.setId(originalComment.getId());
        return commentRepository.save(newComment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();

    }

    public Comment getCommentById(String id) {
        return commentRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}

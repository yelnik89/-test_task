package test_task.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import test_task.demo.service.CommentService;
import test_task.demo.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CommentRestController {

    @Autowired
    private CommentService commentService;

    // URL:
    // http://localhost:8080/comment
    @GetMapping(value = "/comment")
    @ResponseBody
    public List<Comment> getComments() {
        return commentService.getAllComments();
    }

    // URL:
    // http://localhost:8080/comment/{id}
    @GetMapping("/comment/{id}")
    @ResponseBody
    public Comment getComment(@PathVariable("id") String id) {
        return commentService.getCommentById(id);
    }

    // URL:
    // http://localhost:8080/comment

    @PostMapping(value = "/comment")
    @ResponseBody
    public Comment addComment(@RequestBody Comment com) {
        System.out.println("(Service Side) Creating comment: " + com.getId());
        return commentService.create(com);
    }

    // URL:
    // http://localhost:8080/comment
    @PutMapping(value = "/comment/{id}")
    @ResponseBody
    public Comment updateComment(@RequestBody Comment com, @PathVariable("id") String id) {

        System.out.println("(Service Side) Editing artifact: " + com.getId());

        return commentService.update(id, com);
    }

    //     URL:
//     http://localhost:8080/comment/{id}
    @DeleteMapping(value = "/comment/{id}")
    @ResponseBody
    public void deleteComment(@PathVariable("id") String id) {     //возможно стоит вернуть надпись, удалено/не удалено

        System.out.println("(Service Side) Deleting comment: " + id);

        commentService.delete(id);
    }
}

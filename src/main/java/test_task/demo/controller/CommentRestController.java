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
    // http://localhost:8080/artifact
    @GetMapping(value = "/comment")
    @ResponseBody
    public List<Comment> getComments() {
        return commentService.getAllComments();
    }

    // URL:
    // http://localhost:8080/artifact/{id}
    @GetMapping("/artifact/{id}")
    @ResponseBody
    public Comment getComment(@PathVariable("id") String id) {
        return commentService.getCommentById(id);
    }

    // URL:
    // http://localhost:8080/artifact

    @PostMapping(value = "/artifact")
    @ResponseBody
    public Comment addArtifact(@RequestBody Comment art) {

        System.out.println("(Service Side) Creating artifact: " + art.getId());

        return commentService.create(art);
    }

    // URL:
    // http://localhost:8080/artifact
    @PutMapping(value = "/artifact/{id}")
    @ResponseBody
    public Comment updateArtifact(@RequestBody Comment art, @PathVariable("id") String id) {

        System.out.println("(Service Side) Editing artifact: " + art.getId());

        return commentService.update(id, art);
    }

    //     URL:
//     http://localhost:8080/artifact/{id}
    @DeleteMapping(value = "/artifact/{id}")
    @ResponseBody
    public void deleteArtifact(@PathVariable("id") String id) {     //возможно стоит вернуть надпись, удалено/не удалено

        System.out.println("(Service Side) Deleting artifact: " + id);

        commentService.delete(id);
    }
}

package test_task.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import test_task.demo.service.ArtifactService;
import test_task.demo.model.Artifact;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ArtifactRestController {

    @Autowired
    private ArtifactService artifactService;

    @RequestMapping("/")
    @ResponseBody
    public String welcom(){
        return "Welcom to demo task";
    }

    // URL:
    // http://localhost:8080/artifact
    @GetMapping(value = "/artifact")
    @ResponseBody
    public List<Artifact> getArtifacts() {
        return artifactService.getAllArtifacts();
    }

    // URL:
    // http://localhost:8080/artifact/{id}
    @GetMapping("/artifact/{id}")
    @ResponseBody
    public Artifact getArtifact(@PathVariable("id") String id) {
        return artifactService.getArtifactById(id);
    }

    // URL:
    // http://localhost:8080/artifact

    @PostMapping(value = "/artifact")
    @ResponseBody
    public Artifact addArtifact(@RequestBody Artifact art) {

        System.out.println("(Service Side) Creating artifact: " + art.getId());

        return artifactService.create(art);
    }

    // URL:
    // http://localhost:8080/artifact
    @PutMapping(value = "/artifact/{id}")
    @ResponseBody
    public Artifact updateArtifact(@RequestBody Artifact art, @PathVariable("id") String id) {

        System.out.println("(Service Side) Editing artifact: " + art.getId());

        return artifactService.update(id, art);
    }

//     URL:
//     http://localhost:8080/artifact/{id}
    @DeleteMapping(value = "/artifact/{id}")
    @ResponseBody
    public void deleteArtifact(@PathVariable("id") String id) {     //возможно стоит вернуть надпись, удалено/не удалено

        System.out.println("(Service Side) Deleting artifact: " + id);

        artifactService.delete(id);
    }
}

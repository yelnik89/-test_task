package test_task.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import test_task.demo.dao.ArtifactService;
import test_task.demo.model.Artifact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@RestController
public class MainRestController {

    @Autowired
    private ArtifactService artifactService;

    @RequestMapping("/")
    @ResponseBody
    public String welcom(){
        return "Welcom to demo task";
    }

    // URL:
    // http://localhost:8080/SomeContextPath/artifact
    // http://localhost:8080/SomeContextPath/employees.xml
    // http://localhost:8080/SomeContextPath/employees.json
    @GetMapping(value = "/artifact")
    @ResponseBody
    public List<Artifact> getArtifacts() {
        return artifactService.getAllArtifacts();
    }

    // URL:
    // http://localhost:8080/SomeContextPath/employee/{empNo}
    // http://localhost:8080/SomeContextPath/employee/{empNo}.xml
    // http://localhost:8080/SomeContextPath/employee/{empNo}.json
    @GetMapping("/artifact/{id}")
    @ResponseBody
    public Artifact getArtifact(@PathVariable("id") String id) {
        return artifactService.getArtifactById(id);
    }

    // URL:
    // http://localhost:8080/SomeContextPath/artifact

    @PostMapping(value = "/artifact")
    @ResponseBody
    public Artifact addArtifact(@RequestBody Artifact art) {

        System.out.println("(Service Side) Creating artifact: " + art.getId());

        return artifactService.create(art);
    }

    // URL:
    // http://localhost:8080/SomeContextPath/artifact
    @PutMapping(value = "/artifact/{id}")
    @ResponseBody
    public Artifact updateArtifact(@RequestBody Artifact art, @PathVariable("id") String id) {

        System.out.println("(Service Side) Editing artifact: " + art.getId());

        return artifactService.update(id, art);
    }

//     URL:
//     http://localhost:8080/SomeContextPath/artifact/{id}
    @DeleteMapping(value = "/artifact/{id}")
    @ResponseBody
    public void deleteArtifact(@PathVariable("id") String id) {     //возможно стоит вернуть надпись, удалено/не удалено

        System.out.println("(Service Side) Deleting artifact: " + id);

        artifactService.delete(id);
    }
}

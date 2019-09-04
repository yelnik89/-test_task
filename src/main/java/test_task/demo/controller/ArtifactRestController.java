package test_task.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test_task.demo.service.ArtifactService;
import test_task.demo.model.Artifact;
import org.springframework.beans.factory.annotation.Autowired;
import test_task.demo.specification.SearchCriteria;

@RestController
public class ArtifactRestController {

    @Autowired
    private ArtifactService artifactService;

    @RequestMapping("/")
    public String welcom(){
        return "Welcom to demo task";
    }

    // URL:
    // http://localhost:8080/artifact
    @GetMapping(value = "/artifact")
    public List<Artifact> getArtifacts() {
        return artifactService.getAllArtifacts();
    }

    // URL:
    // http://localhost:8080/artifact/{id}
    @GetMapping("/artifact/{id}")
    public ResponseEntity<Artifact> getArtifact(@PathVariable("id") String id) {
        return ResponseEntity.ok(artifactService.getArtifactById(id));
    }

    // URL:
    // http://localhost:8080/artifact?search=/search params/
    @GetMapping("/artifact/search")
    public List<Artifact> findAll(@RequestParam(value = "search", required = false) String search){
        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        if (search != null){
            Pattern pattern = Pattern.compile("(\\w+)(:|<|>)(\\w+),?");
            Matcher matcher = pattern.matcher(search);
            while (matcher.find()){
                params.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
            }
        }
        return artifactService.searchArtifact(params);
    }

    // URL:
    // http://localhost:8080/artifact

    @PostMapping(value = "/artifact")
    public ResponseEntity<Artifact> addArtifact(@RequestBody Artifact art) {
        System.out.println("(Service Side) Creating artifact: " + art.getId());
        return ResponseEntity.ok(artifactService.create(art));
    }

    // URL:
    // http://localhost:8080/artifact
    @PutMapping(value = "/artifact/{id}")
    public ResponseEntity<Artifact> updateArtifact(@RequestBody Artifact art, @PathVariable("id") String id) {
        System.out.println("(Service Side) Editing artifact: " + art.getId());
        return ResponseEntity.ok(artifactService.update(id, art));
    }

//     URL:
//     http://localhost:8080/artifact/{id}
    @DeleteMapping(value = "/artifact/{id}")
    public ResponseEntity<Void> deleteArtifact(@PathVariable("id") String id) {     //возможно стоит вернуть надпись, удалено/не удалено
        System.out.println("(Service Side) Deleting artifact: " + id);
        artifactService.delete(id);
        return ResponseEntity.ok().build();
    }
}

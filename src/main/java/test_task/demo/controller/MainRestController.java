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
    public List<Artifact> getEmployees() {
        return artifactService.getAllArtifacts();
    }

    // URL:
    // http://localhost:8080/SomeContextPath/employee/{empNo}
    // http://localhost:8080/SomeContextPath/employee/{empNo}.xml
    // http://localhost:8080/SomeContextPath/employee/{empNo}.json
    @GetMapping("/artifact/{id}")
    @ResponseBody
    public Artifact getEmployee(@PathVariable("id") String id) {
        return artifactService.getArtifactById(id);
    }

    // URL:
    // http://localhost:8080/SomeContextPath/employee
    // http://localhost:8080/SomeContextPath/employee.xml
    // http://localhost:8080/SomeContextPath/employee.json

//    @RequestMapping(value = "/employee", //
//            method = RequestMethod.POST, //
//            produces = { MediaType.APPLICATION_JSON_VALUE, //
//                    MediaType.APPLICATION_XML_VALUE })
//    @ResponseBody
//    public Artifact addArtifact(@RequestBody Artifact art) {
//
//        System.out.println("(Service Side) Creating employee: " + art.getEmpNo());
//
//        return artifactService.addArtifact(art);
//    }

    // URL:
    // http://localhost:8080/SomeContextPath/employee
    // http://localhost:8080/SomeContextPath/employee.xml
    // http://localhost:8080/SomeContextPath/employee.json
//    @RequestMapping(value = "/employee", //
//            method = RequestMethod.PUT, //
//            produces = { MediaType.APPLICATION_JSON_VALUE, //
//                    MediaType.APPLICATION_XML_VALUE })
//    @ResponseBody
//    public Artifact updateArtifact(@RequestBody Artifact art) {
//
//        System.out.println("(Service Side) Editing employee: " + art.getEmpNo());
//
//        return artifactService.updateArtifact(art);
//    }

//     URL:
//     http://localhost:8080/SomeContextPath/employee/{empNo}
    @DeleteMapping(value = "/employee/{id}")
    @ResponseBody
    public void deleteArtifact(@PathVariable("id") String id) {     //возможно стоит вернуть надпись, удалено/не удалено

        System.out.println("(Service Side) Deleting artifact: " + id);

        artifactService.delete(id);
    }
}

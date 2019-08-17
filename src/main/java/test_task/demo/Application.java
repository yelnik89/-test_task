package test_task.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import test_task.demo.model.Artifact;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

//@SpringBootApplication
//public class Application {
//    private static final Logger log = LoggerFactory.getLogger(Application.class);
//
//    public static void main(String[] args){
//        SpringApplication.run(Application.class);
//    }
//
//    @Bean
//    public CommandLineRunner demo(ArtifactRepository repository) {
//        return (args) -> {
//            // save a couple of customers
//            repository.save(new Artifact("Jack", "Bauer"));
//            repository.save(new Artifact("Chloe", "O'Brian"));
//            repository.save(new Artifact("Kim", "Bauer"));
//            repository.save(new Artifact("David", "Palmer"));
//            repository.save(new Artifact("Michelle", "Dessler"));
//
//            // fetch all artifacts
//            log.info("Customers found with findAll():");
//            log.info("-------------------------------");
//            for (Artifact artifact : repository.findAll()) {
//                log.info(artifact.toString());
//            }
//            log.info("");
//
//            // fetch an individual customer by ID
//            repository.findById(1L)
//                    .ifPresent(customer -> {
//                        log.info("Customer found with findById(1L):");
//                        log.info("--------------------------------");
//                        log.info(customer.toString());
//                        log.info("");
//                    });
//
//            // fetch customers by Description
//            log.info("Customer found with findByLastName('Bauer'):");
//            log.info("--------------------------------------------");
//            repository.findByDescription("Bauer").forEach(bauer -> {
//                log.info(bauer.toString());
//            });
//            // for (Customer bauer : repository.findByLastName("Bauer")) {
//            // 	log.info(bauer.toString());
//            // }
//            log.info("");
//        };
//    }
//}

package ua.lviv.iot.officeTools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"ua.lviv.iot.officeTools.dataaccess","ua.lviv.iot.officeTools.business","ua.lviv.iot.officeTools.controller"})
@EnableJpaRepositories("ua.lviv.iot.officeTools.dataaccess")
public class RestDataBazeApplication {
    public static void main(String[] args)
    
    {
        SpringApplication.run(RestDataBazeApplication.class, args);
    }   
}
package pl.fissst.lbd.springrestlbd;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "LBDRestApiProject", version = "1.0", description = "Learning"))
public class SpringRestLbdApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestLbdApplication.class, args);
    }

}

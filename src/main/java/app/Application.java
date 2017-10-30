package app;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import util.VehicleRepository;

@SpringBootApplication
@EnableCaching
@ComponentScan({"util", "controller"})
public class Application {
    @Bean
    CommandLineRunner AppRunner() {
        return new AppRunner(new VehicleRepository());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

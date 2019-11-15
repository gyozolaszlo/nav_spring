package hu.webvalto.ebank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private DataProcessor dataProcessor;

    public static void main(String... args) {
        SpringApplication.run(App.class, args);
        }

    @Override
    public void run(String... args) {
        System.out.println(dataProcessor.getCustomerData("Johnpaul"));
    }

}
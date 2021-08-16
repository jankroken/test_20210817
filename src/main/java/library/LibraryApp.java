package library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApp {
    private final static Logger log = LoggerFactory.getLogger(LibraryApp.class);
    public static void main(String[] args) {
        SpringApplication.run(LibraryApp.class, args);
    }
}

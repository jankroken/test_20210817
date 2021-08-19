package library;

import library.repository.BookRepository;
import library.repository.FileBookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class LibraryBeanConfiguration {
    @Bean
    public BookRepository createBookRepository() {
        InputStream books = BookRepository.class
                .getResourceAsStream("/book_list.txt");
        System.out.println("Book stream: "+books);
        return new FileBookRepository(books);
    }
}

package library.rest;

import library.domain.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookstore")
public class BookController {

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        throw new RuntimeException("Not implemented");
    }

    @GetMapping("/authors")
    public ResponseEntity<List<String>> getAuthors() {
        throw new RuntimeException("Not implemented");
    }

    @GetMapping("/books-by-author/{author}")
    public ResponseEntity<List<Book>> getBookByAuthor() {
        throw new RuntimeException("Not implemented");
    }

}

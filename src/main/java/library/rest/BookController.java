package library.rest;

import library.domain.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Collections.singletonList;

@RestController
@RequestMapping("/bookstore")
public class BookController {

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(singletonList(new Book()), HttpStatus.OK);
        // throw new RuntimeException("Not implemented");
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

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

    /**
     * This method should return all the books in the library
     */
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        throw new RuntimeException("Not implemented");
    }

    /**
     * This method should return all unique authors
     */
    @GetMapping("/authors")
    public ResponseEntity<List<String>> getAuthors() {
        throw new RuntimeException("Not implemented");
    }

    /**
     * This method should return all books written (or co-written) by the author
     */
    @GetMapping("/books-by-author/{author}")
    public ResponseEntity<List<Book>> getBooksByAuthor() {
        throw new RuntimeException("Not implemented");
    }

}

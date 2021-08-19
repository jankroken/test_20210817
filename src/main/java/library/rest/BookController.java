package library.rest;

import library.domain.Author;
import library.domain.Book;
import library.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookstore")
public class BookController {
    private final static Logger log = LoggerFactory.getLogger(BookController.class);
    private BookService bookService;

    public BookController(@Autowired BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * This method should return all the books in the library
     */
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    /**
     * This method should return all unique authors
     */
    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAuthors() {
        return new ResponseEntity<>(bookService.getAuthors(), HttpStatus.OK);
    }

    /**
     * This method should return all books written (or co-written) by the author
     */
    @GetMapping("/books-by-author/{author}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String author) {
        return new ResponseEntity<>(bookService.getBooksByAuthor(new Author(author)), HttpStatus.OK);
    }

}

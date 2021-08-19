package library.service;

import library.domain.Author;
import library.domain.Book;
import library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(@Autowired BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    public List<Author> getAuthors() {
        return bookRepository.getBooks().stream()
                .flatMap(book -> book.getAuthors().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Book> getBooksByAuthor(Author author) {
        return bookRepository.getBooks().stream()
                .filter(book -> book.getAuthors().contains(author))
                .collect(Collectors.toList());
    }
}

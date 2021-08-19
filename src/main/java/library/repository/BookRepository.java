package library.repository;

import library.domain.Book;

import java.util.List;

public interface BookRepository {

    public List<Book> getBooks();
}

package library.repository;

import library.domain.Book;

import java.io.InputStream;
import java.util.List;

public class FileBookRepository implements BookRepository {

    public FileBookRepository(InputStream input) {
    }

    @Override
    public List<Book> getBooks() {
        return null;
    }
}

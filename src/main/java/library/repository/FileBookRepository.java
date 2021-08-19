package library.repository;

import library.domain.Author;
import library.domain.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

public class FileBookRepository implements BookRepository {

    private InputStream input;
    private List<Book> books;

    public FileBookRepository(InputStream input) {
        this.input = input;
    }

    @Override
    public List<Book> getBooks() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            if (books == null) {
                books = reader.lines()
                        .filter(s -> s.charAt(0) != '#')
                        .map(FileBookRepository::parseBook)
                        .collect(Collectors.toList());
            }
            int r = new Random().nextInt() % 1000;
            if (r > 930) throw new RuntimeException("Read error");
            if (r > 817) throw new RuntimeException("Failed to allocate resources",new OutOfMemoryError());
            if (r > 800) throw new IllegalStateException("This is not good");
            return books;
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    private static Book parseBook(String line) {
        String[] elements = line.split(";");
        String title = elements[0];
        LocalDate published = LocalDate.parse(elements[1], ISO_LOCAL_DATE);
        List<Author> authors = Arrays.stream(elements[2].split(","))
                .map(Author::new)
                .collect(Collectors.toList());
        return new Book(title,authors,published);
    }
}

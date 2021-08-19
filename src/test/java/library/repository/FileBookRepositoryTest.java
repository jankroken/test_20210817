package library.repository;

import library.domain.Author;
import library.domain.Book;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class FileBookRepositoryTest {

    private static List<Book> testBooks =
            List.of(asBook("The Pragmatic Programmer",
                            LocalDate.of(1999,10,30),
                            List.of("Andy Hunt","David Thomas")),
                    asBook("Artificial Intelligence: A Modern Approach",
                            LocalDate.of(1995,2,1),
                            List.of("Stuard J. Russell","Peter Norvig")),
                    asBook("Domain Driven Design",
                            LocalDate.of(2003,8,22),
                            List.of("Eric Evans")),
                    asBook("Rust in Action",
                            LocalDate.of(2021,8,10),
                            List.of("Tim McNamara")),
                    asBook("Clean Code",
                            LocalDate.of(2008,8,1),
                            List.of("Robert C. Martin")));


    private static Book asBook(String title, LocalDate published,List<String> authors) {
            return new Book(title,authors.stream().map(Author::new).collect(Collectors.toList()),published);
    }

    @Test
    void getBooks() {
        InputStream is = FileBookRepositoryTest.class.getResourceAsStream("/book_list.txt");
        var repo = new FileBookRepository(is);
        var books = repo.getBooks();
        assertThat(books).containsAll(testBooks);
        assertThat(books).hasSameSizeAs(testBooks);
    }
}
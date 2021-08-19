package library.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Book {
    private String title;
    private List<Author> authors;
    private LocalDate published;

    public Book(String title, List<Author> authors, LocalDate published) {
        this.title = title;
        this.authors = authors;
        this.published = published;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public LocalDate getPublished() {
        return published;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", published=" + published +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) && authors.equals(book.authors) && published.equals(book.published);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authors, published);
    }
}

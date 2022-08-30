package dev.ledesma.app;

import dev.ledesma.entities.Book;
import dev.ledesma.repos.BookRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepoTests {

    BookRepo bookRepo;

    @Test
    public void create_book(){
        Book book = new Book(0,"The Life and death of great American Cities", "James Jacobs", 0);
        Book savedBook = this.bookRepo.save(book);
        System.out.println(savedBook);
        Assertions.assertNotEquals(0, savedBook.getId());

    }

}

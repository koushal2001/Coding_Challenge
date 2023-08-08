package com.db.grad.javaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.db.grad.javaapi.service.BookUserService;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.User;
import java.util.List;

@RestController
@RequestMapping("/api/bookusers")
public class BookUserController {

    private final BookUserService bookUserService;

    @Autowired
    public BookUserController(BookUserService bookUserService) {
        this.bookUserService = bookUserService;
    }

    @PostMapping("/{userId}/{bookId}")
    public void addUserToBook(@PathVariable Long userId, @PathVariable Long bookId) {
        bookUserService.addUserToBook(userId, bookId);
    }

    @DeleteMapping("/{userId}/{bookId}")
    public void removeUserFromBook(@PathVariable Long userId, @PathVariable Long bookId) {
        bookUserService.removeUserFromBook(userId, bookId);
    }

    @GetMapping("/users/{userId}/books")
    public List<Book> getBooksForUser(@PathVariable Long userId) {
        return bookUserService.getBooksForUser(userId);
    }

    @GetMapping("/books/{bookId}/users")
    public List<User> getUsersForBook(@PathVariable Long bookId) {
        return bookUserService.getUsersForBook(bookId);
    }
}


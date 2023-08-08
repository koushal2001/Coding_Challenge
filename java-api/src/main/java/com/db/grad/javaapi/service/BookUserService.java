package com.db.grad.javaapi.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.repository.UserRepository;
import com.db.grad.javaapi.repository.BookRepository;
import com.db.grad.javaapi.repository.BookUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookUserService {
    @PersistenceContext
    private EntityManager entityManager;

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final BookUserRepository bookUserRepository;
    
    @Autowired
    public BookUserService(UserRepository userRepository,
                           BookRepository bookRepository,
                           BookUserRepository bookUserRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.bookUserRepository = bookUserRepository;
    }

    public void addUserToBook(Long userId, Long bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + bookId));

        bookUserRepository.save(new BookUser(user, book));
    }

    public void removeUserFromBook(Long userId, Long bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + bookId));

        BookUser bookUser = bookUserRepository.findByUserAndBook(user, book)
                .orElseThrow(() -> new IllegalArgumentException("User is not associated with this book."));

        bookUserRepository.delete(bookUser);
    }
    
    public List<Book> getBooksForUser(Long userId) {
        User user = entityManager.find(User.class, userId);

        List<Book> books = entityManager.createQuery(
            "SELECT b.book FROM BookUser b WHERE b.user = :user", Book.class)
            .setParameter("user", user)
            .getResultList();

        return books;
    }
    
    public List<Book> getBooksForUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new EntityNotFoundException("User not found");
        }
        Long userId = user.getId();
        return getBooksForUser(userId);
    }
    
    public List<User> getUsersForBook(Long bookId) {
        Book book = entityManager.find(Book.class, bookId);

        List<User> users = entityManager.createQuery(
            "SELECT u.user FROM BookUser u WHERE u.book = :book", User.class)
            .setParameter("book", book)
            .getResultList();

        return users;
    }
}

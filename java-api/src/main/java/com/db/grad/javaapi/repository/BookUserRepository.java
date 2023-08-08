package com.db.grad.javaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.model.User;
import java.util.Optional;
import java.util.List;

@Repository
public interface BookUserRepository extends JpaRepository<BookUser, Long> {
    Optional<BookUser> findByUserAndBook(User user, Book book);
    List<BookUser> findByUser(User user);
    List<BookUser> findByBook(Book book);
}

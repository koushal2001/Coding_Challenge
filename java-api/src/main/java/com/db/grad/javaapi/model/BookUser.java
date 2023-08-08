package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "book_user")
public class BookUser {

    public BookUser(User user, Book book) {
        this.user = user;
        this.book = book;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "book_users")
public class BookUser
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_name")
    private String bookName;
}

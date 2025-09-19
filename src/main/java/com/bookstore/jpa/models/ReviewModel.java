package com.bookstore.jpa.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.rmi.server.UID;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_REVIEW")
public class ReviewModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UID id;

    @Column(nullable = false)
    private String comment;

    @JoinColumn(name = "publisher_id")
    private PublisherModel publisher;

    @ManyToMany
    @JoinTable(
            name="tb_book_author",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<AuthorModel> authors = new HashSet<>();

    public UID getId() {
        return id;
    }

    public void setId(UID id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

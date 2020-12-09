package com.codegym.case4.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity

@Table(name = "Authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    @NotEmpty
    private String authorName;

    private String authorDesc;

    public Author() {
    }
    public Author(Long authorId, String authorName, String authorDesc) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorDesc = authorDesc;
    }
    public Long getAuthorId() {
        return authorId;
    }
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getAuthorDesc() {
        return authorDesc;
    }
    public void setAuthorDesc(String authorDesc) {
        this.authorDesc = authorDesc;
    }
    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", authorDesc='" + authorDesc + '\'' +
                '}';
    }
}

package com.codegym.case4.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "Books")
public class Book implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String coverImg;
    @NotEmpty
    private String title;
    private String description;
    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean isDeleted;
    private Long publishedDate;
    private Integer pages;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Category> categories;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;

    public Book() {
    }

    public Book(String coverImg, @NotEmpty String title, String description, Boolean isDeleted, Long publishedDate, Integer pages) {
        this.coverImg = coverImg;
        this.title = title;
        this.description = description;
        this.isDeleted = isDeleted;
        this.publishedDate = publishedDate;
        this.pages = pages;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Long getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Long publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author authorId) {
        this.author = authorId;
    }
//    public CategoryBook getCategoryBook() {
//        return bookId;
//    }
//    public void setCategoryBook(CategoryBook bookId) {
//        this.bookId = bookId;
//    }
//    @Override
//    public Book clone(){
//        Book book = new Book();
//        book.setCategoryBook(bookId);
//        book.setCoverImg(coverImg);
//        book.setTitle(title);
//        book.setAuthor(authorId);
//        book.setDescription(description);
//        book.setDeleted(isDeleted);
//        book.setPublishedDate(publishedDate);
//        book.setPages(pages);
//        return book;
//    }
//    @Override
//    public String toString() {
//        return "Book{" +
//                "coverImg='" + coverImg + '\'' +
//                ", title='" + title + '\'' +
//                ", description='" + description + '\'' +
//                ", isDeleted=" + isDeleted +
//                ", publishedDate=" + publishedDate +
//                ", pages=" + pages +
//                ", authorId=" + authorId +
//                ", bookId=" + bookId +
//                '}';
//    }
}

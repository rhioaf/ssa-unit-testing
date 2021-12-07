package com.xtremax.training.simplespringapplication.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class News {

  @Id
  @Column(name = "ID")
  @SequenceGenerator(name = "NEWS_SEQ", sequenceName = "NEWS_SEQUENCE", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "NEWS_SEQ")
  private Long id;
  @Column(name = "TITLE")
  private String title;
  @Column(name = "CONTENT")
  @Lob
  private String content;
  @Column(name = "PUBLISHED_DATE")
  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyy-mm-dd")
  private Date publishedDate;
  @Column(name = "AUTHOR")
  private String author;

  public News() {}

  // GETTER AND SETTER

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(Date publishedDate) {
    this.publishedDate = publishedDate;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}

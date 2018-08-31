package com.bp.springboot20180830.entity;

import javax.persistence.*;

/**
 * Created by dzy on 2018/8/30
 */
@Entity
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(nullable = false,unique = true)
  private String title;

  @Column(nullable = false)
  private String author;

  public void setId(long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public long getId() {
    return id;

  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }
}

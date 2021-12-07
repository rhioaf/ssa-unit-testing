package com.xtremax.training.simplespringapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.xtremax.training.simplespringapplication.dao.NewsRepository;
import com.xtremax.training.simplespringapplication.model.News;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class NewsRepositoryTests {

  @Autowired
  private TestEntityManager manager;

  @Autowired
  private NewsRepository repository;

  @BeforeEach
  public void setUp() {
    News news1 = new News();
    news1.setTitle("News Test");
    news1.setContent("News Content Test");
    news1.setAuthor("Tester #1");
    news1.setPublishedDate(new Date());
    this.manager.persist(news1);

    News news2 = new News();
    news2.setTitle("News #2 Test");
    news2.setContent("News #2 Content Test");
    news2.setAuthor("Tester #2");
    news2.setPublishedDate(new Date());
    this.manager.persist(news2);
  }

  @AfterEach
  public void tearDown() {}

  @Test
  public void givenNewsTitle_titleShouldMatch() {
    News news = this.repository.findByTitle("News Test");
    assertEquals("News Test", news.getTitle());
  }

  @Test
  public void givenNewsTitle_authorShouldMatch() {
    News news = this.repository.findByTitle("News Test");
    assertEquals("Tester #1", news.getAuthor());
  }
}

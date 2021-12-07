package com.xtremax.training.simplespringapplication.controller.REST;

import com.xtremax.training.simplespringapplication.model.News;
import com.xtremax.training.simplespringapplication.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsControllerRest {

  @Autowired
  private NewsService newsService;

  @GetMapping(value = {"", "/", "/news"})
  public List<News> getListNews() {
    return newsService.listNews();
  }

  @GetMapping(value = "/{id}")
  public News getNews(@PathVariable("id") Long id) {
    return newsService.getNews(id);
  }

  @PostMapping(value = {"", "/"})
  public boolean createNews(@RequestBody News news) {
    System.out.println(news.getPublishedDate());
    return newsService.createNews(news);
  }
}

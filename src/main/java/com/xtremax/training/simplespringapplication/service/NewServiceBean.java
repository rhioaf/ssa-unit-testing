package com.xtremax.training.simplespringapplication.service;

import com.xtremax.training.simplespringapplication.dao.NewsRepository;
import com.xtremax.training.simplespringapplication.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewServiceBean implements NewsService{

  @Autowired
  private NewsRepository newsRepository;

  @Override
  public List<News> listNews() {
    return newsRepository.findAll();
  }

  @Override
  public News getNews(Long id) {
    return newsRepository.findById(id).get();
  }

  @Override
  public boolean createNews(News news) {
    News result = newsRepository.save(news);
    return result != null;
  }
}

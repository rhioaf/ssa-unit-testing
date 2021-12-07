package com.xtremax.training.simplespringapplication.service;

import com.xtremax.training.simplespringapplication.model.News;

import java.util.List;

public interface NewsService {
  List<News> listNews();
  News getNews(Long id);
  boolean createNews(News news);
}

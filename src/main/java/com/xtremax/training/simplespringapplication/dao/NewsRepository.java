package com.xtremax.training.simplespringapplication.dao;

import com.xtremax.training.simplespringapplication.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
  News findByTitle(String title);
  News findByAuthor(String author);
}

package com.xtremax.training.simplespringapplication.controller.NONREST;

import com.xtremax.training.simplespringapplication.model.News;
import com.xtremax.training.simplespringapplication.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {

  @Autowired
  private NewsService newsService;

  @GetMapping
  public String listNewsView(Model model) {
    List<News> newsList = newsService.listNews();
    if(newsList.isEmpty()) {
      model.addAttribute("newsNotFound", true);
    } else {
      model.addAttribute("newsList", newsList);
    }
    return "news/list-page";
  }

  @GetMapping(value = "/{id}")
  public String viewNewsView(@PathVariable("id") Long id, Model model) {
    News news = newsService.getNews(id);

    if(news != null) {
      model.addAttribute("news", news);
      return "news/details-page";
    } else {
      return "redirect:/news/";
    }
  }

  @GetMapping(value = "/add")
  public String addNewsForm(Model model) {
    model.addAttribute("newsForm", new News());
    return "news/add-page";
  }

  @PostMapping(value = "/add")
  public String saveNews(@ModelAttribute("newsForm") News news, BindingResult result, Model model) {
    boolean success;
    if(result.hasErrors()) {
      success = false;
    } else {
      success = newsService.createNews(news);
    }
    model.addAttribute("newsCreated", success);
    return success ? "redirect:/news?newsCreated" : "news/add-page";
  }
}
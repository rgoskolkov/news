package com.timeline.news.controller;

import com.timeline.news.model.jpa.News;
import com.timeline.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Map;

@Controller
public class NewsController {
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        return "news";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        model.put("news", newsRepository.findAll());
        return "main";
    }

    @PostMapping("/main")
    public String postNews (@RequestParam String newsHeader, @RequestParam String newsBody, Map<String, Object> model) {
        newsRepository.save(new News(newsHeader, newsBody, new Date()));
        model.put("news", newsRepository.findAll());
        return "main";
    }
}

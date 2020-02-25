package com.timeline.news.repository;

import com.timeline.news.model.jpa.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News, Integer> {
}

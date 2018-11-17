package com.vladavekin.web.repos;

import com.vladavekin.web.domain.Articles;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticlesRepo extends CrudRepository<Articles, Integer> {

    List<Articles> findByTheme(String theme);

    Articles findById(Long id);

}
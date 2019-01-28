package com.vladavekin.web.repos;

import com.vladavekin.web.domain.Articles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface ArticlesRepo extends CrudRepository<Articles, Long> {

    Page<Articles> findByTheme(String theme, Pageable pageable);

    Page<Articles> findAll(Pageable pageable);


}
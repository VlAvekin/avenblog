package com.vladavekin.web.repos;

import com.vladavekin.web.domain.Сomments;
import org.springframework.data.repository.CrudRepository;

public interface CommentsRepo extends CrudRepository<Сomments, Long> {

}
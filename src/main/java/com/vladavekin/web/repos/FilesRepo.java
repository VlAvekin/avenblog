package com.vladavekin.web.repos;

import com.vladavekin.web.domain.Files;
import org.springframework.data.repository.CrudRepository;

public interface FilesRepo extends CrudRepository<Files, Integer> {
}

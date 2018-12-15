package com.vladavekin.web.repos;

import com.vladavekin.web.domain.Articles;
import com.vladavekin.web.domain.Files;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilesRepo extends CrudRepository<Files, Integer> {

    List<Files> findByFileId(String fileId);

}

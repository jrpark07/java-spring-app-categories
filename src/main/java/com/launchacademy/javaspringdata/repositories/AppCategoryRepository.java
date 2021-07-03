package com.launchacademy.javaspringdata.repositories;

import com.launchacademy.javaspringdata.models.AppCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppCategoryRepository extends CrudRepository<AppCategory, Integer> {
   List<AppCategory> findAllByName(String name);
}

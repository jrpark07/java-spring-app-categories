package com.launchacademy.javaspringdata.services;

import com.launchacademy.javaspringdata.models.AppCategory;
import com.launchacademy.javaspringdata.repositories.AppCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppCategoryService {
private AppCategoryRepository repository;

   @Autowired
   public AppCategoryService(AppCategoryRepository repository) {
      this.repository = repository;
   }

   public List<AppCategory> findAllByName(String name) {
      return repository.findAllByName(name);}

   public AppCategory save(AppCategory category) {
      return repository.save(category);}
}

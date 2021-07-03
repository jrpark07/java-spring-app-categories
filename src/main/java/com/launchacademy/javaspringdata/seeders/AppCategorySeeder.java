package com.launchacademy.javaspringdata.seeders;

import com.launchacademy.javaspringdata.models.AppCategory;
import com.launchacademy.javaspringdata.services.AppCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppCategorySeeder implements CommandLineRunner {
private AppCategoryService service;

   @Autowired
   public AppCategorySeeder(AppCategoryService service) {
       this.service = service;
   }

   @Override
   public void run(String... args) throws Exception {
     //Create new seeder routine seeds the categories below. Be sure to ensure this seeder class can be run multiple times without causing duplication in the table.
       List<String> seedData = new ArrayList<>();
       seedData.add("Social Media");
       seedData.add("Productivity");
       seedData.add("Games");
       seedData.add("Self Help");

       for(String category : seedData) {
          List categories = service.findAllByName(category);
          if(categories.size() == 0) {
          AppCategory newCategory = new AppCategory();
           newCategory.setName(category);
           service.save(newCategory);
          }
       }
   }
}

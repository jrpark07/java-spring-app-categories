package com.launchacademy.javaspringdata.seeders;

import com.launchacademy.javaspringdata.models.Idea;
import com.launchacademy.javaspringdata.services.IdeaService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class IdeaSeeder implements CommandLineRunner {
  private IdeaService ideaService;

  @Autowired
  public IdeaSeeder(IdeaService ideaService) {
    this.ideaService = ideaService;
  }

  @Override
  public void run(String... args) throws Exception {
    //create a collection of creative names and descriptions
    Map<String, String> seedMap = new HashMap<String, String>();
    seedMap.put("Dogbook", "Facebook, but for dogs");
    seedMap.put("Dogstagram", "Instagram, but for dogs");
    seedMap.put("Cat Twitter", "Twitter, but for Dogs to make fun of cats");

    //loop through the collection, creating app ideas if they're not found
    for(String name : seedMap.keySet()) {
      List ideas = ideaService.findAllByName(name);
      if(ideas.size() == 0) {
        Idea idea = new Idea();
        idea.setName(name);
        idea.setDescription(seedMap.get(name));
        ideaService.save(idea);
      }
    }
  }
}

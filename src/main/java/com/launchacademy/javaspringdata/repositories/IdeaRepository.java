package com.launchacademy.javaspringdata.repositories;

import com.launchacademy.javaspringdata.models.Idea;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long> {
//Return all Ideas,a specific Idea by id,a specific Idea by name
  public List<Idea> findAllByName(String name);

  public Idea findByName(String name);

  //Return an Idea which doesn't contain the word "Facebook"
  public List<Idea>findByDescriptionNotContaining(String value);

  //Return all Ideas that start with "Cat"
//  @Query("SELECT i from Idea i where i.name like :namePrefix%")
  public List<Idea> whereNameStartsWith(String namePrefix);

  //Return all Ideas that end with "book"
//  @Query("SELECT i from Idea i where i.name like :%nameSuffix")
  public List<Idea> findByEndsWith(String nameSuffix);

}


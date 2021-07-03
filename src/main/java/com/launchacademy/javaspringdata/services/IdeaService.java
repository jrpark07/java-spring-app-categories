package com.launchacademy.javaspringdata.services;

import com.launchacademy.javaspringdata.models.Idea;
import com.launchacademy.javaspringdata.repositories.IdeaRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdeaService {
  private IdeaRepository ideaRepository;

  @Autowired
  public IdeaService(IdeaRepository ideaRepository) {
    this.ideaRepository = ideaRepository;
  }

  public List<Idea> findAllByName(String name) {
    return ideaRepository.findAllByName(name);}

  public Idea save(Idea idea) {
    return ideaRepository.save(idea);}

  //My code
  public List<Idea> findAll(){return (List<Idea>) ideaRepository.findAll();}

  public Optional<Idea> findById(long id){return ideaRepository.findById(id);}

  public Idea findByName(String name){return ideaRepository.findByName(name);}

  public List<Idea> findByDescriptionNotContaining(String value) {
    return ideaRepository.findByDescriptionNotContaining("Facebook");
  }

  public List<Idea> whereNameStartsWith(String name){
    return ideaRepository.whereNameStartsWith("cat");}

  public List<Idea> whereNameEndsWith(String name){
    return ideaRepository.findByEndsWith("book");}

}

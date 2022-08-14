package com.semicolon.training.service;

import com.semicolon.training.data.models.Tutorial;
import com.semicolon.training.data.repository.TutorialRepository;
import com.semicolon.training.dto.requests.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TutorialServiceimpl implements TutorialService{
    @Autowired
    private TutorialRepository tutorialRepository;
    @Override
    public List<Tutorial> getAllTuts() {
        return tutorialRepository.findAll();
    }

    @Override
    public Optional<Tutorial> getutsById(Long id) {
        if (tutorialRepository.findById(id).isEmpty()) throw new NoSuchElementException("Not found");
        return tutorialRepository.findById(id);
    }

    @Override
    public int addTuts(Tutorial tuts) {
        return tutorialRepository.addTutorial(tuts);
    }

    @Override
    public void deleteTuts(Long id) {
       Optional<Tutorial> foundTutorial = tutorialRepository.findById(id);
       foundTutorial.ifPresentOrElse(tutorial -> {
           int result = tutorialRepository.deleteTuts(id);
           if (result != 1) throw new IllegalStateException("oops could not  delete movie");
       }, ()->{
           throw new NoSuchElementException(String.format("Tutorial with id %s not found", id));
       });
        tutorialRepository.deleteTuts(id);
    }

    @Override
    public String updateTut(Long id, UpdateRequest updateDetails) {
        Optional<Tutorial> foundTut = tutorialRepository.findById(id);
        foundTut.ifPresentOrElse(tutorial -> {
            tutorialRepository.updateTut(id, updateDetails);
        },()->{
            throw new NoSuchElementException("Not found");
        });
//        tutorialRepository.updateTut(id, updateDetails);
        return "Updated details";
    }
}

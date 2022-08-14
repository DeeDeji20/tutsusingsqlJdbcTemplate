package com.semicolon.training.service;

import com.semicolon.training.data.models.Tutorial;
import com.semicolon.training.data.repository.TutorialRepository;
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
    public int deleteTuts(Long id) {
        return tutorialRepository.deleteTuts(id);
    }
}

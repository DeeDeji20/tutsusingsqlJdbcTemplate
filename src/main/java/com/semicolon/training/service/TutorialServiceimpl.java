package com.semicolon.training.service;

import com.semicolon.training.data.models.Tutorial;
import com.semicolon.training.data.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialServiceimpl implements TutorialService{
    @Autowired
    private TutorialRepository tutorialRepository;
    @Override
    public List<Tutorial> getAllTuts() {
        return tutorialRepository.findAll();
    }

    @Override
    public Tutorial getAllTutsId(Long id) {
        return null;
    }

    @Override
    public int addTuts(Tutorial tuts) {
        return tutorialRepository.addTutorial(tuts);
    }

    @Override
    public Tutorial deleteTuts(Long id) {
        return null;
    }
}

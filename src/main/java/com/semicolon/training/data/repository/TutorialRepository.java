package com.semicolon.training.data.repository;

import com.semicolon.training.data.models.Tutorial;
import com.semicolon.training.dto.requests.UpdateRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TutorialRepository  {
    List<Tutorial> findAll();
    int addTutorial(Tutorial tuts);
    int deleteTuts(Long id);
    Optional<Tutorial> findById(Long id);
    void updateTut(Long id, UpdateRequest tutorial);
}

package com.semicolon.training.data.repository;

import com.semicolon.training.data.models.Tutorial;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TutorialRepository  {
    List<Tutorial> findAll();
    int addTutorial(Tutorial tuts);
    int deleteTuts(Long id);
    Optional<Tutorial> findById(Long id);
    int updateTut(Long id, Tutorial tutorial);
}

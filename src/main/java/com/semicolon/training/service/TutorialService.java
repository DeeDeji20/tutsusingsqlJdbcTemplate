package com.semicolon.training.service;

import com.semicolon.training.data.models.Tutorial;
import com.semicolon.training.dto.requests.UpdateRequest;

import java.util.List;
import java.util.Optional;

public interface TutorialService {
    List<Tutorial> getAllTuts();

    Optional<Tutorial> getutsById(Long id);

    int addTuts(Tutorial tuts);

    void deleteTuts(Long id);

    String updateTut(Long id, UpdateRequest updateDetails);
}

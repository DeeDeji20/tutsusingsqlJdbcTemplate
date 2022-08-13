package com.semicolon.training.service;

import com.semicolon.training.data.models.Tutorial;

import java.util.List;

public interface TutorialService {
    List<Tutorial> getAllTuts();

    Tutorial getAllTutsId(Long id);

    Tutorial addTuts(Tutorial tuts);

    Tutorial deleteTuts(Long id);
}

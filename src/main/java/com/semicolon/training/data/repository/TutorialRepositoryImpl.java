package com.semicolon.training.data.repository;

import com.semicolon.training.data.models.Tutorial;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TutorialRepositoryImpl implements  TutorialRepository{
    private final JdbcTemplate jdbcTemplate;

    public TutorialRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Tutorial> findAll() {
        return null;
    }

    @Override
    public int addTutorial(Tutorial tuts) {
        return 0;
    }

    @Override
    public int deleteTuts(Long id) {
        return 0;
    }
}

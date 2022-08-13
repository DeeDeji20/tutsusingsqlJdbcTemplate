package com.semicolon.training.data.repository;

import com.semicolon.training.data.models.Tutorial;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
        String sql = """
                INSERT INTO tutorial(title, description, level, published, created) VALUES(?, ?, ?, ?, ?);
                """;
        return jdbcTemplate.update(sql, tuts.getTitle(), tuts.getDescription(), tuts.getLevel(), tuts.isPublished(), tuts.getCreated());
    }

    @Override
    public int deleteTuts(Long id) {
        return 0;
    }
}

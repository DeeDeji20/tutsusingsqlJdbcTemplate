package com.semicolon.training.data.repository;

import com.semicolon.training.data.models.Tutorial;
import com.semicolon.training.data.models.TutorialRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class TutorialRepositoryImpl implements  TutorialRepository{
    private final JdbcTemplate jdbcTemplate;

    public TutorialRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Tutorial> findAll() {
        var sql = """
                SELECT id, title, description, level, published, created
                FROM tutorial
                LIMIT 100
                """;
        return jdbcTemplate.query(sql, new TutorialRowMapper());
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
        var sql = """
                  DELETE FROM tutorial
                  WHERE id = ?
                  """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Tutorial> findById(Long id) {
        var sql = """
                SELECT id, title, description, level, published, created
                FROM tutorial
                WHERE id = ?
                """;
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new TutorialRowMapper(), id));
    }
}

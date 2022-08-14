package com.semicolon.training.data.repository;

import com.semicolon.training.data.models.Tutorial;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class TutorialRepositoryImpl implements  TutorialRepository{
    private final JdbcTemplate jdbcTemplate;

    public TutorialRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Tutorial> findAll() {
        var sql = """
                SELECT id, title, desccription, created
                FROM tutorial
                LIMIT 100
                """;
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            return new Tutorial(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getInt("level"),
                    rs.getBoolean("published"),
                    LocalDate.parse(rs.getString("created"))
            );

        });
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

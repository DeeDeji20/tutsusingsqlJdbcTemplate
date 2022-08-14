package com.semicolon.training.data.models;

import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TutorialRowMapper implements RowMapper<Tutorial> {

    @Override
    public Tutorial mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Tutorial(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getInt("level"),
                rs.getBoolean("published"),
                LocalDate.parse(rs.getString("created"))
        );

    }
}

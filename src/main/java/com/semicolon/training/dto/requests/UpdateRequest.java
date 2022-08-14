package com.semicolon.training.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRequest {
    private String title;
    private String description;
    private int level;
    private boolean published;
}

package com.fly.test.question_chooser;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Topic {

    private Integer id;

    private Integer parentId;

    private String subject;

    private String question;

    private String answer;

    private Integer weight;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}

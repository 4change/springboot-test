package com.fly.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fly.test.entity.Subject;
import com.fly.test.mapper.SubjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class QuestionChooserApplicationTests {

    @Autowired
    private SubjectMapper subjectMapper;

    @Test
    public void testMapper() {
        List<Subject> subjects = subjectMapper.selectList(new QueryWrapper<>());
        log.info("subjectList-------------" + subjects);
    }

}

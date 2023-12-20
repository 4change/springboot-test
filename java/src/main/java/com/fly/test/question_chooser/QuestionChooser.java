package com.fly.test.question_chooser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionChooser {

    public static void main(String[] args) {
        List<Topic> topicList = new ArrayList<>();
        topicList.add(new Topic("分布式", 1, 2));
        topicList.add(new Topic("MySQL", 2, 2));
        topicList.add(new Topic("Redis", 3, 2));
        topicList.add(new Topic("消息队列", 4, 2));
        topicList.add(new Topic("设计模式", 5, 2));
        topicList.add(new Topic("Java", 6, 2));
        topicList.add(new Topic("操作系统", 7, 2));

        Random random = new Random();
    }

}

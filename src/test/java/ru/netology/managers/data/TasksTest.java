package ru.netology.managers.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    public SimpleTask trueSimpleTask = new SimpleTask(3, "match");
    public SimpleTask falseSimpleTask = new SimpleTask(2, "miss");

    String[] trueSubtasks10 = {"miss", "miss", "miss", "miss", "miss", "miss", "miss", "miss", "miss", "match"};
    public Epic trueEpic = new Epic(8, trueSubtasks10);
    String[] falseSubtasks = {"m", "a", "t", "c", "h"};
    public Epic falseEpic = new Epic(5, falseSubtasks);

    public Meeting trueTopicMeeting = new Meeting(
            11,
            "match",
            "miss",
            "miss"
    );
    public Meeting trueProjectMeeting = new Meeting(
            83,
            "miss",
            "match",
            "miss"
    );
    public Meeting falseMeeting = new Meeting(
            14,
            "miss",
            "miss",
            "match"
    );

    @Test
    public void trueSimpleTaskTest() {

        boolean actual = trueSimpleTask.matches("match");
        Assertions.assertTrue(actual);
    }

    @Test
    public void falseSimpleTaskTest() {

        boolean actual = falseSimpleTask.matches("match");
        Assertions.assertFalse(actual);
    }

    @Test
    public void trueEpicTest() {

        boolean actual = trueEpic.matches("match");
        Assertions.assertTrue(actual);
    }

    @Test
    public void falseEpicTest() {

        boolean actual = falseEpic.matches("match");
        Assertions.assertFalse(actual);
    }

    @Test
    public void trueTopicMeetingTest() {

        boolean actual = trueTopicMeeting.matches("match");
        Assertions.assertTrue(actual);
    }

    @Test
    public void trueProjectMeetingTest() {

        boolean actual = trueProjectMeeting.matches("match");
        Assertions.assertTrue(actual);
    }

    @Test
    public void falseMeetingTest() {

        boolean actual = falseMeeting.matches("match");
        Assertions.assertFalse(actual);
    }
}
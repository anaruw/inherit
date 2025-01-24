package ru.netology.managers.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    public String trueQuery = "match";
    public String falseQuery = "miss";

    public SimpleTask trueSimpleTask = new SimpleTask(3, trueQuery);
    public SimpleTask falseSimpleTask = new SimpleTask(2, falseQuery);

    String[] trueSubtasks10 = {falseQuery, falseQuery, falseQuery, falseQuery, falseQuery, falseQuery, falseQuery, falseQuery, falseQuery, trueQuery};
    public Epic trueEpic = new Epic(8, trueSubtasks10);
    String[] falseSubtasks = {"m", "a", "t", "c", "h"};
    public Epic falseEpic = new Epic(5, falseSubtasks);

    public Meeting trueTopicMeeting = new Meeting(
            11,
            trueQuery,
            falseQuery,
            falseQuery
    );
    public Meeting trueProjectMeeting = new Meeting(
            83,
            falseQuery,
            trueQuery,
            falseQuery
    );
    public Meeting falseMeeting = new Meeting(
            14,
            falseQuery,
            falseQuery,
            trueQuery
    );

    @Test
    public void trueSimpleTaskTest() {

        boolean actual = trueSimpleTask.matches(trueQuery);
        Assertions.assertTrue(actual);
    }

    @Test
    public void falseSimpleTaskTest() {

        boolean actual = falseSimpleTask.matches(trueQuery);
        Assertions.assertFalse(actual);
    }

    @Test
    public void trueEpicTest() {

        boolean actual = trueEpic.matches(trueQuery);
        Assertions.assertTrue(actual);
    }

    @Test
    public void falseEpicTest() {

        boolean actual = falseEpic.matches(trueQuery);
        Assertions.assertFalse(actual);
    }

    @Test
    public void trueTopicMeetingTest() {

        boolean actual = trueTopicMeeting.matches(trueQuery);
        Assertions.assertTrue(actual);
    }

    @Test
    public void trueProjectMeetingTest() {

        boolean actual = trueProjectMeeting.matches(trueQuery);
        Assertions.assertTrue(actual);
    }

    @Test
    public void falseMeetingTest() {

        boolean actual = falseMeeting.matches(trueQuery);
        Assertions.assertFalse(actual);
    }
}
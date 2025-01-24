package ru.netology.managers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.managers.data.*;

public class TodosTest {

    TasksTest testData = new TasksTest();

    String trueQuery = testData.trueQuery;
    String falseQuery = "false";

    Task trueSimpleTask = testData.trueSimpleTask;
    Task trueEpic = testData.trueEpic;
    Task trueTopicMeeting = testData.trueTopicMeeting;
    Task trueProjectMeeting = testData.trueProjectMeeting;

    @Test
    public void shouldAddThreeTasksOfDifferentType() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfZeroTasksCount() {

        Todos todos = new Todos();

        Task[] expected = {};
        Task[] actual = todos.search(trueQuery);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchRequiredTasks() {

        Todos todos = new Todos();

        todos.add(trueSimpleTask);
        todos.add(trueEpic);
        todos.add(trueTopicMeeting);
        todos.add(trueProjectMeeting);

        Task[] expected = {trueSimpleTask, trueEpic, trueTopicMeeting, trueProjectMeeting};
        Task[] actual = todos.search(trueQuery);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNothing() {

        Todos todos = new Todos();

        todos.add(trueSimpleTask);
        todos.add(trueEpic);
        todos.add(trueTopicMeeting);
        todos.add(trueProjectMeeting);

        Task[] expected = {};
        Task[] actual = todos.search(falseQuery);

        Assertions.assertArrayEquals(expected, actual);
    }
}
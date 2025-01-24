package ru.netology.managers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.managers.data.*;

public class TodosTest {

    TasksTest rsc = new TasksTest();

    public String query = "match";

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
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchRequiredTasks() {

        Task[] testTasks = {
                rsc.trueSimpleTask,
                rsc.falseSimpleTask,
                rsc.trueEpic,
                rsc.falseEpic,
                rsc.trueTopicMeeting,
                rsc.trueProjectMeeting,
                rsc.falseMeeting,
        };

        Todos todos = new Todos();

        for (Task task : testTasks) {

            todos.add(task);
        }

        Task[] expected = {testTasks[0], testTasks[2], testTasks[4], testTasks[5]};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNothing() {

        Task[] testTasks = {
                rsc.falseSimpleTask,
                rsc.falseEpic,
                rsc.falseMeeting,
        };

        Todos todos = new Todos();

        for (Task task : testTasks) {

            todos.add(task);
        }

        Task[] expected = {};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }
}
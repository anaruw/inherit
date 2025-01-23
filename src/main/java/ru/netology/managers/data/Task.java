package ru.netology.managers.data;

public class Task {

    private int id;

    public Task(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean matches(String query) {
        return false;
    }
}
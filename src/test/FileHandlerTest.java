package test;

import data.Task;
import filehandler.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {
    FileHandler fileHandler = new FileHandler("TestFile");

    @org.junit.jupiter.api.Test
    void saveAndLoad() {
        ArrayList<Task> list = new ArrayList<Task>();
        Task task1 = new Task("Sewden", "Stockholm", LocalDate.parse("1987-07-05"));
        Task task2 = new Task(";kjgh", "lkjh", LocalDate.parse("1986-05-24"));
        Task task3 = new Task("task3", "tit3", LocalDate.parse("1986-05-24"));

        list.add(task1);
        list.add(task2);
        list.add(task3);

        fileHandler.save(list);
        ArrayList<Task> loadedList = fileHandler.load();
        assertEquals(list, loadedList);
    }
}

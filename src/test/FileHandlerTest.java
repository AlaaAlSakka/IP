package test;

import data.Task;
import filehandler.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest
{
    FileHandler fileHandler = new FileHandler("TestFile");


    /**
     * testing the load and save method
     */
    @org.junit.jupiter.api.Test
    void saveAndLoad()
    {
        ArrayList<Task> list = new ArrayList<Task>();
        Task task1 = new Task("Sewden", "Stockholm", LocalDate.parse("1987-07-05"));
        Task task2 = new Task("KTH", "Java", LocalDate.parse("2019-05-24"));
        Task task3 = new Task("KTH", "Software", LocalDate.parse("2019-03-24"));

        list.add(task1);
        list.add(task2);
        list.add(task3);

        fileHandler.save(list);
        ArrayList<Task> loadedList = fileHandler.load();
        assertEquals(list, loadedList);
    }
}

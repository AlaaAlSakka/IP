package test;

import data.Task;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    Task testTask = new Task("pro", "task1", LocalDate.parse("2020-12-12"));
    @Test
    void getTitle()
    {
        assertEquals("task1", testTask.getTitle());
    }

    @Test
    void setTitle()
    {
        testTask.setTitle("check");
        assertEquals("check", testTask.getTitle());
    }

    @Test
    void getDueDate()
    {
      assertEquals (LocalDate.parse("2020-12-12"), testTask.getDueDate());
    }

    @Test
    void setDueDate()
    {
        testTask.setDueDate(LocalDate.parse("1987-07-05"));
        assertEquals(LocalDate.parse("1987-07-05"), testTask.getDueDate());
    }

    @Test
    void setStatus()
    {
        testTask.setStatus("Done");
        assertEquals ("Done", testTask.getStatus());
    }

    @Test
    void getStatus()
    {
        assertEquals ("notDone", testTask.getStatus());
    }

    @Test
    void getProject()
    {
      assertEquals ("pro", testTask.getProject());
    }

    @Test
    void setProject()
    {
       testTask.setProject("School");
       assertEquals ("School", testTask.getProject());
    }

    @Test
    void compareTo()
    {
        assertEquals (0 , testTask.getDueDate().compareTo( LocalDate.parse("2020-12-12")));
    }

    @Test
    void equals()
    {
        Task newTask = new Task("pro", "task1", LocalDate.parse("2020-12-12"));
      assertTrue(testTask.equals(newTask));
    }

    @Test
    void toStringTest()
    {
        assertEquals ("Project: pro--------Task:task1--------2020-12-12--------notDone", testTask.toString());
    }
}
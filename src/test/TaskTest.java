package test;

import data.Task;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    Task testTask = new Task("pro", "task1", LocalDate.parse("2020-12-12"));

    /**
     * testing all the setthers and getters
     */
    @Test
    void getTitle() // test getTitle method
    {
        assertEquals("task1", testTask.getTitle()); // check if the expected value and the actual value are equals
    }

    @Test
    void setTitle() // test setTitle method
    {
        testTask.setTitle("check");
        assertEquals("check", testTask.getTitle()); // check if the expected value and the actual value are equals
    }

    @Test
    void getDueDate() // test getDueDate
    {
        assertEquals (LocalDate.parse("2020-12-12"), testTask.getDueDate()); // check if the expected value and the actual value are equals
    }

    @Test
    void setDueDate() // test setDueDate
    {
        testTask.setDueDate(LocalDate.parse("1987-07-05")); // set a new due date to test the method
        assertEquals(LocalDate.parse("1987-07-05"), testTask.getDueDate()); //check if the expected value and the actual value are equals
    }

    @Test
    void setStatus() // test setStatus
    {
        testTask.setStatus("Done"); //change the status to test the method
        assertEquals ("Done", testTask.getStatus()); // check if the expected value and the actual value are equals
    }

    @Test
    void getStatus() // test getStatus
    {
        assertEquals ("notDone", testTask.getStatus()); // check if the expected value and the actual value are equals
    }

    @Test
    void getProject() // test getProject
    {
      assertEquals ("pro", testTask.getProject()); // check if the expected value and the actual value are equals
    }

    @Test
    void setProject() // test setProject
    {
       testTask.setProject("School"); // change the project name to test the method
       assertEquals ("School", testTask.getProject()); // check if the expected value and the actual value are equals
    }

    @Test
    void compareTo() // test compareTo
    {
        assertEquals (0 , testTask.getDueDate().compareTo( LocalDate.parse("2020-12-12"))); // check if the expected value and the actual value are equals
    }

    @Test
    void equals() // test equals
    {
        Task newTask = new Task("pro", "task1", LocalDate.parse("2020-12-12"));
      assertTrue(testTask.equals(newTask)); // check if the expected value and the actual value are equals
    }

    @Test
    void toStringTest() // test toString
    {
        assertEquals ("Project: pro--------Task:task1--------2020-12-12--------notDone", testTask.toString()); // check if the expected value and the actual value are equals
    }
}
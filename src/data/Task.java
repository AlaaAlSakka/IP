package data;

import java.io.Serializable;
import java.time.LocalDate;


public class Task implements Comparable<Task>, Serializable {

    private String project;
    private String title;
    private LocalDate dueDate;
    private String status;


    public Task(String project, String title, LocalDate date)
    {
        this.title = title;
        this.project = project;
        this.dueDate = date;
        this.status = "notDone";
    }



    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {

        this.title = title;
    }

    public LocalDate getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate)
    {
        this.dueDate = dueDate;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public String getProject()
    {

        return project;
    }


    public void setProject(String project)
    {
        this.project = project;
    }


    @Override
    public String toString()
    {
        return "Project: " + project + "--------" +"Task:" + title + "--------" + dueDate + "--------" + status;
    }

    @Override
    public int compareTo(Task t )
    {
        return dueDate.compareTo(t.getDueDate());
    }

    @Override
    public boolean equals(Object otherTask){
        if (!(otherTask instanceof Task))
            return false;
        Task taskToCompare = (Task) otherTask;
        return  taskToCompare.title.equalsIgnoreCase(this.title) &&
                taskToCompare.dueDate.equals(this.dueDate) &&
                taskToCompare.project.equals(this.project) &&
                taskToCompare.status.equals(this.status);
    }
}








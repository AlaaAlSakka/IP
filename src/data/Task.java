package data;

import java.io.Serializable;
import java.time.LocalDate;


public class Task implements Comparable<Task>, Serializable
{

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


    /**
     * get the title name
     * @return title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * set the title name
     * @param title
     */
    public void setTitle(String title)
    {

        this.title = title;
    }

    /**
     * get the due date
     * @return the due date
     */

    public LocalDate getDueDate()
    {

        return dueDate;
    }

    /**
     * set the due date
     * @param dueDate
     */

    public void setDueDate(LocalDate dueDate)
    {
        this.dueDate = dueDate;
    }

    /**
     * set status
     * @param status
     */
    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     *  get status
     * @return the status of the task
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * get project name
     * @return the project name
     */
    public String getProject()
    {

        return project;
    }

    /**
     * set project name
     * @param project
     */

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
    public boolean equals(Object otherTask)
    {
        if (!(otherTask instanceof Task))
            return false;
        Task taskToCompare = (Task) otherTask;
        return  taskToCompare.title.equalsIgnoreCase(this.title) &&
                taskToCompare.dueDate.equals(this.dueDate) &&
                taskToCompare.project.equals(this.project) &&
                taskToCompare.status.equals(this.status);
    }
}








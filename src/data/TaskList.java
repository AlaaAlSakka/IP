package data;

import data.Task;

import java.time.format.DateTimeParseException;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import filehandler.FileHandler;


public class TaskList
{

    public static ArrayList<Task> taskList;
    private static final String filepath = "file";
    private static final long serialVersionUID = 1L;

    private FileHandler fileHandler = new FileHandler("file");
    private Scanner scanner;

     public TaskList() throws Exception
     {
         taskList = load(); //load the saved tasks in the array list taskList
         scanner = new Scanner(System.in).useDelimiter("\n");
     }

    /**
     * getting the task details from the user, title, due date and project name.
     * @return the task
     */
    public Task getTaskDetail()
    {
        System.out.println("Enter the project name  ");
        String project = scanner.next();
        System.out.println("Enter the task you want to add");
        String title = scanner.next();
        System.out.println("Enter the due date of this task in this format: dd/MM/yyyy  ");
        LocalDate date = checkingDateFormat(); //calling checkingDateFormat to check if the date entered is in the right format and not an old date
        Task task = new Task(project, title, date);
        return task;
    }


    public void addTask(Task task)
    {
         taskList.add(task); //adding the task to the array list
    }


    /**
     * this is to check the date formate that the user entered if it is right formate or no and if the date is old or no
     * @return parse
     */
    public LocalDate checkingDateFormat()
    {
        while (true)
        {
            String date = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try
            {
                LocalDate parse = LocalDate.parse(date, formatter);

                if (LocalDate.now().compareTo(parse) <= 0)
                {
                    return parse;
                }
                else if (LocalDate.now().compareTo(parse) > 0) //comparing the entered date if it is older than today's date
                    System.out.println("This date is an old date please enter a new date dd/MM/yyyy"); //if the date is old it will print this message for the user

            }
            catch (DateTimeParseException exc)
            {
                System.out.printf("Enter the right format for the data dd/MM/yyyy "); // if the formatting of the date is wrong this message will be printed for the user
            }
        }
    }

    /**
     * A method to remove a task
     */
    public void removeTask()
    {
        listTasks(); //list all tasks with the index number
        Task taskToRemove = taskList.get(integerValidator(1, taskList.size()) - 1); // choosing the task to remove by entering the index number
        taskList.remove(taskToRemove); // remove the task
    }


    /**
     * set the status of the task as done.
     */

    public void markasDone()
    {
        listTasks(); //list all tasks with the index number
        Task taskDone = taskList.get(integerValidator(1, taskList.size())     -1); //calling the method for choosing the task to mark as done by entering the index number
        taskDone.setStatus("Done");
        System.out.println(taskDone);
        return;
    }

    /**
     * method for choosing the task by entering the index number
     * @param min
     * @param max
     * @return
     */

    public int integerValidator(int min, int max)
    {
        int number;
        do {
            System.out.printf("hint: Please choose a number in range %d to %d\n", min, max);
            while (!scanner.hasNextInt())
            {
                System.out.printf("NOT a number! PLEASE choose a number in range %d to %d \n", min, max);
                scanner.next();
            }
            number = scanner.nextInt();

        } while(number > max || number < min);
        return number;
    }


    /**
     * method to edit the task title, project and due date
     */

    public void editTask()
    {
        listTasks();
        Task taskToEdit = taskList.get(integerValidator(1, taskList.size()) - 1);

        System.out.println("Enter the new project");
        String newProject = scanner.next();
        taskToEdit.setProject(newProject); // set the new project name that has been entered by the user

        System.out.println("Enter the new title");
        taskToEdit.setTitle(scanner.next());

        taskToEdit.getStatus();

        System.out.println("Enter the due date of this task in this format: dd/MM/yyyy ");
        LocalDate date = checkingDateFormat();
        taskToEdit.setDueDate(date);
    }

    /**
     * show all tasks the user entered
     */

    public void listTasks()
    {
        System.out.println("\nTasks are: ");
        for(int i = 0; i < taskList.size(); i++)
         {
             System.out.println( (i+1) + ") " + taskList.get(i));
         }
    }

    /**
     * show all tasks according to due date
     */

    public void listbyDate()
    {
        ArrayList dateList = (ArrayList) taskList.clone();
        Collections.sort(dateList);
        for (Object task : dateList)
        {
            System.out.println(task);
        }
    }

    /**
     * list tasks according to a specific project name that the user entered
     */

    public void showProjectTasks()
    {
        ArrayList projectList = (ArrayList) taskList.clone();
        String p;
        Scanner scanner = new Scanner(System.in);
        p = scanner.nextLine();
        Iterator<Task> it = projectList.iterator();
        boolean finds = false;
        while (it.hasNext())
        {
            Task r = it.next();
            if (p.equals(r.getProject()))
            {
                System.out.println(r);
                finds = true;
            }
        }
        if (!finds)
        {
            System.out.println("There is no project with this name"); // if the project name doesn't exist it will print this message to the user

        }
    }

    public ArrayList<Task> taskByStatus(String status)
    {
         return (ArrayList<Task>)
                 taskList.stream()
                 .filter(x -> x.getStatus().equals(status))
                 .collect(Collectors.toList());
    }

    public String checkTask()
    {
         int doneTasks = taskByStatus("Done").size(); //number of done tasks
         int notDoneTasks = taskByStatus("notDone").size();
         return String.format("\n\nYou have %d tasks 'Done' and %d tasks 'Not Done'", doneTasks, notDoneTasks); // number of not done tasks

    }



    public void save()
    {
       fileHandler.save(taskList); //calling save method from FileHandler class
    }

    public ArrayList<Task> load() throws Exception
    {
        ArrayList<Task> test = fileHandler.load(); // calling load method from FileHandler class

        for (Task task : test)
        {
            System.out.println(task);
        }
        return test;
    }
}





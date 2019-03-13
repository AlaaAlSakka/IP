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
         taskList = load();
         scanner = new Scanner(System.in).useDelimiter("\n");
     }

    public Task getTaskDetail()
    {
        System.out.println("Enter the project name  ");
        String project = scanner.next();
        System.out.println("Enter the task you want to add");
        String title = scanner.next();
        System.out.println("Enter the due date of this task in this format: dd/MM/yyyy  ");
        LocalDate date = checkingDateFormat();
        Task task = new Task(project, title, date);
//        taskList.add(task);
        return task;
    }


    public void addTask(Task task){
         taskList.add(task);
    }

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
                else if (LocalDate.now().compareTo(parse) > 0)
                    System.out.println("This date is an old date please enter a new date dd/MM/yyyy");

            }
            catch (DateTimeParseException exc)
            {
                System.out.printf("Enter the right format for the data dd/MM/yyyy ");
            }
        }
    }


    public void removeTask()
    {
        listTasks();
        Task taskToRemove = taskList.get(integerValidator(1, taskList.size()) - 1);
        taskList.remove(taskToRemove);
    }




    public void markasDone()
    {
        listTasks();
        Task taskDone = taskList.get(integerValidator(1, taskList.size())     -1);
        taskDone.setStatus("Done");
        System.out.println(taskDone + " is done");
        return;
    }


    public int integerValidator(int min, int max){
        int number;
        do {
            System.out.printf("hint: Please choose a number in range %d to %d\n", min, max);
            while (!scanner.hasNextInt()) {
                System.out.printf("NOT a number! PLEASE choose a number in range %d to %d \n", min, max);
                scanner.next();
            }
            number = scanner.nextInt();

        } while(number > max || number < min);
        return number;
    }


    public void editTask()
    {
        listTasks();
        Task taskToEdit = taskList.get(integerValidator(1, taskList.size()) - 1);

        System.out.println("Enter the new project");
        String newProject = scanner.next();
        taskToEdit.setProject(newProject);

        System.out.println("Enter the new title");
        taskToEdit.setTitle(scanner.next());

        taskToEdit.getStatus();

        System.out.println("Enter the due date of this task in this format: dd/MM/yyyy ");
        LocalDate date = checkingDateFormat();
        taskToEdit.setDueDate(date);
    }



    public void listTasks()
    {
        System.out.println("\nTasks are: ");
        for(int i = 0; i < taskList.size(); i++)
         {
             System.out.println( (i+1) + ") " + taskList.get(i));
         }
    }



    public void listbyDate()
    {
        ArrayList dateList = (ArrayList) taskList.clone();
        Collections.sort(dateList);
        for (Object task : dateList)
        {
            System.out.println(task);
        }
    }


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
            System.out.println("There is no project with this name");

        }
    }

    public ArrayList<Task> taskByStatus(String status){
         return (ArrayList<Task>)
                 taskList.stream()
                 .filter(x -> x.getStatus().equals(status))
                 .collect(Collectors.toList());
    }

    public String checkTask(){
         int doneTasks = taskByStatus("Done").size();
         int notDoneTasks = taskByStatus("notDone").size();
         return String.format("\n\nYou have %d tasks 'Done' and %d tasks 'Not Done'", doneTasks, notDoneTasks);

    }



    public void save()
    {
       fileHandler.save(taskList);
    }

    public ArrayList<Task> load() throws Exception
    {
        ArrayList<Task> test = fileHandler.load();

        for (Task task : test)
        {
            System.out.println(task);
        }
        return test;
    }
}





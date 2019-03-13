import data.TaskList;

import java.util.Scanner;
public class Start
{

    public static void main(String[] args) throws Exception

    {
        new Start().myMethod();

    }

    public void myMethod () throws Exception
    {
        TaskList taskList =new TaskList();
       // data.Task task= new data.Task()


        Scanner input = new Scanner(System.in);
        String choice = null;

        do
            {
            System.out.println(taskList.checkTask());
            System.out.println("----------------------------------------\nPlease Choose an option\n");
            System.out.println("(1) Add a task ");
            System.out.println("(2) Remove a task ");
            System.out.println("(3) Update a task as done ");
            System.out.println("(4) Edit a task ");
            System.out.println("(5) Show tasks ");
            System.out.println("(6) Show tasks according to due date ");
            System.out.println("(7) Show tasks according to a selected project ");
            System.out.println("(8) Save");
            System.out.println("(9) Load ");
            System.out.println("(0) Exit ");
            choice = input.nextLine();
            switch (choice) {
                case "0":
                    //Generally used to indicate successful termination.
                    System.exit(0);
                    break;
                case "1":
                    taskList.addTask(taskList.getTaskDetail());
                    break;
                case "2":
                    System.out.println("Remove a task");
                    taskList.removeTask();
                    break;
                case "3":
                    System.out.println("Update a task as done");
                    taskList.markasDone();
                    break;

                case "4":
                    System.out.println("Edit a task ");
                    taskList.editTask();
                    break;
                case "5":
                    System.out.println("List for all tasks");
                    taskList.listTasks();
                    break;
                case "6":
                    System.out.println("List for all tasks according to due date ");
                    taskList.listbyDate();
                    break;
                case "7":
                    System.out.println("Enter a project name to see all the tasks for it ");
                    taskList.showProjectTasks();
                    break;
                case "8":
                    System.out.println("Save ");
                    taskList.save();
                    break;
                case "9":
                    System.out.println("Load ");
                    taskList.load();
                    break;


                default:
                    System.out.println("Please enter a valid choice.");
                    break;


            }
        }

        while (true);

    }



}

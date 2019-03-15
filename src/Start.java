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



        Scanner input = new Scanner(System.in);
        String choice = null;

        /**
         * the menu for the user so he can enter the number of the choice he wants to do
         */


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


                /**
                 * calling the methods regarding to the user choice
                 */

            switch (choice) {
                case "0":
                    //Generally used to indicate successful termination.
                    System.exit(0);
                    break;
                case "1":
                    taskList.addTask(taskList.getTaskDetail()); // calling gatTaskDetail method to add a task
                    break;
                case "2":
                    System.out.println("Remove a task");
                    taskList.removeTask(); // calling removeTask method to remove a task
                    break;
                case "3":
                    System.out.println("Update a task as done");
                    taskList.markasDone(); // calling markasDone method to update a method as done
                    break;

                case "4":
                    System.out.println("Edit a task ");
                    taskList.editTask(); // calling editTask method
                    break;
                case "5":
                    System.out.println("List for all tasks");
                    taskList.listTasks(); // calling listTasks method to show all the tasks the user have
                    break;
                case "6":
                    System.out.println("List for all tasks according to due date ");
                    taskList.listbyDate(); // calling listbyDate method to list all tasks according to due date
                    break;
                case "7":
                    System.out.println("Enter a project name to see all the tasks for it ");
                    taskList.showProjectTasks(); // calling showProjectTasks method to show tasks according to a project
                    break;
                case "8":
                    System.out.println("Save ");
                    taskList.save(); // calling save method
                    break;
                case "9":
                    System.out.println("Load ");
                    taskList.load(); // calling load method
                    break;


                default:
                    System.out.println("Please enter a valid choice."); // if the user entered a wrong choise
                    break;


            }
        }

        while (true);

    }



}

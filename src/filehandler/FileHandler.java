package filehandler;

import data.Task;

import java.io.*;
import java.util.ArrayList;




public class FileHandler
{
    private String filepath;


    public FileHandler(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Save the list of task to a file
     * @param list The list to be saved.
     */
    public void save(ArrayList<Task> list)
{
    try
    {
        FileOutputStream fileOutputStream = new FileOutputStream(this.filepath);
        ObjectOutputStream objectInputStream = new ObjectOutputStream(fileOutputStream);
        objectInputStream.writeObject(list);
        objectInputStream.close();
    }
    catch (Exception e)
    {
        System.out.println(e.getMessage());
    }
}

    /**
     * load the list of task from the file
     * @return list
     */
    public ArrayList<Task> load()
{
    ArrayList<Task> list = new ArrayList<>();
    try
    {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(this.filepath));
        list = (ArrayList<Task>) objectInputStream.readObject();
        objectInputStream.close();
    }
    catch (Exception e)
    {
        System.out.println(e.getMessage());
    }
    return list;
}
}



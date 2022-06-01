package pl.pijok.task;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import pl.pijok.Controllers;
import pl.pijok.screen.ScreenName;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TasksController {

    private List<Task> tasks;

    public TasksController(){
        tasks = new ArrayList<>();
    }

    public void load() throws IOException, ClassNotFoundException {
        File file = new File("tasks.txt");

        if(!file.exists()){
            return;
        }

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        tasks = (List<Task>) objectInputStream.readObject();
        objectInputStream.close();

    }

    public void save() throws IOException {
        File file = new File("tasks.txt");

        if(file.exists()){
            file.delete();
        }
        file.createNewFile();

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(tasks);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public void addTask(String name, String description, boolean completed){
        Task task = new Task(name, description, completed);
        addTask(task);
    }

    public void addTask(Task task){
        tasks.add(task);

        TasksPane tasksPane = (TasksPane) Controllers.getScreenController().getScreen(ScreenName.TASKS);

        Button button = new Button(task.getName());
        button.setOnMouseClicked(new TaskClickEvent(task));

        tasksPane.getInnerVBox().getChildren().add(button);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}

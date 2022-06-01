package pl.pijok;

import pl.pijok.screen.ScreenController;
import pl.pijok.task.TasksController;

public class Controllers {

    private static ScreenController screenController;
    private static TasksController tasksController;

    public static void create(){
        screenController = new ScreenController();
        tasksController = new TasksController();
    }

    public static ScreenController getScreenController() {
        return screenController;
    }

    public static TasksController getTasksController() {
        return tasksController;
    }
}

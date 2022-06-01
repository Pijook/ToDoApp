package pl.pijok;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.pijok.screen.ScreenController;
import pl.pijok.screen.ScreenName;
import pl.pijok.task.NewTaskPane;
import pl.pijok.task.TasksPane;

import java.io.IOException;

public class Main extends Application {

    private static Group root;
    private static Scene mainScene;

    public static void main(String[] args){
        load();

        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        root = new Group();
        mainScene = new Scene(root, 640, 480);

        stage.setScene(mainScene);
        stage.setTitle("To Do");
        stage.show();

        Controllers.getScreenController().setMainScene(mainScene);

        Controllers.getScreenController().addScreen(ScreenName.TASKS, new TasksPane());
        Controllers.getScreenController().addScreen(ScreenName.NEW_TASK, new NewTaskPane());

        Controllers.getScreenController().activate(ScreenName.TASKS);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        save();
    }

    private static void load(){
        Controllers.create();
        try {
            Controllers.getTasksController().load();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void save(){
        try {
            Controllers.getTasksController().save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Group getRoot() {
        return root;
    }

    public static Scene getMainScene() {
        return mainScene;
    }
}

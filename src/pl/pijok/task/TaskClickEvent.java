package pl.pijok.task;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import pl.pijok.Controllers;
import pl.pijok.screen.ScreenName;

public class TaskClickEvent implements EventHandler<MouseEvent> {

    private final Task task;

    public TaskClickEvent(Task task){
        this.task = task;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Controllers.getScreenController().addScreen(ScreenName.SELECT_TASK, new SelectedTaskPane(task));
        Controllers.getScreenController().activate(ScreenName.SELECT_TASK);
        System.out.println(task);
    }

}

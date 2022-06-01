package pl.pijok.task;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import pl.pijok.Controllers;
import pl.pijok.screen.ScreenName;

public class SelectedTaskPane extends StackPane {

    private final Task task;

    public SelectedTaskPane(Task task){
        this.task = task;

        setPrefWidth(Controllers.getScreenController().getMainScene().getWidth());
        setPrefHeight(Controllers.getScreenController().getMainScene().getHeight());

        VBox vBox = new VBox();
        vBox.setSpacing(15);
        vBox.setAlignment(Pos.CENTER);

        Label nameLabel = new Label(task.getName());

        Label descriptionLabel = new Label(task.getDescription());

        CheckBox completedCheckBox = new CheckBox();
        completedCheckBox.setSelected(task.isCompleted());

        Button button = new Button("Return");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Controllers.getScreenController().activate(ScreenName.TASKS);
                Controllers.getScreenController().removeScreen(ScreenName.SELECT_TASK);
            }
        });

        vBox.getChildren().addAll(nameLabel, descriptionLabel, completedCheckBox, button);

        getChildren().add(vBox);
    }

    public Task getTask() {
        return task;
    }
}

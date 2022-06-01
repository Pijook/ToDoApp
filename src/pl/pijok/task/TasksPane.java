package pl.pijok.task;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import pl.pijok.Controllers;
import pl.pijok.Main;
import pl.pijok.screen.ScreenName;

public class TasksPane extends StackPane {

    private VBox outerVBox;
    private VBox innerVBox;

    public TasksPane(){
        setPrefWidth(Controllers.getScreenController().getMainScene().getWidth());
        setPrefHeight(Controllers.getScreenController().getMainScene().getHeight());

        outerVBox = new VBox();
        outerVBox.setAlignment(Pos.CENTER);
        outerVBox.setSpacing(15);

        innerVBox = new VBox();
        innerVBox.setAlignment(Pos.CENTER);
        innerVBox.setSpacing(5);

        Label titleLabel = new Label("Your tasks");
        titleLabel.setFont(new Font(30));

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(innerVBox);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setMaxSize(400, Main.getMainScene().getHeight() / 2);
        scrollPane.setFitToWidth(true);

        for(Task task : Controllers.getTasksController().getTasks()){
            Button button = new Button(task.getName());
            button.setOnMouseClicked(new TaskClickEvent(task));

            innerVBox.getChildren().add(button);
        }

        Button addNewTaskButton = new Button("Add new task");

        addNewTaskButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Controllers.getScreenController().activate(ScreenName.NEW_TASK);
            }
        });

        outerVBox.getChildren().add(titleLabel);
        outerVBox.getChildren().add(scrollPane);
        outerVBox.getChildren().add(addNewTaskButton);

        getChildren().add(outerVBox);
    }

    public VBox getOuterVBox() {
        return outerVBox;
    }

    public VBox getInnerVBox() {
        return innerVBox;
    }
}

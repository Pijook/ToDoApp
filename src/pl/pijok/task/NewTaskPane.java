package pl.pijok.task;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import pl.pijok.Controllers;
import pl.pijok.screen.ScreenName;

public class NewTaskPane extends StackPane {

    public NewTaskPane(){
        setPrefWidth(Controllers.getScreenController().getMainScene().getWidth());
        setPrefHeight(Controllers.getScreenController().getMainScene().getHeight());

        VBox vBox = new VBox();
        vBox.setSpacing(15);
        vBox.setAlignment(Pos.CENTER);

        Label label = new Label("Add new task");

        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        nameField.setMaxWidth(Controllers.getScreenController().getMainScene().getWidth() / 2);

        TextArea descriptionTextArena = new TextArea();
        descriptionTextArena.setPromptText("Description");
        descriptionTextArena.setMaxWidth(Controllers.getScreenController().getMainScene().getWidth() / 2);
        descriptionTextArena.setMinHeight(Controllers.getScreenController().getMainScene().getHeight() / 4);
        descriptionTextArena.setWrapText(true);

        CheckBox completedCheckBox = new CheckBox();
        completedCheckBox.setText("Completed");

        Button addButton = new Button("Add");
        addButton.requestFocus();
        addButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Controllers.getTasksController().addTask(
                        nameField.getText(),
                        descriptionTextArena.getText(),
                        completedCheckBox.isSelected()
                );

                Controllers.getScreenController().activate(ScreenName.TASKS);
            }
        });

        vBox.getChildren().addAll(label, nameField, descriptionTextArena, completedCheckBox, addButton);

        getChildren().add(vBox);
    }

}

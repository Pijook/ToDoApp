package pl.pijok.screen;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class ScreenController {

    private final HashMap<ScreenName, Pane> screens;
    private Scene mainScene;

    public ScreenController() {
        this.screens = new HashMap<>();
    }

    public void addScreen(ScreenName name, Pane pane){
        screens.put(name, pane);
    }

    public void removeScreen(ScreenName name){
        screens.remove(name);
    }

    public Pane getScreen(ScreenName name){
        return screens.get(name);
    }

    public void activate(ScreenName name){
        mainScene.setRoot(screens.get(name));
    }

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
    }

    public Scene getMainScene() {
        return mainScene;
    }
}

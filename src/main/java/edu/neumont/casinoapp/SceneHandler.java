package edu.neumont.casinoapp;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;

public class SceneHandler {
    private class SceneWrapper {
        private Pane pane;
        private int width;
        private int height;

        // may extend modal functionality

        SceneWrapper(Pane pane, int width, int height) {
            this.pane = pane;
            this.width = width;
            this.height = height;
        }

        public Pane getPane() {
            return pane;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }


    }

    private HashMap<String, SceneWrapper> screenMap = new HashMap<>();
    private Scene main;

    public SceneHandler(Scene main) {
        this.main = main;
    }

    protected void addScene(String name, Pane pane, int width, int height) {
        SceneWrapper sw = new SceneWrapper(pane, width, height);
        screenMap.put(name, sw);
    }

    protected void removeScene(String name) {
        screenMap.remove(name);
    }

    protected void activate(String name) {
        SceneWrapper sw = screenMap.get(name);
        main.setRoot(sw.getPane());
        Stage stage = (Stage) main.getWindow();
        stage.setWidth(sw.getWidth());
        stage.setHeight(sw.getHeight());
    }

    // All code hosted in this class was repurposed from StackOverflow.
    // -- MrEbbinghaus (May 17, 2016) How to switch scenes in JavaFX.
    // Stack Overflow. https://stackoverflow.com/questions/37200845/how-to-switch-scenes-in-javafx
}

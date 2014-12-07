package com.ztaticvienn.marina.main;

import com.ztaticvienn.marina.objects.GameObject;
import com.ztaticvienn.marina.objects.vehicles.Marine;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.input.Keyboard.*;

/**
 * Created by Mike on 06.12.2014.
 */
public class Game {
    public static List<GameObject> gameObjects = new ArrayList<>(1000);
    public static List<GameObject> objectsToAdd = new ArrayList<>(1000);

    Marine player;

    public static void main(String[] args) throws InterruptedException, LWJGLException {
        System.setProperty("org.lwjgl.util.Debug", "true");
        Game game = new Game();
        game.init();
        game.setObjects();
        game.setSounds();
        game.startLoop();
    }

    /**
     * General preparations
     */
    public void init() throws LWJGLException {
        Display.setDisplayMode(new DisplayMode(1024, 768));

        Display.create();

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 1024, 0, 768, 1, -1);
        glMatrixMode(GL_MODELVIEW);
    }

    /**
     * Place objects in game here
     */
    public void setObjects() {
        player = new Marine(100, 100);
        gameObjects.add(player);
        gameObjects.add(new Marine(300, 5));
        gameObjects.add(new Marine(400, 400));
    }

    /**
     * Config sound here
     */
    public void setSounds() {

    }

    /**
     * Start main loop
     * @throws InterruptedException
     */
    public void startLoop() throws InterruptedException {
        while (!Display.isCloseRequested()) {
            this.pollInput();
            this.updateHUD();
            this.updateAndRender();
            Display.update();
            Display.sync(60);
        }
        ;
        Display.destroy();
    }

    public void updateHUD() {

    }

    public void pollInput() {
        while (next()) {
            if (getEventKeyState()) {
                if (getEventKey() == KEY_UP) {
                    player.setMovingForward(true);
                }
                if (getEventKey() == KEY_DOWN) {
                    player.setMovingBackward(true);
                }
                if (getEventKey() == KEY_SPACE) {
                    player.setFiring(true);
                }
            } else {
                if (getEventKey() == KEY_UP) {
                    player.setMovingForward(false);
                }
                if (getEventKey() == KEY_DOWN) {
                    player.setMovingBackward(false);
                }
                if (getEventKey() == KEY_SPACE) {
                    player.setFiring(false);
                }
            }
        }

    }

    /**
     *
     * Updateds and renders objects
     * @throws InterruptedException
     */
    public void updateAndRender() throws InterruptedException {
        Thread.sleep(10);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        gameObjects.addAll(objectsToAdd);
        objectsToAdd.clear();
            for(GameObject object : gameObjects) {
                object.update();
                object.draw();
            }
    }

    public static void addObject(GameObject object) {
        objectsToAdd.add(object);
    }
}

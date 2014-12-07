package com.ztaticvienn.marina.main;

import com.ztaticvienn.marina.objects.GameObject;
import com.ztaticvienn.marina.objects.vehicles.Marine;
import org.lwjgl.glfw.GLFWkeyfun;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

/**
 * Created by Mike on 06.12.2014.
 */
public class Game {
    public static List<GameObject> gameObjects = new ArrayList<>(1000);
    public static List<GameObject> objectsToAdd = new ArrayList<>(1000);

    long window;

    Marine player;

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        game.init();
        game.setControls();
        game.setObjects();
        game.startLoop();
    }

    /**
     * General preparations
     */
    public void init() {
        if ( glfwInit() != GL11.GL_TRUE )
            throw new IllegalStateException("Unable to initialize GLFW");

        window = glfwCreateWindow(1024, 768, "ITS FUCKING AWESOME!!!", NULL, NULL);

        glfwMakeContextCurrent(window);

        GLContext.createFromCurrent();
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
     * Set key controls here
     */
    public void setControls() {
        glfwSetKeyCallback(window, new GLFWkeyfun() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                //Move
                if ( key == GLFW_KEY_UP && action == GLFW_PRESS ) {
                    player.setMovingForward(true);
                }
                if ( key == GLFW_KEY_UP && action == GLFW_RELEASE ) {
                    player.setMovingForward(false);
                }
                if ( key == GLFW_KEY_DOWN && action == GLFW_PRESS ) {
                    player.setMovingBackward(true);
                }
                if ( key == GLFW_KEY_DOWN && action == GLFW_RELEASE ) {
                    player.setMovingBackward(false);
                }
                //Boost speed
                if ( key == GLFW_KEY_LEFT_SHIFT && action == GLFW_PRESS ) {
                    player.setSpeed(3);
                }
                if ( key == GLFW_KEY_LEFT_SHIFT && action == GLFW_RELEASE ) {
                    player.setSpeed(1);
                }
                //Fire
                if ( key == GLFW_KEY_SPACE && action == GLFW_PRESS ) {
                    player.setFiring(true);
                }
                if ( key == GLFW_KEY_SPACE && action == GLFW_RELEASE ) {
                    player.setFiring(false);
                }
                //Reload
                if ( key == GLFW_KEY_R && action == GLFW_PRESS ) {
                    player.setReloading(true);
                    System.out.println("Reloading...");
                }
            }
        });
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
        System.out.printf("Ammo: %d | %d\n", player.getMachineGun().getAmmo(), player.getMachineGun().getCartridges());
        while (glfwWindowShouldClose(this.window) == 0) {
            this.updateHUD();
            this.updateAndRender();
            glfwSwapBuffers(this.window);
            glfwPollEvents();
        }

        glfwTerminate();
    }

    public void updateHUD() {

    }

    /**
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

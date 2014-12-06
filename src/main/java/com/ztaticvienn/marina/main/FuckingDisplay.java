package com.ztaticvienn.marina.main;

import org.lwjgl.opengl.GLContext;

import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.system.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;


/**
 * Created by Mike on 06.12.2014.
 */
public class FuckingDisplay {
    public static void main(String[] args) {
        long window;

        if (glfwInit() == 0) {
            return;
        }

        window = glfwCreateWindow(640, 480, "Hello World", NULL, NULL);
        if (window == 0) {
            glfwTerminate();
            return;
        }

        glfwMakeContextCurrent(window);

        GLContext.createFromCurrent();
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 800, 0, 600, 1, -1);
        glMatrixMode(GL_MODELVIEW);

        while (glfwWindowShouldClose(window) == 0) {
            render();
            glfwSwapBuffers(window);
            glfwPollEvents();
        }

        glfwTerminate();
        System.out.println("lul");
    }

    public static void render() {
        GLContext.createFromCurrent();

        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        glColor3f(0.5f, 0.5f, 1.0f);

        glBegin(GL_QUADS);
        glVertex2f(100, 100);
        glVertex2f(100 + 200, 100);
        glVertex2f(100 + 200, 100 + 200);
        glVertex2f(100, 100 + 200);
        glEnd();
    }
}

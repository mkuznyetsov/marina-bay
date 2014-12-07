package com.ztaticvienn.marina.objects.ammo;

import com.ztaticvienn.marina.objects.GameObject;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

/**
 * Created by Mike on 07.12.2014.
 */
public class Round50Cal extends GameObject{

    private int speed = 4;

    public Round50Cal(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        y=y+speed;
    }

    @Override
    public void draw() {
        glColor3f(1.0f, 0.0f, 0.0f);

        glBegin(GL_QUADS);
        glVertex2f(x, y);
        glVertex2f(x + 2, y);
        glVertex2f(x + 2, y + 2);
        glVertex2f(x, y + 2);
        glEnd();
    }
}

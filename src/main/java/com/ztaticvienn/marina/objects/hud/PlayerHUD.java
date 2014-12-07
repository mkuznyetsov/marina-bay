package com.ztaticvienn.marina.objects.hud;

import com.ztaticvienn.marina.objects.GameObject;
import org.lwjgl.opengl.GL15;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

/**
 * Created by Mike on 07.12.2014.
 */
public class PlayerHUD extends GameObject{

    public PlayerHUD(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {
        glColor3f(0.5f, 1.0f, 0.0f);

        glBegin(GL_QUADS);
        glEnd();
    }
}

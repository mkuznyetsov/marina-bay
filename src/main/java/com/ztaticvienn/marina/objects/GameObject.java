package com.ztaticvienn.marina.objects;

import com.ztaticvienn.marina.logic.collision.CollisionHandler;
import com.ztaticvienn.marina.main.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Mike on 06.12.2014.
 */
public abstract class GameObject {
    protected int x;
    protected int y;

    public abstract void update();

    public abstract void draw();

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

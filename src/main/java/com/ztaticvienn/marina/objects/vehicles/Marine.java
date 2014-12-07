package com.ztaticvienn.marina.objects.vehicles;

import com.ztaticvienn.marina.objects.GameObject;
import com.ztaticvienn.marina.objects.weapons.MachineGun;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by Mike on 06.12.2014.
 */
public class Marine extends GameObject {

    private MachineGun machineGun = new MachineGun(x, y, this);

    private int speed = 1;

    private boolean firing;
    private boolean reloading;
    private boolean movingForward;
    private boolean movingBackward;

    public Marine(int x, int y) {
        super(x, y);
    }

    public MachineGun getMachineGun() {
        return machineGun;
    }

    public boolean isMovingForward() {
        return movingForward;
    }

    public void setMovingForward(boolean movingForward) {
        this.movingForward = movingForward;
    }

    public boolean isMovingBackward() {
        return movingBackward;
    }

    public void setMovingBackward(boolean movingBackward) {
        this.movingBackward = movingBackward;
    }

    public boolean isFiring() {
        return firing;
    }

    public void setFiring(boolean firing) {
        this.firing = firing;
    }

    public boolean isReloading() {
        return reloading;
    }

    public void setReloading(boolean reloading) {
        this.reloading = reloading;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void update() {
        if (isMovingForward()) {
            y = y + speed;
        }
        if (isMovingBackward()) {
            y = y - speed;
        }
        if (isFiring() && !isReloading()) {
            machineGun.fire();
        }
        if (isReloading()) {
            machineGun.reload();
        }
    }

    @Override
    public void draw() {
        glColor3f(0.5f, 1.0f, 0.0f);

        glBegin(GL_QUADS);
        glVertex2f(x, y);
        glVertex2f(x + 25, y);
        glVertex2f(x + 25, y + 25);
        glVertex2f(x, y + 25);
        glEnd();
    }
}

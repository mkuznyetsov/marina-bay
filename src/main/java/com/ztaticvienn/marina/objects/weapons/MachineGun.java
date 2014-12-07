package com.ztaticvienn.marina.objects.weapons;

import com.ztaticvienn.marina.main.Game;
import com.ztaticvienn.marina.objects.GameObject;
import com.ztaticvienn.marina.objects.ammo.Round50Cal;
import com.ztaticvienn.marina.objects.vehicles.Marine;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by Mike on 06.12.2014.
 */
public class MachineGun extends GameObject {

    private Marine owner;

    private int ammo = 100;
    private int cartridges = 2;
    private long reloadTime = 500_000_000L; //Nanoseconds. Need to invert this value
    private long fireRate = 90_000_000L;   //
    private long reloadStarted = System.nanoTime();
    private long lastFire = System.nanoTime();


    public MachineGun(int x, int y, Marine owner) {
        super(x, y);
        this.owner = owner;
        Game.addObject(this);
    }

    public void fire() {
        if (ammo > 0) {
            if (System.nanoTime() - lastFire < fireRate) {
                return;
            }
            ammo--;
            lastFire = System.nanoTime();
            Game.addObject(new Round50Cal(x + 2, y + 2));
            System.out.printf("Ammo: %d | %d\n", ammo, cartridges);
        }
    }

    public int getAmmo() {
        return ammo;
    }

    public int getCartridges() {
        return cartridges;
    }



    public void reload() {
        if (cartridges > 0) {
            cartridges--;
            System.out.println("Loaded!");
            ammo = 100;
            owner.setReloading(false);
            System.out.printf("Ammo: %d | %d\n", ammo, cartridges);
        }
    }

    @Override
    public void update() {
        x = owner.getX() + 5;
        y = owner.getY() + 5;
    }

    @Override
    public void draw() {
        glColor3f(0.0f, 0.2f, 0.0f);

        glBegin(GL_QUADS);
        glVertex2f(x, y);
        glVertex2f(x + 10, y);
        glVertex2f(x + 10, y + 10);
        glVertex2f(x, y + 10);
        glEnd();
    }
}

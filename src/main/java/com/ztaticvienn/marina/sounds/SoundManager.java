package com.ztaticvienn.marina.sounds;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;

/**
 * Created by Mike on 07.12.2014.
 */
public class SoundManager {
    private static Audio MACHINEGUN_FIRE;

    public static interface Sounds {
        int MACHINEGUN_FIRE = 1;
    }

    static {
        try {
            MACHINEGUN_FIRE = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res\\sound\\50Cal.wav"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void playSound(int sound) {
        switch (sound) {
            case 1 : MACHINEGUN_FIRE.playAsSoundEffect(1.0f, 1.0f, false);
        }
    }
}

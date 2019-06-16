package game.Player;

import game.GameObject;
import game.scene.LoadObjects;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

public class PlayerEmptyBullet extends GameObject {
    Clip sound;
    public PlayerEmptyBullet(){
        sound= LoadObjects.playeremptybullet;
        AudioUtils.replay ( sound );
    }

    @Override
    public void reset() {
        super.reset ();
        AudioUtils.replay ( sound );
    }
}

package game.scene;

import game.Background;
import game.GameObject;
import game.Player.Player;
import game.Settings;
import game.enemys.Enemy;
import game.enemys.EnemySummoner;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SceneStage1 extends Scene{

    @Override
    public void init() {

        GameObject.recycle ( Background.class );
        GameObject.recycle ( EnemySummoner.class );
        GameObject.recycle ( Player.class );
        GameObject.recycle ( Menu.class );


    }

    @Override
    public void clear()  {
        Settings.mang=3;
        if(Settings.score>=Settings.HighScore){
        Settings.HighScore=Settings.score;}
        Settings.numbershoot=3;
        Settings.score=0;

        GameObject.clearAll ();
    }
}

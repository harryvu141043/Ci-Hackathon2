package game;

import com.sun.source.tree.Scope;

import java.awt.*;
import java.io.IOException;

public class Settings {
    public static final int GAME_WIDTH=1920;
    public static final int GAME_HEIGHT=853;
    public static  int score=0;
    public static int  HighScore=0;
    public static int mang=4;
    public static int fake= mang-1;

    public static final int BACKGROUND_WIDTH=1280;
    public static final int BACKGROUND_HEIGHT=853;
    //player
    public static final int PLAYER_WIDTH=30;
    public static final int PLAYER_HEIGHT=30;
    public static Font Bigsize=new Font ( "Verdana",30,30 );
    public static int numbershoot = 3;
}

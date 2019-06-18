package game.scene;

import game.GameObject;
import game.Player.Player;
import game.Player.PlayerBullet;
import game.Renderer.Renderer;
import game.Settings;
import game.enemys.Enemy;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Menu extends GameObject {
    BufferedImage image;

    public Menu() {
        GameObject.toplayers.add ( this );
        image=LoadObjects.menu;
    }

    @Override
    public void render(Graphics g) {

        this.drawBackground ( g );
        this.drawInfo ( g );

    }


    private void drawInfo(Graphics g) {

        String mess = Settings.numbershoot + "";
        String score=Settings.score+"";
        g.setColor ( Color.BLACK );
        g.setFont ( Settings.Bigsize );
        g.drawString ( "Số lượng đạn:",Settings.BACKGROUND_WIDTH+50,100 );

        g.drawString (1<=Settings.numbershoot?mess:"hết đạn", Settings.BACKGROUND_WIDTH + 290, 100 );
        g.drawString ( "Điểm :"+score,Settings.BACKGROUND_WIDTH+50, 200);
        g.drawString ( "Kỉ lục:"+   Settings.HighScore,Settings.BACKGROUND_WIDTH+50, 300 );
        g.drawImage ( image,Settings.BACKGROUND_WIDTH+50,375,null );
        g.setColor ( Settings.mang>=4?Color.GREEN:2<=Settings.mang?Color.YELLOW:Color.RED );
        g.drawString ( ":"+Settings.mang+"",Settings.BACKGROUND_WIDTH+100, 400 );
    }

    private void drawBackground(Graphics g) {
        g.setColor ( new Color ( 196, 153, 153 ) );
        g.fillRect ( Settings.BACKGROUND_WIDTH, 0, Settings.GAME_WIDTH - Settings.BACKGROUND_WIDTH, Settings.BACKGROUND_HEIGHT );

    }

}

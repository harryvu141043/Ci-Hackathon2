package game.scene;

import game.GameObject;
import game.Player.Player;
import game.Player.PlayerBullet;
import game.Settings;
import game.enemys.Enemy;

import java.awt.*;

public class Menu extends GameObject {


    public Menu() {
        GameObject.toplayers.add ( this );
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
        g.drawString ( Settings.mang+"",Settings.BACKGROUND_WIDTH+50, 400 );
    }

    private void drawBackground(Graphics g) {
        g.setColor ( new Color ( 196, 153, 153 ) );
        g.fillRect ( Settings.BACKGROUND_WIDTH, 0, Settings.GAME_WIDTH - Settings.BACKGROUND_WIDTH, Settings.BACKGROUND_HEIGHT );

    }

}

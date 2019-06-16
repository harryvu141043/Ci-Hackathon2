package game.scene;

import game.GameObject;
import game.KeyEventPress;
import game.Renderer.Renderer;

public class BackgroundWelcome extends GameObject {
    public BackgroundWelcome(){
        GameObject.toplayers.add ( this );
        renderer=new Renderer ( "images/welcome.png" );
        position.set ( 1920/2,853/2 );

    }
    @Override
    public void run() {
        if(KeyEventPress.isAnyKeyPress){
            SceneManager.signNewScene ( new SceneLoading () );
        }
    }
}

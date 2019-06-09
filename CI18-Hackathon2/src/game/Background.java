package game;

import game.Renderer.Renderer;

public class Background extends GameObject {
    public Background(){
        renderer=new Renderer ( "images/Backgrounds/background-doc-dao-va-dep_110341729.png" );
        position.set ( 0,0 );
    }
}

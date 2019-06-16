package game.scene;

import game.GameObject;

public class SceneOver extends Scene {
    @Override
    public void init() {
        GameObject.recycle ( BackgroundOver.class );
    }

    @Override
    public void clear() {
        GameObject.clearAll ();

    }
}

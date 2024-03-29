package game;

import game.Renderer.Renderer;
import game.physics.BoxCollider;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class GameObject {
    public static ArrayList<GameObject> objects=new ArrayList<> ();
    public static ArrayList<GameObject>toplayers=new ArrayList<> (  );
    public static ArrayList<GameObject>midlayers=new ArrayList<> (  );
    public static ArrayList<GameObject>botlayers=new ArrayList<> (  );

    public static <E extends GameObject> E recycle(Class<E> cls){
        //1.tìm phần tử deactive>>reset>>trả về
        //2.ko thấy>>tạo mới>>trả về
        E object=findInactive ( cls );
        if(object!=null){
            object.reset ();
            return object;
        }
        try {
            object=cls.getConstructor (  ).newInstance (  );
            return object;
        }catch (Exception ex){
            ex.printStackTrace ();
            return null;
        }

//        return null;
    }


    public static <E extends GameObject> E findInactive(Class<E> cls) {
//        cls~player.class,...
//        E~player
        for (int i = 0; i < objects.size (); i++) {
            GameObject object = objects.get ( i );
            if (cls.isAssignableFrom ( object.getClass () )&& !object.active){
                return (E) object;
            }
        }

        return null;
    }
    public static <E extends GameObject> E findIntersects(Class<E>cls,BoxCollider hitBox){
        for (int i=0;i<objects.size ();i++){
            GameObject object=objects.get ( i );
            if(object.active &&cls.isAssignableFrom ( object.getClass () )
                    && object.hitBox!=null&&
                    object.hitBox.intersects ( hitBox )){
                return (E)object;
            }
        }
        return null;
    }
    public Vector2D position;
    public Renderer renderer;
    public boolean active;
    public BoxCollider hitBox;
    public Vector2D velocity;
    public Vector2D anchor;
    public GameObject(){
        objects.add ( this );

        position=new Vector2D (  );
        velocity=new Vector2D (  );
        anchor=new Vector2D (0.5,0.5  );
        active=true;
    }
    public void render(Graphics g){
        if(renderer!=null){
            renderer.render ( g,this );
        }
    }
    public static void renderall(Graphics g){
        for(int i=0;i<botlayers.size ();i++){
            GameObject object=botlayers.get ( i );
            if(object.active){
                object.render ( g );
            }
        }
        for(int i=0;i<midlayers.size ();i++){
            GameObject object=midlayers.get ( i );
            if(object.active){
                object.render ( g );
            }
        }
        for(int i=0;i<toplayers.size ();i++){
            GameObject object=toplayers.get ( i );
            if(object.active){
                object.render ( g );
            }
        }
    }

    public static void clearAll(){
        objects.clear ();
        toplayers.clear ();
        midlayers.clear ();
        botlayers.clear ();
    }
    public void run()  {
        position.add ( velocity );
    }
    public void deactive(){
        active=false;
    }
    public void reset(){
        active=true;
    }

}

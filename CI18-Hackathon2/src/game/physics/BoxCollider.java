package game.physics;

import game.GameObject;
import game.Vector2D;

public class BoxCollider {
    public int width;
    public int height;
    public Vector2D position,anchor;
    public BoxCollider(GameObject master,int width,int height){
        this.position=master.position;
        this.width=width;
        this.height=height;
        this.anchor=master.anchor;
    }
    public double top(){
        return position.y-anchor.x*height;
    }
    public double bot(){
        return this.top()+this.height;
    }
    public double left(){
        return position.x-anchor.x*width;
    }
    public double right(){
        return this.left ()+this.width;
    }
    public boolean intersects(BoxCollider other){
        return other.bot ()>=this.top() &&
                other.top ()<=this.bot () &&
                other.right ()>=this.left ()&&
                other.left ()<=this.right ();
    }
}

package game.Renderer;

import game.GameObject;
import tklibs.SpriteUtils;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
public class Renderer {
    public BufferedImage image;
    public ArrayList<BufferedImage> images;
    public int currentImageIndex;
    public int frameCount;
    public boolean isOnce;
    public Renderer(String url) {
        File source=new File ( url );
        if(source.exists () && source.isFile ()){
            image= SpriteUtils.loadImage (url);
        }
        if(source.exists () && source.isDirectory ()){
            images=SpriteUtils.loadImages ( url );
            currentImageIndex=0;
            frameCount=0;
        }
    }
    public Renderer(String url,boolean isOnce){
        this(url);
        this.isOnce=isOnce;

    }

    public void render(Graphics g, GameObject master){

        if(image!=null){
            drawImage(g,image,master);

       }
        if(images!=null){
            BufferedImage currentImage=images.get(currentImageIndex);
            drawImage(g,currentImage,master);
//            g.drawImage ( currentImage,(int)master.position.x,(int)master.position.y,null );
            frameCount++;
            if(frameCount>10){
                currentImageIndex++;
                if(currentImageIndex>=images.size()){
                    if(this.isOnce){
                        master.deactive ();
                    }
                    this.currentImageIndex=0;
                }
                frameCount=0;
            }
        }
    }

    private void drawImage(Graphics g, BufferedImage image,GameObject master) {
        g.drawImage ( image,(int)(master.position.x-master.anchor.x*image.getWidth ()),
                (int)(master.position.y-image.getHeight ()*master.anchor.y),
                null );



        if(master.hitBox!=null){
            g.setColor ( Color.GREEN );
            g.drawRect (
                    (int)master.hitBox.left (),
                    (int)master.hitBox.top (),
                    master.hitBox.width,
                    master.hitBox.height );
        }
    }
}

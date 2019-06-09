//package game;
//
//import game.background.Background;
//import game.player.Player;
//
//import java.awt.*;
//
//public class GamePanel extends Panel {
//
//    Background background;
//    Player player;
//
//    public GamePanel() {
//        background=new Background ();
//        player=new Player ();
//
//    }
//
//    @Override
//    public void paint(Graphics g) {
//        background.render ( g );
//        player.render ( g );
//    }
//
//    public void gameloop(){
//        long lastTime=System.currentTimeMillis ();
//        while (true){
//            long currentTime=System.currentTimeMillis ();
//            if(currentTime-lastTime>1000/80){
////                System.out.println (currentTime-lastTime);
//                this.runall ();
//                this.repaint ();
//                lastTime=currentTime;
//                this.requestFocus ();
//            }
//        }
//    }
//    public void runall(){
//        this.player.run ();
//        this.background.run ();
//    }
//
//}

//package game;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//
//public class Program {
//    public static void main(String[] args) {
//        JFrame window = new JFrame ();
//        GamePanel panel = new GamePanel ();
//        window.setSize ( 800,600 );
//        window.add ( panel );
//
//        window.setLocation ( 400, 400 );
//        window.setResizable ( false );
//        window.setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
//        window.setTitle ( "Protector" );
//
//
//        KeyAdapter keyHandler=new KeyAdapter () {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if(e.getKeyCode ()==KeyEvent.VK_W){
//                    KeyEventPress.isUpPress=true;
//                }
//                if(e.getKeyCode ()==KeyEvent.VK_A){
//                    KeyEventPress.isLeftPress=true;
//                }
//                if(e.getKeyCode ()==KeyEvent.VK_S){
//                    KeyEventPress.isDownPress=true;
//                }
//                if(e.getKeyCode ()==KeyEvent.VK_D){
//                    KeyEventPress.isRightPress=true;
//                }
//
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                if(e.getKeyCode ()==KeyEvent.VK_W){
//                    KeyEventPress.isUpPress=false;
//                }
//                if(e.getKeyCode ()==KeyEvent.VK_A){
//                    KeyEventPress.isLeftPress=false;
//                }
//                if(e.getKeyCode ()==KeyEvent.VK_S){
//                    KeyEventPress.isDownPress=false;
//                }
//                if(e.getKeyCode ()==KeyEvent.VK_D){
//                    KeyEventPress.isRightPress=false;
//                }
//
//            }
//
//        };
//        panel.addKeyListener ( keyHandler );
//        window.setVisible ( true );
//        panel.gameloop ();
//    }
//
//}

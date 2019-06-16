package game;

import game.Player.Player;
import game.enemys.EnemySummoner;
import game.scene.SceneManager;
import game.scene.SceneWelcome;


import javax.imageio.IIOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    static class Panel extends JPanel {
        static Menu menu=new Menu (  );
        public Panel() {

            this.config ();
            this.createObjects ();
            this.addListerners ();



        }

        private void addListerners() {
            KeyAdapter KeyHandler = new KeyAdapter () {
                @Override
                public void keyPressed(KeyEvent e) {
                    KeyEventPress.isAnyKeyPress=true;
                    if (e.getKeyCode () == KeyEvent.VK_SPACE) {
                        KeyEventPress.isFire=true;
                    }
                    if (e.getKeyCode () == KeyEvent.VK_UP) {
                        KeyEventPress.isUpPress = true;
                    }
                    if (e.getKeyCode () == KeyEvent.VK_LEFT) {
                        KeyEventPress.isLeftPress = true;
                    }
                    if (e.getKeyCode () == KeyEvent.VK_DOWN) {
                        KeyEventPress.isDownPress = true;
                    }
                    if (e.getKeyCode () == KeyEvent.VK_RIGHT) {
                        KeyEventPress.isRightPress = true;
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    KeyEventPress.isAnyKeyPress=false;
                    if (e.getKeyCode () == KeyEvent.VK_SPACE) {
                            KeyEventPress.isFire=false;
                    }
                    if (e.getKeyCode () == KeyEvent.VK_UP) {
                        KeyEventPress.isUpPress = false;
                    }
                    if (e.getKeyCode () == KeyEvent.VK_LEFT) {
                        KeyEventPress.isLeftPress = false;
                    }
                    if (e.getKeyCode () == KeyEvent.VK_DOWN) {
                        KeyEventPress.isDownPress = false;
                    }
                    if (e.getKeyCode () == KeyEvent.VK_RIGHT) {
                        KeyEventPress.isRightPress = false;
                    }
                }
            };
            this.addKeyListener ( KeyHandler );
        }

        public void createObjects() {
            SceneManager.signNewScene ( new SceneWelcome () );

        }
        private void config() {
            this.setPreferredSize ( new Dimension ( Settings.GAME_WIDTH, Settings.GAME_HEIGHT ) );
        }

        @Override
        public void paint(Graphics g) {
            GameObject.renderall ( g );


        }


        public void runAll() {
            for (int i = 0; i < GameObject.objects.size (); i++) {
                GameObject object = GameObject.objects.get ( i );
                if (object.active) {
                    object.run ();
                }

            }

            this.requestFocus ();
        }


    }

    static class Window extends JFrame {
        Panel panel;

        public Window() {
            super ( "Game" );
            this.config ();
            this.createPanel ();

//            this.setSize ( 800, 800 );
        }


        private void config() {
            this.setResizable ( false );
            this.setDefaultCloseOperation ( EXIT_ON_CLOSE );
        }

        private void createPanel() {
            panel = new Panel ();
            this.add ( panel );
            this.pack ();
        }

        public void gameLoop(){
            long lastTime = System.currentTimeMillis ();
            while (true) {
                long currentTime = System.currentTimeMillis ();
                if (currentTime - lastTime > 1000 / 60) {
                    panel.runAll ();
                    this.repaint ();
                    lastTime = currentTime;
                }
            }
        }


    }

    public static void main(String[] args) {

        Window window = new Window ();
        window.setVisible ( true );
        window.gameLoop ();


    }

}

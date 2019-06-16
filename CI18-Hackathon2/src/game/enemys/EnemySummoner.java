package game.enemys;

import game.GameObject;
import tklibs.Mathx;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class EnemySummoner extends GameObject {
    public EnemySummoner(){GameObject.midlayers.add ( this );}
    int count=0;

    @Override
    public void run() {
        super.run ();
        this.SummonEnemy();

    }

    private void SummonEnemy() {
        count++;
        if(count>2*80){
            int EnemyType=Mathx.random ( 2,2 );

            switch (EnemyType){
                case 1:{
                    EnemyD enemyD=GameObject.recycle ( EnemyD.class );

                    break;
                }
                case 2:{
                    EnemyX enemyX=GameObject.recycle ( EnemyX.class );

                    break;
                }
                case 3:{
                    EnemyV enemyV=GameObject.recycle ( EnemyV.class );

                    break;
                }
            }
            count=0;

        }
    }
}

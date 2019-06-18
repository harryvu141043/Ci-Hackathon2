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
        if(count>1.7*80){
            int EnemyType=Mathx.random ( 1,3 );
            int Typeof=Mathx.random ( 0,1 );

            switch (EnemyType){
                case 1:{
                    EnemyD enemyD=GameObject.recycle ( EnemyD.class );
                   if(Typeof==0){
                        enemyD.velocity.setAngle ( Math.toRadians (  90) );
                   }


                    break;
                }
                case 2:{
                    EnemyX enemyX=GameObject.recycle ( EnemyX.class );
                    if(Typeof==0){
                        enemyX.velocity.setAngle ( Math.toRadians (  90) );
                    }

                    break;
                }
                case 3:{
                    EnemyV enemyV=GameObject.recycle ( EnemyV.class );
                    if(Typeof==0){
                        enemyV.velocity.setAngle ( Math.toRadians (  90) );
                    }

                    break;
                }
            }
            count=0;

        }
    }
}

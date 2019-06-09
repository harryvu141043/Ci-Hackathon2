package game.enemys;

import game.GameObject;
import tklibs.Mathx;

public class EnemySummoner extends GameObject {
    public EnemySummoner(){}
    int count=0;

    @Override
    public void run() {
        super.run ();
        this.SummonEnemy();

    }

    private void SummonEnemy() {
        count++;
        if(count>80){
            int EnemyType=Mathx.random ( 1,2 );
            switch (EnemyType){
                case 1:{
                    EnemyD enemyD=GameObject.recycle ( EnemyD.class );

                    break;
                }
                case 2:{
                    EnemyX enemyX=GameObject.recycle ( EnemyX.class );

                    break;
                }
            }
            count=0;
        }
    }
}

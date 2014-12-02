package data;

import android.util.Pair;

import java.util.ArrayList;

/**
 * Created by ehrndal on 02/12/14.
 */
public class Round {

    private ArrayList<Unit> playerTroops;
    private ArrayList<Unit> enemyTroops;
    private Integer[] damageDone;
    private Integer[] unitsLost;
    private Integer[] damageTaken;

    public Round(ArrayList<Unit> player, ArrayList<Unit> enemy){
        playerTroops = player;
        enemyTroops = enemy;
        damageDone = new Integer[enemy.size()];
        damageTaken = new Integer[player.size()];
        unitsLost = new Integer[player.size()];
    }

    public void setDamageDone(int pos, int damage){
        damageDone[pos] = damage;
    }

    public void setDamageTaken(int pos, int damage){
        damageTaken[pos] = damage;
    }

    public void setUnitsLost(int pos, int unitsLost){
        this.unitsLost[pos] = unitsLost;
    }

    public Integer[] getDamageDone(){
        return damageDone;
    }

    public Integer[] getDamageTaken(){
        return damageTaken;
    }
}

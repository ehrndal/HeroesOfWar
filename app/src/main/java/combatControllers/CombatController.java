package combatControllers;

import android.util.Log;
import android.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.jar.Attributes;

import data.DataHandler;
import data.NoUnitInSlot;
import data.Round;
import data.StatisticsHandler;
import data.Unit;

/**
 * Created by ehrndal on 01/12/14.
 */
public class CombatController {

    private ArrayList<Unit> enemyUnits;
    private ArrayList<Unit> playerUnits;
    private ArrayList<Pair<String, Integer>> combatOrder;
    private DataHandler dH = new DataHandler();
    private CombatGenerator cG = CombatGenerator.getInstance();
    private StatisticsHandler sH = StatisticsHandler.getInstance();
    private Random rand;

    public CombatController(Unit[] playerUnits, Unit[] enemyUnits){
        this.enemyUnits = filterUnits(enemyUnits);
        this.playerUnits = filterUnits(playerUnits);
        combatOrder = new ArrayList<Pair<String, Integer>>();
        generateOrder();
        dH.setEnemyUnits(this.enemyUnits);
    }

    private ArrayList<Unit> filterUnits(Unit[] units){
        ArrayList<Unit> u = new ArrayList<Unit>();
        for(int i = 0; i<units.length; i++){
            if(!units[i].getClass().equals(NoUnitInSlot.class))
                u.add(units[i]);
        }
        return u;
    }

    public Round playRound(){
        Round round = new Round(playerUnits, enemyUnits);
        Unit att;
        Pair<Unit, Integer> def;
        for(int i = 0; i< combatOrder.size(); i++){
            if(gameOver(enemyUnits) || gameOver(playerUnits)) {
                break;
            }else {
                if (combatOrder.get(i).first.equals("p")) {
                    att = playerUnits.get(combatOrder.get(i).second);
                    def = getDefUnit(enemyUnits);
                    Pair<Integer, Integer> info = cG.generateAttack(att, def.first);
                    round.setDamageDone(def.second, info.first);
                    enemyUnits.set(def.second, def.first);
                } else {
                    att = enemyUnits.get(combatOrder.get(i).second);
                    def = getDefUnit(playerUnits);
                    Pair<Integer,Integer> info = cG.generateAttack(att, def.first);
                    round.setDamageTaken(def.second,info.first);
                    round.setUnitsLost(def.second, info.second);
                    playerUnits.set(def.second, def.first);
                }
            }
        }
        sH.addRound(round);
        return round;
    }

    public void generateOrder(){
        Set<Integer> addedEnemyUnits = new HashSet<Integer>();
        Set<Integer> addedPlayerUnits = new HashSet<Integer>();
        for(int i = 0; i < (playerUnits.size() + enemyUnits.size()); i ++){
            Pair<Integer, Integer> enemyUnit = getHighestSpeed(enemyUnits, addedEnemyUnits);
            Pair<Integer, Integer> playerUnit = getHighestSpeed(playerUnits, addedPlayerUnits);
            if(enemyUnit.first > playerUnit.first){
                combatOrder.add(new Pair("e", enemyUnit.second));
                addedEnemyUnits.add(enemyUnit.second);
            }else{
                combatOrder.add(new Pair("p", playerUnit.second));
                addedPlayerUnits.add(playerUnit.second);
            }
        }
    }

    private Pair<Integer,Integer> getHighestSpeed(ArrayList<Unit> units, Set<Integer> added){
        int speed = 0;
        int pos = 0;
        for(int i = 0; i < units.size(); i++){
            if(units.get(i).getSpeed() > speed && added.contains(i) == false) {
                speed = units.get(i).getSpeed();
                pos = i;
            }
        }
        return new Pair(speed,pos);
    }

    private Pair<Unit,Integer> getDefUnit(ArrayList<Unit> units){
        while(true){
            rand = new Random();
            int i = rand.nextInt(units.size());
            if(units.get(i).Count() > 0){
                return new Pair(units.get(i),i);
            }
        }
    }

    private boolean gameOver(ArrayList<Unit> units){
        for(int i = 0; i < units.size(); i++){
            if(units.get(i).Count()>0)
                return false;
        }
        return true;
    }
}

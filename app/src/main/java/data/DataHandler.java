package data;

import java.util.ArrayList;

/**
 * Created by ehrndal on 28/11/14.
 */
public class DataHandler {

    private static DataHandler instance = null;
    private int gold = 30000;
    private Unit[] units;
    private Unit[] enemyUnits;
    private int armySize = 6;

    public DataHandler(){
        initEnemyUnits();
        units = new Unit[6];
        for(int i = 0; i<units.length;i++){
            units[i] = new NoUnitInSlot();
        }
    }

    public Unit[] getEnemyUnits(){
        return enemyUnits;
    }

    public void setEnemyUnits(ArrayList<Unit> units){
        enemyUnits[0] = units.get(0);
        enemyUnits[1] = units.get(1);
        enemyUnits[2] = units.get(2);
        enemyUnits[3] = units.get(3);
        enemyUnits[4] = units.get(4);
        enemyUnits[5] = units.get(5);
    }

    public Unit[] getUnits(){
        return units;
    }

    public void updateUnits(Unit unit, int i) {
        for (int j = 0; j < units.length; j++) {
            if (units[j].getClass().equals(NoUnitInSlot.class)) {
                units[j] = unit;
                units[j].updateUnit(i);
                gold -= i*unit.getPrice();
                break;
            }else if(units[j].getClass().equals(unit.getClass())){
                units[j].updateUnit(i);
                gold -= i*unit.getPrice();
                break;
            }
        }
    }

    public static DataHandler getInstance(){
        if(instance == null) {
            instance = new DataHandler();
        }
        return instance;
    }

    public int getGold(){
        return gold;
    }

    public Unit[] getAllUnits(){
        Unit[] u = new Unit[6];
        u[0] = new Orc();
        u[1] = new Barbarian();
        u[2] = new Brute();
        u[3] = new Shadowblade();
        u[4] = new Wizard();
        u[5] = new Rogue();
        return u;
    }

    private void initEnemyUnits(){
            enemyUnits = new Unit[6];
            Orc o = new Orc();
            o.updateUnit(120);
            enemyUnits[0] = o;
            Orc o2 = new Orc();
            o2.updateUnit(55);
            enemyUnits[1] = o2;
            Brute b = new Brute();
            b.updateUnit(15);
            enemyUnits[2] = b;
            Shadowblade s = new Shadowblade();
            s.updateUnit(3);
            enemyUnits[3] = s;
            Wizard w = new Wizard();
            w.updateUnit(9);
            enemyUnits[4] = w;
            Barbarian barb = new Barbarian();
            barb.updateUnit(22);
            enemyUnits[5] = barb;
    }
}

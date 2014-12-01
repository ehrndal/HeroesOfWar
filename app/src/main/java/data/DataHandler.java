package data;

/**
 * Created by ehrndal on 28/11/14.
 */
public class DataHandler {

    private static DataHandler instance = null;
    private int gold = 10000;
    private Unit[] units;
    private int armySize = 6;

    public DataHandler(){
        units = new Unit[6];
        for(int i = 0; i<units.length;i++){
            units[i] = new NoUnitInSlot();
        }
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
}

package data;

import android.util.Pair;

import com.chalmers.ehrndal.heroesofwar.R;

/**
 * Created by ehrndal on 28/11/14.
 */
public class Rogue implements Unit {
    private int iconId = R.drawable.ic_orc_rogue;
    private int iconIdNone = R.drawable.ic_orc_rogue_none;
    private int nrOfUnits = 0;
    private static Pair<Integer,Integer> attack = new Pair(40,60);
    private static int health = 150;
    private static int defense = 16;
    private int remainingHealth = 0;
    private static int speed = 7;
    private static int movement = 6;
    private static boolean isRanged = false;
    private static int price = 2600;

    @Override
    public int Count() {
        return nrOfUnits;
    }

    @Override
    public int getIconId() {
        return iconId;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public Pair<Integer, Integer> getAttack() {
        return attack;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getMovement() {
        return movement;
    }

    @Override
    public boolean isRanged() {
        return isRanged;
    }

    @Override
    public String getDisplayNr() {
        return Integer.toString(Count());
    }

    @Override
    public boolean updateUnit(int i) {
        if(nrOfUnits + i < 0){
            nrOfUnits = 0;
            return false;
        }else{
            nrOfUnits += i;
            return true;
        }
    }

    public String[] getStats(){
        String[] s = new String[6];
        s[0] = Integer.toString(attack.first)+ "-" + Integer.toString(attack.second);
        s[1] = Integer.toString(health);
        s[2] = Integer.toString(defense);
        s[3] = String.valueOf(isRanged);
        s[4] = Integer.toString(movement);
        s[5] = Integer.toString(speed);
        return s;
    }

    @Override
    public String getName() {
        return "Rogue";
    }

    @Override
    public int getRemainingHealth() {
        return remainingHealth;
    }

    @Override
    public void setRemainingHealth(int i) {
        remainingHealth = i;
    }
}

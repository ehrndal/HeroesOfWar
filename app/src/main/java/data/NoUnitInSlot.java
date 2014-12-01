package data;

import android.util.Pair;

/**
 * Created by ehrndal on 28/11/14.
 */
public class NoUnitInSlot implements Unit {


    @Override
    public int Count() {
        return 0;
    }

    @Override
    public int getIconId() {
        return 0;
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public Pair<Integer, Integer> getAttack() {
        return null;
    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public int getDefense() {
        return 0;
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public int getMovement() {
        return 0;
    }

    @Override
    public boolean updateUnit(int i) {
        return false;
    }

    @Override
    public boolean isRanged() {
        return false;
    }

    @Override
    public String getDisplayNr() {
        return "";
    }

    public String[] getStats(){
        String[] s = new String[6];
        s[0] = "";
        s[1] = "";
        s[2] = "";
        s[3] = "";
        s[4] = "";
        s[5] = "";
        return s;
    }

    @Override
    public String getName() {
        return null;
    }


    @Override
    public int getRemainingHealth() {
        return 0;
    }

    @Override
    public void setRemainingHealth(int i) {
        // do nothing
    }
}

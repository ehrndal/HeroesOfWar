package data;

import android.util.Pair;

/**
 * Created by ehrndal on 28/11/14.
 */
public interface Unit {
    public int Count();
    public int getIconId();
    public int getPrice();
    public Pair<Integer,Integer> getAttack();
    public int getHealth();
    public int getDefense();
    public int getSpeed();
    public int getMovement();
    public boolean updateUnit(int i);
    public boolean isRanged();
    public String getDisplayNr();
    public String[] getStats();
    public String getName();
}

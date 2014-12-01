package combatControllers;

import android.util.Log;
import android.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import data.Role;
import data.Unit;

/**
 * Created by ehrndal on 01/12/14.
 */
public class CombatGenerator {

    private static CombatGenerator instance = null;
    private Random rand;

    public CombatGenerator(){
        rand = new Random();

    }

    public void generateAttack(Unit attacker, Unit defender){
        int damage = getBaseDamage(attacker.getAttack());
        damage*=attacker.Count();
        calcLosses(defender, damage);
    }

    public static CombatGenerator getInstance(){

        if(instance == null){
            instance = new CombatGenerator();
        }
        return instance;
    }

    private int getBaseDamage(Pair<Integer, Integer> dmg){
        int low = dmg.first;
        int high = dmg.second;
        return rand.nextInt(high - low) + low;
    }

    private Unit calcLosses(Unit unit, int damage){
        int lossedUnits = 0;
        if(unit.getRemainingHealth() != 0){
            damage-= unit.getRemainingHealth();
            lossedUnits++;
        }
        double d = damage / unit.getHealth();
        int i = (int) d;
        lossedUnits += i;
        int remainingHealth = (int) (unit.getHealth() - (unit.getHealth()*(d-i)));

        unit.updateUnit(-lossedUnits);

        if(unit.Count() > 0)
            unit.setRemainingHealth(remainingHealth);
        else
            unit.setRemainingHealth(0);

        return unit;
    }
}

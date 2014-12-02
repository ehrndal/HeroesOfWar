package data;

import java.util.ArrayList;

/**
 * Created by ehrndal on 02/12/14.
 */
public class StatisticsHandler {

    private static StatisticsHandler instance = null;

    private ArrayList<Round> rounds;

    public StatisticsHandler(){
        rounds = new ArrayList<Round>();
    }

    public void addRound(Round round){
        rounds.add(round);
    }

    public ArrayList<Round> getRounds(){
        return rounds;
    }

    public Round getLastRound(){
        return rounds.get(rounds.size()-1);
    }

    public static StatisticsHandler getInstance(){
        if(instance == null) {
            instance = new StatisticsHandler();
        }
        return instance;
    }
}

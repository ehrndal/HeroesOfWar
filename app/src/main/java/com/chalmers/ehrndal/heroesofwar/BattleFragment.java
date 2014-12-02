package com.chalmers.ehrndal.heroesofwar;

import android.app.Fragment;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import adapters.EnemyGridAdapter;
import adapters.TroopGridAdapter;
import combatControllers.CombatController;
import data.Barbarian;
import data.Brute;
import data.DataHandler;
import data.Orc;
import data.Rogue;
import data.Round;
import data.Shadowblade;
import data.StatisticsHandler;
import data.Unit;
import data.Wizard;

/**
 * Created by ehrndal on 26/11/14.
 */
public class BattleFragment extends Fragment{

    private GridView playerGridView;
    private TroopGridAdapter adapter;
    private EnemyGridAdapter enemyAdapter;
    private GridView enemyGridView;
    private Button fightButton;
    private CombatController cC;
    private DataHandler dH = DataHandler.getInstance();
    private TextView resultDamage1;
    private TextView resultDamage2;
    private TextView resultDamage3;
    private TextView resultDamage4;
    private TextView resultDamage5;
    private TextView resultDamage6;
    private Round round;
    private StatisticsHandler sH = StatisticsHandler.getInstance();

    public BattleFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.battle_fragment,container,false);
        playerGridView = (GridView) v.findViewById(R.id.playerGridView);
        enemyGridView = (GridView) v.findViewById(R.id.enemyGridView);
        fightButton = (Button) v.findViewById(R.id.fightButton);
        resultDamage1 = (TextView) v.findViewById(R.id.enemyResult1);
        resultDamage2 = (TextView) v.findViewById(R.id.enemyResult2);
        resultDamage3 = (TextView) v.findViewById(R.id.enemyResult3);
        resultDamage4 = (TextView) v.findViewById(R.id.enemyResult4);
        resultDamage5 = (TextView) v.findViewById(R.id.enemyResult5);
        resultDamage6 = (TextView) v.findViewById(R.id.enemyResult6);

        cC = new CombatController(dH.getUnits(), dH.getEnemyUnits());

        fightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                round = cC.playRound();
                adapter.notifyDataSetChanged();
                updateDamageDoneText();
                enemyAdapter.notifyDataSetChanged();
            }
        });

        adapter = new TroopGridAdapter(getActivity(), R.layout.troop_item);
        enemyAdapter = new EnemyGridAdapter(getActivity(), R.layout.small_troop_item);
        playerGridView.setAdapter(adapter);
        enemyGridView.setAdapter(enemyAdapter);

        return v;
    }

    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static BattleFragment newInstance(int sectionNumber) {
        BattleFragment fragment = new BattleFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    private void updateDamageDoneText(){
        trySetText(resultDamage1, 0);
        trySetText(resultDamage2, 1);
        trySetText(resultDamage3, 2);
        trySetText(resultDamage4, 3);
        trySetText(resultDamage5, 4);
        trySetText(resultDamage6, 5);
    }

    private void trySetText(TextView view, int pos){
        if(round.getDamageDone()[pos] != null)
            view.setText(Integer.toString(round.getDamageDone()[pos]));
        else
            view.setText("");
    }
}

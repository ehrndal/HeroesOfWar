package com.chalmers.ehrndal.heroesofwar;

import android.app.Fragment;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import adapters.EnemyGridAdapter;
import adapters.TroopGridAdapter;
import combatControllers.CombatController;
import data.Barbarian;
import data.Brute;
import data.DataHandler;
import data.Orc;
import data.Rogue;
import data.Shadowblade;
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
    private DataHandler dH = new DataHandler().getInstance();

    public BattleFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.battle_fragment,container,false);
        playerGridView = (GridView) v.findViewById(R.id.playerGridView);
        enemyGridView = (GridView) v.findViewById(R.id.enemyGridView);
        fightButton = (Button) v.findViewById(R.id.fightButton);

        fightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cC = new CombatController(dH.getUnits(), dH.getEnemyUnits());
                adapter.notifyDataSetChanged();
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
}

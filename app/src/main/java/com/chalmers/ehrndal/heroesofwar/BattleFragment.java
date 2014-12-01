package com.chalmers.ehrndal.heroesofwar;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import adapters.EnemyGridAdapter;
import adapters.TroopGridAdapter;
import data.Barbarian;
import data.Brute;
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

    public BattleFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.battle_fragment,container,false);
        playerGridView = (GridView) v.findViewById(R.id.playerGridView);
        enemyGridView = (GridView) v.findViewById(R.id.enemyGridView);
        getEnemyTroops();
        adapter = new TroopGridAdapter(getActivity(), R.layout.troop_item);
        enemyAdapter = new EnemyGridAdapter(getActivity(), R.layout.small_troop_item, getEnemyTroops());
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

    public Unit[] getEnemyTroops(){
        Unit[] u = new Unit[6];
        Orc o = new Orc();
        o.updateUnit(120);
        u[0] = o;
        Orc o2 = new Orc();
        o2.updateUnit(55);
        u[1] = o2;
        Brute b = new Brute();
        b.updateUnit(15);
        u[2] = b;
        Shadowblade s = new Shadowblade();
        s.updateUnit(3);
        u[3] = s;
        Wizard w = new Wizard();
        w.updateUnit(9);
        u[4] = w;
        Barbarian barb = new Barbarian();
        barb.updateUnit(22);
        u[5] = barb;
        return u;
    }

}

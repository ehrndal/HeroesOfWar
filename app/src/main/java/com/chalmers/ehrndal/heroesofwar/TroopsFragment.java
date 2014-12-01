package com.chalmers.ehrndal.heroesofwar;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import data.DataHandler;
import data.NoUnitInSlot;
import adapters.TroopGridAdapter;
import adapters.UnitInfoAdapter;

/**
 * Created by ehrndal on 26/11/14.
 */
public class TroopsFragment extends Fragment {

    private GridView troopsView;
    private GridView unitInfoView;
    private TroopGridAdapter troopAdapter;
    private UnitInfoAdapter infoAdapter;
    private DataHandler dH;
    private TextView nameOfUnit;
    public TroopsFragment(){}

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.troops_fragment, container, false);
        dH = DataHandler.getInstance();
        troopsView = (GridView) v.findViewById(R.id.troopsView);
        unitInfoView = (GridView) v.findViewById(R.id.unitInfoView);
        troopAdapter = new TroopGridAdapter(getActivity(), R.layout.troop_item);
        infoAdapter = new UnitInfoAdapter(getActivity());
        troopsView.setAdapter(troopAdapter);
        unitInfoView.setAdapter(infoAdapter);
        nameOfUnit = (TextView) v.findViewById(R.id.nameOfUnit);


        troopsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (dH.getUnits()[position].getClass().equals(NoUnitInSlot.class)) {
                    Intent intent = new Intent(getActivity(), RecruitActivity.class);
                    startActivity(intent);
                } else {
                    nameOfUnit.setText(dH.getUnits()[position].getName());
                    infoAdapter.setData(dH.getUnits()[position]);
                    infoAdapter.notifyDataSetChanged();
                }
            }
        });

        return v;
    }

    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static TroopsFragment newInstance(int sectionNumber) {
        TroopsFragment fragment = new TroopsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        troopAdapter.notifyDataSetChanged();
        infoAdapter.notifyDataSetChanged();
    }
}

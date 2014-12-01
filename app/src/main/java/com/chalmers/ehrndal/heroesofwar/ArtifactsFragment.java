package com.chalmers.ehrndal.heroesofwar;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import org.w3c.dom.Text;

import adapters.ArtifactAdapter;
import data.NoUnitInSlot;

/**
 * Created by ehrndal on 26/11/14.
 */
public class ArtifactsFragment extends Fragment {

    private ArtifactAdapter adapter;
    private GridView artifactGridView;
    private TextView artifactName;
    private TextView artifactEffect;
    private View effectBkgrnd;
    private TextView effectLbl;
    private TextView artifactLbl;

    public ArtifactsFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.artifacts_fragment,container,false);
        artifactGridView = (GridView) v.findViewById(R.id.artifactGridView);
        artifactName = (TextView) v.findViewById(R.id.artifactName);
        artifactEffect = (TextView) v.findViewById(R.id.effectDesc);
        effectBkgrnd = (View) v.findViewById(R.id.effectBkgrnd);
        effectLbl = (TextView) v.findViewById(R.id.effectLbl);
        artifactLbl = (TextView) v.findViewById(R.id.artifactLbl);

        adapter = new ArtifactAdapter(getActivity());
        artifactGridView.setAdapter(adapter);

        artifactGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);
                artifactLbl.setText("Artifact: ");
                effectLbl.setText("Effect");
                effectBkgrnd.setVisibility(View.VISIBLE);
                artifactName.setText(name[position]);
                artifactEffect.setText(effect[position]);
            }
        });

        return v;
    }

    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ArtifactsFragment newInstance(int sectionNumber) {
        ArtifactsFragment fragment = new ArtifactsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    private String[] name = {"Sword of the slayer", "The defenders shield", "Bow of truesight"};
    private String[] effect = {"+2 to all units damage"
                                ,"+5 to all unites defense"
                                , "Ranged units do 20% more damage"};
}

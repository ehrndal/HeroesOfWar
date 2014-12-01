package com.chalmers.ehrndal.heroesofwar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import adapters.RecruitListAdapter;
import data.DataHandler;

/**
 * Created by ehrndal on 28/11/14.
 */
public class RecruitActivity extends Activity {
    private DataHandler dH;
    private RecruitListAdapter adapter;
    private ListView gW;
    private TextView gold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dH = DataHandler.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recruit_view);
        adapter = new RecruitListAdapter(this);
        gW = (ListView) findViewById(R.id.recruitGrid);
        gW.setAdapter(adapter);

        gold = (TextView) findViewById(R.id.goldAmountLbl);
        gold.setText(Integer.toString(dH.getGold()));

        final Intent intent = new Intent(this, RecruitDialog.class);

        gW.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent.putExtra("TypeId", position);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        gold.setText(Integer.toString(dH.getGold()));
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                finish();
            }
            if (resultCode == RESULT_CANCELED) {
                //Do nothing
            }
        }
    }//onActivityResult
}

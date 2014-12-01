package com.chalmers.ehrndal.heroesofwar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import data.DataHandler;
import data.Unit;

/**
 * Created by ehrndal on 30/11/14.
 */
public class RecruitDialog extends Activity {

    private SeekBar sb;
    private Button buyBtn;
    private Button cancelBtn;
    private TextView totalCost;
    private TextView nrUnits;
    private DataHandler dH;
    private Unit unit;
    private ImageView img;
    private int amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recruit_dialog);
        dH = DataHandler.getInstance();

        sb = (SeekBar) findViewById(R.id.seekBar);
        buyBtn = (Button) findViewById(R.id.bButton);
        cancelBtn = (Button) findViewById(R.id.cButton);
        totalCost = (TextView) findViewById(R.id.totalClost);
        nrUnits = (TextView) findViewById(R.id.numUnitsLbl);
        img = (ImageView) findViewById(R.id.iconUnit);

        unit = dH.getAllUnits()[getIntent().getIntExtra("TypeId", 0)];

        img.setImageResource(unit.getIconId());

        sb.setMax(dH.getGold()/unit.getPrice());

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                nrUnits.setText(Integer.toString(i));
                Log.d("Test", unit.toString());
                totalCost.setText(Integer.toString(unit.getPrice() * i));
                amount = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void buyTroops(View v){
        dH.updateUnits(unit,amount);
        Intent returnIntent = new Intent();
        setResult(RESULT_OK, returnIntent);
        finish();
    }

    public void cancel(View v){
        Intent returnIntent = new Intent();
        setResult(RESULT_CANCELED, returnIntent);
        finish();
    }
}

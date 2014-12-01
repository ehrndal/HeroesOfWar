package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import data.DataHandler;
import com.chalmers.ehrndal.heroesofwar.R;

/**
 * Created by ehrndal on 27/11/14.
 */
public class RecruitListAdapter extends BaseAdapter {
    private Context mContext;
    private DataHandler dH = DataHandler.getInstance();

    public RecruitListAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return 6;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recruit_list_item, parent, false);

        ImageView icon = (ImageView) view.findViewById(R.id.unitIcon);
        ImageView attack = (ImageView) view.findViewById(R.id.unitAttack);
        ImageView health = (ImageView) view.findViewById(R.id.unitHealth);
        ImageView defense = (ImageView) view.findViewById(R.id.unitDefense);
        ImageView isRanged = (ImageView) view.findViewById(R.id.unitIsRanged);
        ImageView movement = (ImageView) view.findViewById(R.id.unitMovement);
        ImageView speed = (ImageView) view.findViewById(R.id.unitSpeed);

        TextView cost = (TextView) view.findViewById(R.id.cost);
        TextView name = (TextView) view.findViewById(R.id.unitName);

        TextView att = (TextView) view.findViewById(R.id.unitAttackLbl);
        TextView hp = (TextView) view.findViewById(R.id.unitHealthLbl);
        TextView def = (TextView) view.findViewById(R.id.unitDefenseLbl);
        TextView range = (TextView) view.findViewById(R.id.unitRangedLbl);
        TextView move = (TextView) view.findViewById(R.id.unitMovementbl);
        TextView spd = (TextView) view.findViewById(R.id.unitSpeedLbl);

        icon.setImageResource(dH.getAllUnits()[position].getIconId());

        attack.setImageResource(R.drawable.ic_attack);
        health.setImageResource(R.drawable.ic_health);
        defense.setImageResource(R.drawable.ic_defense);
        isRanged.setImageResource(R.drawable.ic_ranged);
        movement.setImageResource(R.drawable.ic_movement);
        speed.setImageResource(R.drawable.ic_speed);

        cost.setText(Integer.toString(dH.getAllUnits()[position].getPrice()));
        name.setText(dH.getAllUnits()[position].getName());
        att.setText(dH.getAllUnits()[position].getStats()[0]);
        hp.setText(dH.getAllUnits()[position].getStats()[1]);
        def.setText(dH.getAllUnits()[position].getStats()[2]);
        range.setText(dH.getAllUnits()[position].getStats()[3]);
        move.setText(dH.getAllUnits()[position].getStats()[4]);
        spd.setText(dH.getAllUnits()[position].getStats()[5]);
        return view;
    }
}
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

import data.NoUnitInSlot;
import data.Unit;

/**
 * Created by ehrndal on 27/11/14.
 */
public class UnitInfoAdapter extends BaseAdapter {
    private Context mContext;
    private Unit data;
    private DataHandler dH = DataHandler.getInstance();

    public UnitInfoAdapter(Context c) {
        mContext = c;
        data = new NoUnitInSlot();
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.unit_info_item, parent, false);
        ImageView img = (ImageView) view.findViewById(R.id.image);
        TextView num = (TextView) view.findViewById(R.id.description);

        num.setText(data.getStats()[position]);

        if(data.getClass().equals(NoUnitInSlot.class)){
            img.setImageResource(0);
        }else{
            img.setImageResource(mThumbIds[position]);
        }

        return view;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.ic_attack, R.drawable.ic_health,
            R.drawable.ic_defense, R.drawable.ic_ranged,
            R.drawable.ic_movement, R.drawable.ic_speed
    };

    public void setData(Unit data){
        this.data = data;
    }
}
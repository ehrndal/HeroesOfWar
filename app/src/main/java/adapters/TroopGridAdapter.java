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
public class TroopGridAdapter extends BaseAdapter {
    private Context mContext;
    private DataHandler dH;

    public TroopGridAdapter(Context c) {
        mContext = c;
        dH = new DataHandler().getInstance();
    }

    public int getCount() {
        return dH.getUnits().length;
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
        View view = inflater.inflate(R.layout.troop_item, parent, false);

        ImageView img = (ImageView) view.findViewById(R.id.imageView);
        TextView num = (TextView) view.findViewById(R.id.numUnits);
        img.setImageResource(dH.getUnits()[position].getIconId());
        num.setText((dH.getUnits()[position].getDisplayNr()));
        return view;
    }
}
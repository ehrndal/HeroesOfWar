package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import data.DataHandler;
import data.Unit;

import com.chalmers.ehrndal.heroesofwar.R;

/**
 * Created by ehrndal on 27/11/14.
 */
public class EnemyGridAdapter extends BaseAdapter {
    private Context mContext;
    private DataHandler dH;
    private int layoutId;
    private Unit[] enemyUnits;

    public EnemyGridAdapter(Context c, int layoutId, Unit[] units) {
        mContext = c;
        this.layoutId = layoutId;
        enemyUnits = units;
        dH = new DataHandler().getInstance();
    }

    public int getCount() {
        return enemyUnits.length;
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
        View view = inflater.inflate(layoutId, parent, false);

        ImageView img = (ImageView) view.findViewById(R.id.imageView);
        TextView num = (TextView) view.findViewById(R.id.numUnits);
        img.setImageResource(enemyUnits[position].getIconId());
        num.setText(getText(position));
        return view;
    }

    private String getText(int pos){
        int i = enemyUnits[pos].Count();
        if(i < 5)
            return "Few";
        else if(i < 10)
            return "Several";
        else if(i < 25)
            return "Pack";
        else if(i < 50)
            return "Horde";
        else if(i < 100)
            return "Throng";
        else if(i < 200)
            return "Army";
        else return "Crazy";
    }
}
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
public class ArtifactAdapter extends BaseAdapter {
    private Context mContext;
    private DataHandler dH;

    public ArtifactAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return 3;
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
        View view = inflater.inflate(R.layout.artifact_item, parent, false);

        ImageView img = (ImageView) view.findViewById(R.id.artifactImage);
        img.setImageResource(artifacts[position]);

        return view;
    }

    private int[] artifacts = {R.drawable.artifact_sword,
                               R.drawable.artifact_shield,
                               R.drawable.artifact_bow};
}
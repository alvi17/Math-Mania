package alvi17.mathmania;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by PrzemekEnterprise on 04.01.2016.
 */
public class FragmentLevelPage4 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.level_page_four_fragment, container, false);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("LVL", getActivity().MODE_PRIVATE);
        TextView levelView;
        int levels = sharedPreferences.getInt("LEVEL_COUNT", 0);


        if(levels  >= 48) {
            for (int i = 49; i <= levels + 3; i++) {

                if (i > 60) {
                    break;
                }
                if (sharedPreferences.getBoolean("level" + i, false)) {
                    String id = "level" + i;
                    int resourceId = getResources().getIdentifier(id, "id", getActivity().getPackageName());
                    levelView = (TextView) v.findViewById(resourceId);
                    levelView.setBackgroundResource(R.drawable.levelcorrect_button);
                    levelView.setTextColor(ContextCompat.getColor(getActivity(), R.color.correct_text));
                    levelView.setEnabled(true);
                } else {
                    String id = "level" + i;
                    int resourceId = getResources().getIdentifier(id, "id", getActivity().getPackageName());
                    levelView = (TextView) v.findViewById(resourceId);
                    levelView.setBackgroundResource(R.drawable.level_button);
                    levelView.setTextColor(ContextCompat.getColor(getActivity(), R.color.normal_text));
                    levelView.setEnabled(true);
                }
            }
        }

        return v;
    }
}

package css.teo.fragmentsavestate.fragments;

/**
 * Created by css on 1/4/17.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import css.teo.fragmentsavestate.R;
import icepick.Icepick;
import icepick.State;

/**
 * Third Fragment
 */

public class ThirdFragment extends Fragment {

    public static final String TAG = "THIRD-FRAGMENT";

    @State boolean saved = false;

    public static ThirdFragment newInstance() {

        Bundle args = new Bundle();

        ThirdFragment fragment = new ThirdFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        ButterKnife.bind(this, view);

        if (saved) {
            Toast.makeText(getActivity(), "SAVED!!!!", Toast.LENGTH_SHORT)
                    .show();
        }

        saved = true;

        return view;
    }
}

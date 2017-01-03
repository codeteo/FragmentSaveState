package css.teo.fragmentsavestate.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import css.teo.fragmentsavestate.R;

/**
 * Second Fragment
 */

public class SecondFragment extends Fragment {

    public static final String TAG = "SECOND-FRAGMENT";

    private boolean saved = false;

    public static SecondFragment newInstance() {

        Bundle args = new Bundle();

        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("saved", saved);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        ButterKnife.bind(this, view);

        if (savedInstanceState != null) {
            saved = savedInstanceState.getBoolean("saved");
        }

        if (saved) {
            Toast.makeText(getActivity(), "SAVED!!!!", Toast.LENGTH_SHORT)
                    .show();
        }

        saved = true;

        return view;
    }
}

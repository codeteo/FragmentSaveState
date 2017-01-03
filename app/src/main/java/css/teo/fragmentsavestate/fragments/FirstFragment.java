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
 * First Fragment
 */

public class FirstFragment extends Fragment {

    public static final String TAG = "FIRST-FRAGMENT";

    private boolean saved = false;

    public static FirstFragment newInstance() {

        Bundle args = new Bundle();

        FirstFragment fragment = new FirstFragment();
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
        View view = inflater.inflate(R.layout.fragment_first, container, false);
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

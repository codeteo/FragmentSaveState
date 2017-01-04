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
import css.teo.fragmentsavestate.state.SecondFragmentState;

/**
 * Second Fragment
 */

public class SecondFragment extends Fragment {

    public static final String TAG = "SECOND-FRAGMENT";
    public static final String KEY_SAVED = "saved_state";

    private boolean saved = false;
    private SecondFragmentState state;

    public static SecondFragment newInstance() {
        Bundle args = new Bundle();

        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        state = SecondFragmentState.builder()
                .setSaved(true)
                .build();
        outState.putParcelable(KEY_SAVED, state);
        super.onSaveInstanceState(outState);
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
            state = savedInstanceState.getParcelable(KEY_SAVED);
            if (state != null) {
                saved = state.saved();
            }
        }

        if (saved) {
            Toast.makeText(getActivity(), "SAVED!!!!", Toast.LENGTH_SHORT)
                    .show();
        }

        saved = true;

        return view;
    }
}

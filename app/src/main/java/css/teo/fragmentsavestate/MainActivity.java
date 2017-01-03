package css.teo.fragmentsavestate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import css.teo.fragmentsavestate.fragments.FirstFragment;
import css.teo.fragmentsavestate.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MAIN-ACTIVITY";

    @BindView(R.id.fl_container) FrameLayout flContainer;
    @BindView(R.id.btn_frag_1) Button btnFragmentOne;
    @BindView(R.id.btn_frag_2) Button btnFragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnFragmentOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.fl_container, FirstFragment.newInstance())
                        .commit();
            }
        });

        btnFragmentTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.fl_container, SecondFragment.newInstance())
                        .commit();
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i(TAG, "onSaveInstanceState ");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState ");
    }
}

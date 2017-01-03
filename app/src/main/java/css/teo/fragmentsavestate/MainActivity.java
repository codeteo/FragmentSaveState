package css.teo.fragmentsavestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import css.teo.fragmentsavestate.fragments.FirstFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fl_container) FrameLayout flContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getFragmentManager().beginTransaction()
                .replace(R.id.fl_container, FirstFragment.newInstance())
                .addToBackStack(null)
                .commit();

    }

}

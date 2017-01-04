package css.teo.fragmentsavestate.state;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

/**
 * Stores state for {@link css.teo.fragmentsavestate.fragments.SecondFragment}
 */

@AutoValue
public abstract class SecondFragmentState implements Parcelable {

    public abstract boolean saved();

    public static Builder builder() {
        return new AutoValue_SecondFragmentState.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setSaved(boolean saved);

        public abstract SecondFragmentState build();
    }

}

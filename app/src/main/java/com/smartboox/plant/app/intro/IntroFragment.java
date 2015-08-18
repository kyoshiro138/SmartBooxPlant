package com.smartboox.plant.app.intro;

import android.view.View;

import com.smartboox.plant.R;
import com.smartboox.plant.app.login.LoginFragment;
import com.smartboox.plant.appimplementation.fragment.AppFragment;

public class IntroFragment extends AppFragment {
    private static final int INTRO_TIME_MILLISECONDS = 5*1000;
    @Override
    protected int getFragmentLayoutResource() {
        return R.layout.fragment_intro;
    }

    @Override
    protected void bindView(View rootView) {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onStart() {
        super.onStart();
        android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getNavigator() != null) {
                    getNavigator().navigateToFirstLevelFragment(new LoginFragment(), null);
                }
            }
        }, INTRO_TIME_MILLISECONDS);
    }
}

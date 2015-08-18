package com.smartboox.plant.appimplementation.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.smartboox.plant.appimplementation.activity.AppDrawerActivity;
import com.smartboox.plant.core.fragment.BaseFragment;
import com.smartboox.plant.core.navigator.Navigable;
import com.smartboox.plant.core.navigator.NavigationActivity;
import com.smartboox.plant.core.navigator.NavigationFragment;

public abstract class AppFragment extends BaseFragment
        implements NavigationFragment<AppDrawerActivity> {
    protected AppDrawerActivity mActivity;

    @Override
    public AppDrawerActivity getNavigationActivity() {
        return mActivity;
    }

    protected final Navigable getNavigator() {
        if (mActivity != null) {
            return mActivity.getNavigator();
        }
        return null;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(activity instanceof AppDrawerActivity) {
            mActivity = (AppDrawerActivity) activity;
        } else {
            throw new ClassCastException();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity.setDrawerEnabled(false);
    }
}

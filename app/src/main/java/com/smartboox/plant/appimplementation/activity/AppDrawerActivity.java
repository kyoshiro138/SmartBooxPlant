package com.smartboox.plant.appimplementation.activity;

import android.support.v4.app.Fragment;
import android.view.View;

import com.smartboox.plant.R;
import com.smartboox.plant.app.intro.IntroFragment;
import com.smartboox.plant.app.menu.MenuFragment;
import com.smartboox.plant.appimplementation.navigator.AppNavigator;
import com.smartboox.plant.core.activity.drawer.BaseDrawerActivity;
import com.smartboox.plant.core.activity.toolbar.ToolbarActivity;
import com.smartboox.plant.core.navigator.NavigationActivity;
import com.smartboox.plant.core.navigator.menu.MenuActivity;
import com.smartboox.plant.core.navigator.menu.OnMenuClosedListener;

public class AppDrawerActivity extends BaseDrawerActivity
        implements NavigationActivity<AppNavigator>,
        ToolbarActivity<AppToolbarViewHolder>,
        MenuActivity {
    private AppNavigator mNavigator;
    private OnMenuClosedListener mListener;
    private AppToolbarViewHolder mToolbar;

    @Override
    protected int getActivityLayoutResource() {
        return R.layout.activity_navigation_drawer;
    }

    @Override
    protected int getDrawerLayoutId() {
        return R.id.drawer_layout;
    }

    @Override
    protected int getContentFragmentId() {
        return R.id.layout_screen_content;
    }

    @Override
    protected int getMenuLayoutId() {
        return R.id.layout_screen_menu;
    }

    @Override
    protected Fragment getDrawerMenuFragment() {
        return new MenuFragment();
    }

    @Override
    public AppNavigator getNavigator() {
        if (mNavigator == null) {
            mNavigator = new AppNavigator(getContentFragmentId(), getSupportFragmentManager(), this);
        }
        return mNavigator;
    }

    @Override
    public AppToolbarViewHolder getToolbar() {
        if (mToolbar == null) {
            View toolbarView = findViewById(R.id.toolbar_layout);
            mToolbar = new AppToolbarViewHolder(this, toolbarView);
        }
        return mToolbar;
    }

    @Override
    public void closeMenu(OnMenuClosedListener listener) {
        mListener = listener;
        if (isDrawerOpened()) {
            closeDrawer();
        } else {
            if (mListener != null) {
                mListener.onClosed();
                mListener = null;
            }
        }
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        super.onDrawerClosed(drawerView);
        if (mListener != null) {
            mListener.onClosed();
            mListener = null;
        }
    }

    @Override
    protected void initContentFragment() {
        getNavigator().navigateToFirstLevelFragment(new IntroFragment(), null);
    }
}

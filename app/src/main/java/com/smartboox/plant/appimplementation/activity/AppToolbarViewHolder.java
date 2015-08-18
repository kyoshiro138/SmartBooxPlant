package com.smartboox.plant.appimplementation.activity;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.smartboox.plant.R;
import com.smartboox.plant.core.activity.toolbar.BaseToolbarViewHolder;

public class AppToolbarViewHolder extends BaseToolbarViewHolder {
    private TextView mTitleTextView;
    private ImageButton mMenuButton;

    public AppToolbarViewHolder(Context context, View toolbarView) {
        super(context, toolbarView);
    }

    @Override
    protected void initToolbarView(View toolbarView) {
        if (toolbarView != null) {
            mTitleTextView = (TextView) toolbarView.findViewById(R.id.toolbar_title_text);
            mMenuButton = (ImageButton) toolbarView.findViewById(R.id.toolbar_navigate_button);
        }
    }
}

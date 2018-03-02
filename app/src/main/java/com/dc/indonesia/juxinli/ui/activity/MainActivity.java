package com.dc.indonesia.juxinli.ui.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dc.indonesia.juxinli.R;
import com.dc.indonesia.juxinli.ui.fragment.RecommendListFragment;
import com.dc.indonesia.juxinli.ui.fragment.RecommendListRootFragment;
import com.dc.indonesia.sdk.base.activity.BaseCompatActivity;

public class MainActivity extends BaseCompatActivity {


    private RecommendListRootFragment rootFragment = null;

    @Override
    protected void initView(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            rootFragment = RecommendListRootFragment.newInstance();
            loadRootFragment(R.id.fl_container, rootFragment);
        } else {
            rootFragment = findFragment(RecommendListRootFragment.class);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}

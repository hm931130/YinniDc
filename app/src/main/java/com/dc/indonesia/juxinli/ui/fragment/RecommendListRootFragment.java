package com.dc.indonesia.juxinli.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.dc.indonesia.juxinli.R;
import com.dc.indonesia.sdk.base.fragment.BaseCompatFragment;

/**
 * Created by ThinkPad on 2018/3/2.
 */

public class RecommendListRootFragment extends BaseCompatFragment {
    public static RecommendListRootFragment newInstance() {
        Bundle args = new Bundle();
        RecommendListRootFragment fragment = new RecommendListRootFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_recommendlist_root;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        if (findChildFragment(RecommendListFragment.class) == null) {
            loadRootFragment(R.id.fl_container, RecommendListFragment.newInstance());
        }
    }
}

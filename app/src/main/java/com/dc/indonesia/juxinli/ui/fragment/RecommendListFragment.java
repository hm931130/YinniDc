package com.dc.indonesia.juxinli.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dc.indonesia.juxinli.R;
import com.dc.indonesia.sdk.base.BasePresenter;
import com.dc.indonesia.sdk.base.fragment.BaseRecycleFragment;

import butterknife.BindView;

/**
 * Created by ThinkPad on 2018/3/2.
 */

public class RecommendListFragment extends BaseRecycleFragment {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    public static RecommendListFragment newInstance() {
        Bundle args = new Bundle();
        RecommendListFragment fragment = new RecommendListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void onErrorViewClick(View view) {

    }

    @Override
    protected void showLoading() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_recommendlist;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }
}

package com.dc.indonesia.juxinli.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import com.dc.indonesia.juxinli.R;
import com.dc.indonesia.sdk.base.activity.BaseCompatActivity;
import com.dc.indonesia.sdk.help.RxHelper;
import com.dc.indonesia.sdk.utils.ToastUtils;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by ThinkPad on 2018/3/2.
 */

public class FlashActivity extends BaseCompatActivity {
    private static final String TAG = "RxPermission";
    private boolean mIsCancle;
    private int mTime = 3;

    @Override
    protected void initView(Bundle savedInstanceState) {
        //注：魅族pro6s-7.0-flyme6权限没有像类似6.0以上手机一样正常的提示dialog获取运行时权限，而是直接默认给了权限
        requestPermissions();
    }

    private void requestPermissions() {
        RxPermissions rxPermission = new RxPermissions(FlashActivity.this);
        //请求权限全部结果
        rxPermission.request(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        ).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean granted) throws Exception {
                if (!granted) {
                    ToastUtils.showToast("App未能获取全部需要的相关权限，部分功能可能不能正常使用.");
                }
                //不管是否获取全部权限，进入主页面
                initCountDown();
            }
        });
    }

    private void initCountDown() {
        Observable.interval(1, TimeUnit.SECONDS)
                .take(3)//计时次数
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return mTime - aLong;// 3-0 3-2 3-1
                    }
                })
                .compose(RxHelper.<Long>rxSchedulerHelper())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Long value) {
                        //                        Logger.e("value = " + value);
//                        tvCountDown.setText(String.valueOf(value));
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        if (!mIsCancle) {
                            startActivity(new Intent(FlashActivity.this, MainActivity.class));
                            finish();
                        }
                    }
                });
    }

    @Override
    public void onBackPressedSupport() {
        mIsCancle = true;
        setIsTransAnim(false);
        finish();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_flash;
    }
}

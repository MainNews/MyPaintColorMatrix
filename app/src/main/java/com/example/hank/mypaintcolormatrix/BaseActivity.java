package com.example.hank.mypaintcolormatrix;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by Jun on 2017/7/24.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        initView();
        initData();
        initListener();
    }

    protected abstract int getLayoutResID();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void initListener();

}

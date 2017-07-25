package com.example.hank.mypaintcolormatrix.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.example.hank.mypaintcolormatrix.BaseActivity;
import com.example.hank.mypaintcolormatrix.R;
import com.example.hank.mypaintcolormatrix.view.PaintColorMatrixInitView;

/**
 * Created by Jun on 2017/7/24.
 * 示例1 :
 *      使用ColorMatrix类生成色彩矩阵，单个颜色的蓝色通道输出
 */

public class PaintColorMatrixInitActivity extends BaseActivity {
    @Override
    protected int getLayoutResID() {
        return R.layout.hanker_paint_color_matrix_init_layout;
    }

    @Override
    protected void initView() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.hanker_paint_color_matrix_init_fl);
        frameLayout.addView(new PaintColorMatrixInitView(this));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onClick(View v) {

    }
}

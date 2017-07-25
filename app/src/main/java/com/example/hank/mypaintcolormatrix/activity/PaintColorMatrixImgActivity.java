package com.example.hank.mypaintcolormatrix.activity;

import android.view.View;
import android.widget.FrameLayout;

import com.example.hank.mypaintcolormatrix.BaseActivity;
import com.example.hank.mypaintcolormatrix.R;
import com.example.hank.mypaintcolormatrix.view.PaintColorMatrixImgView;

/**
 * Created by Jun on 2017/7/24.
 * 示例1 :
 *      使用ColorMatrix类生成色彩矩阵，对图片多颜色的蓝色通道输出
 */

public class PaintColorMatrixImgActivity extends BaseActivity {
    @Override
    protected int getLayoutResID() {
        return R.layout.hanker_paint_color_matrix_init_layout;
    }

    @Override
    protected void initView() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.hanker_paint_color_matrix_init_fl);
        frameLayout.addView(new PaintColorMatrixImgView(this));
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

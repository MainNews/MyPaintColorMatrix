package com.example.hank.mypaintcolormatrix;

import android.content.Intent;
import android.view.View;

import com.example.hank.mypaintcolormatrix.activity.PaintColorMatrixImgActivity;
import com.example.hank.mypaintcolormatrix.activity.PaintColorMatrixInitActivity;
import com.example.hank.mypaintcolormatrix.activity.PaintColorMatrixSetSaturationActivity;


/**
 * 自定义控件三部曲之绘图篇（八） ——Paint之ColorMatrix与滤镜效果
 */
public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        findViewById(R.id.paint_color_matrix_init).setOnClickListener(this);
        findViewById(R.id.paint_color_matrix_img).setOnClickListener(this);
        findViewById(R.id.paint_color_matrix_set_saturation).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*
                使用ColorMatrix类生成色彩矩阵，单个颜色的蓝色通道
             */
            case R.id.paint_color_matrix_init:
                Intent startInitActivity = new Intent(this, PaintColorMatrixInitActivity.class);
                startActivity(startInitActivity);
                break;
            case R.id.paint_color_matrix_img:
                /*
                使用ColorMatrix类生成色彩矩阵，对图片进行蓝色通道的输出
             */
                Intent startImgActivity = new Intent(this, PaintColorMatrixImgActivity.class);
                startActivity(startImgActivity);
                break;
            case R.id.paint_color_matrix_set_saturation:
                 /*
                    设置图片的饱和度
                 */
                Intent startSaturationActivity = new Intent(this, PaintColorMatrixSetSaturationActivity.class);
                startActivity(startSaturationActivity);
                break;
        }

    }
}

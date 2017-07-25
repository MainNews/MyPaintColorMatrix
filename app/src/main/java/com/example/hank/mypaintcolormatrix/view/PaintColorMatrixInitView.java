package com.example.hank.mypaintcolormatrix.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Jun on 2017/7/24.
 * 示例1 :
 * 使用ColorMatrix类生成色彩矩阵，单个颜色的蓝色通道
 */

public class PaintColorMatrixInitView extends View {
    private Paint mPaint = new Paint();
    private Bitmap bitmap;//位图

    public PaintColorMatrixInitView(Context context) {
        super(context);
    }

    public PaintColorMatrixInitView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintColorMatrixInitView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setAntiAlias(true);
        mPaint.setARGB(255, 200, 100, 100);
        //绘制原始位图
        canvas.drawRect(0, 0, 200, 600, mPaint);

        canvas.translate(250, 0);//位移画布

        //生成彩色矩阵
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0,
        });
        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawRect(0,0,200,600,mPaint);
    }
}

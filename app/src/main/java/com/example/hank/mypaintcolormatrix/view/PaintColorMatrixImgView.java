package com.example.hank.mypaintcolormatrix.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.hank.mypaintcolormatrix.R;

/**
 * Created by Jun on 2017/7/24.
 * 使用ColorMatrix类生成色彩矩阵，对图片多颜色的蓝色通道输出
 */

public class PaintColorMatrixImgView extends View {
    private Paint mPaint = new Paint();
    private Bitmap bitmap;//位图

    public PaintColorMatrixImgView(Context context) {
        super(context);
        mPaint.setAntiAlias(true);
        //获取位图
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.baby);
    }

    public PaintColorMatrixImgView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintColorMatrixImgView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制原始位图
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, 600, 300 * bitmap.getHeight() / bitmap
                .getWidth()), mPaint);

        canvas.translate(0, 350 * bitmap.getHeight() / bitmap
                .getWidth());
        //生成色彩矩阵
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                1/2f, 1/2f, 1/2f, 0, 0,
                1/3f, 1/3f, 1/3f, 0, 0,
                1/4f, 1/4f, 1/4f, 0, 0,
                0, 0, 0, 1, 0,
        });
        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, 600, 300 * bitmap.getHeight() / bitmap
                .getWidth()), mPaint);
    }
}

package com.example.hank.mypaintcolormatrix.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.example.hank.mypaintcolormatrix.BaseActivity;
import com.example.hank.mypaintcolormatrix.R;

/**
 * Created by Jun on 2017/7/24.
 * 给图片设置饱和度
 */

public class PaintColorMatrixSetSaturationActivity extends BaseActivity {
    private SeekBar mSeekBar,mRotateSeekBar;
    private ImageView mImageView;
    private Bitmap mOriginBmp, mTempBmp;

    @Override
    protected int getLayoutResID() {
        return R.layout.hanker_paint_color_matrix_set_saturation;
    }

    @Override
    protected void initView() {
        mImageView = (ImageView) findViewById(R.id.hanker_paint_color_matrix_img);
        mSeekBar = (SeekBar) findViewById(R.id.hanker_paint_color_matrix_seekbar);
        mRotateSeekBar = (SeekBar) findViewById(R.id.hanker_paint_color_matrix_seekbar_rotate);
        mOriginBmp = BitmapFactory.decodeResource(getResources(), R.drawable.baby);
        mTempBmp = Bitmap.createBitmap(mOriginBmp.getWidth(), mOriginBmp.getHeight(), Bitmap
                .Config.ARGB_8888);

    }

    @Override
    protected void initData() {
        //滑块默认在一的位置，向左到底是0，向右到底是20（即饱和度放大20倍）
        mSeekBar.setMax(20);
        mSeekBar.setProgress(1);

        mRotateSeekBar.setMax(360);
        mRotateSeekBar.setProgress(180);
    }

    @Override
    protected void initListener() {
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Bitmap bitmap = handleColorMatrixBmp(progress);
                mImageView.setImageBitmap(bitmap);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mRotateSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Bitmap bitmap = handleColorRotateBmp(progress);
                mImageView.setImageBitmap(bitmap);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    /**
     * 设置色彩旋转
     */
    private Bitmap handleColorRotateBmp(int progress) {
        //创建一个相同尺寸的可变的位图区，用于绘制调色后的图片
        Canvas canvas = new Canvas(mTempBmp);
        Paint paint = new Paint();//新建Paint
        paint.setAntiAlias(true);//边缘平滑处理
        ColorMatrix colorMatrix = new ColorMatrix();

        colorMatrix.setRotate(0,progress-180);

        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));//设置颜色变换效果
        canvas.drawBitmap(mOriginBmp,0,0,paint);//将颜色变化后的图片输出到新创建的位图区
        //返回新位图，也即调色处理后的图片
        return mTempBmp;
    }

    /**
     * 设置饱和度
     */
    private Bitmap handleColorMatrixBmp(int progress) {
        //创建一个相同尺寸的可变的位图区，用于绘制调色后的图片
        Canvas canvas = new Canvas(mTempBmp);
        Paint paint = new Paint();//新建Paint
        paint.setAntiAlias(true);//边缘平滑处理
        ColorMatrix mSaturationMatrix = new ColorMatrix();
        mSaturationMatrix.setSaturation(progress);

        paint.setColorFilter(new ColorMatrixColorFilter(mSaturationMatrix));//设置颜色变换效果
        canvas.drawBitmap(mOriginBmp,0,0,paint);//将颜色变化后的图片输出到新创建的位图区
        //返回新位图，也即调色处理后的图片
        return mTempBmp;
    }

    @Override
    public void onClick(View v) {


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTempBmp != null){
            mTempBmp = null;
        }
        if (mOriginBmp != null){
            mOriginBmp=null;
        }
    }
}

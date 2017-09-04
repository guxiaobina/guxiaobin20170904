package com.gxb.guxiaobin20170904;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import static com.gxb.guxiaobin20170904.R.attr.ringWidth;

/**
 * Created by g on 2017/9/4.
 */

public class MyView extends LinearLayout {
    private   Paint paint;
    private  Context context;
    private float width;
    private int ringColor;

    private int color;
    private Button changeColor;

    public MyView(Context context) {
        super(context);
    }

    public MyView(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View inflate = View.inflate(getContext(), R.layout.myview, this);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        ringColor = typedArray.getColor(R.styleable.MyView_ringColor, Color.BLACK);
        width = typedArray.getDimension(R.styleable.MyView_ringWidth, 10);
        this.context = context;
        this.paint = new Paint();
        this.paint.setAntiAlias(true); //消除锯齿
        this.paint.setStyle(Paint.Style.STROKE); //绘制空心圆
        setWillNotDraw(false);

        changeColor = (Button) inflate.findViewById(R.id.changeColor);

        changeColor.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ringColor=R.color.colorAccent;
                Toast.makeText(context, "dd", Toast.LENGTH_SHORT).show();
                invalidate();
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        int center = getWidth()/2;
        int innerCircle = dip2px(context, 83); //设置内圆半径
        int ringWidth = dip2px(context, width); //设置圆环宽度

        //绘制内圆
        this.paint.setARGB(155, 167, 190, 206);
        this.paint.setStrokeWidth(2);
        canvas.drawCircle(center,center, innerCircle, this.paint);

        //绘制圆环
        this.paint.setColor(ringColor);
        this.paint.setStrokeWidth(ringWidth);
        canvas.drawCircle(center,center, innerCircle+1+ringWidth/2, this.paint);

        //绘制外圆
        this.paint.setARGB(155, 167, 190, 206);
        this.paint.setStrokeWidth(2);
        canvas.drawCircle(center,center, innerCircle+ringWidth, this.paint);


        super.onDraw(canvas);
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public interface Onclick{
        void setColor(View view);
    }

    private Onclick onclick;

    public void setOnclick(Onclick onclick,int color) {
        this.onclick = onclick;
        this.ringColor=color;
    }


}

package com.example.in_classactivity5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyDrawView extends View {

    Path path = new Path();

    public MyDrawView(Context context) {
        super(context);
    }

    public MyDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    void setPoints(PointF A, PointF B, PointF C, PointF D) { //defines what the shape looks like
        path.reset();

        path.moveTo(A.x, A.y);
        path.lineTo(B.x, B.y);
        path.lineTo(C.x, C.y);
        path.lineTo(D.x, D.y);
        path.close();

        invalidate();
    }

    void rotate(float degrees, float centerX, float centerY) {
        Matrix matrix = new Matrix();
        //matrix.postRotate(degrees);
        //Pivot around a point (x, y)
        matrix.postRotate(degrees, centerX, centerY); //center of the rectangle

        path.transform(matrix);
        invalidate();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(android.graphics.Color.BLUE);

        canvas.translate(100, 100);

        canvas.drawPath(path, paint); //renders path to screen
    }
}
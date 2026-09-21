package com.example.rahban3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class LiveRouteView extends View {

    private Paint paint;
    private Path routeBlue;
    private Path routeGreen;

    // سازنده برای استفاده در XML
    public LiveRouteView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }


    public LiveRouteView(Context context) {
        super(context);

        init();
    }

    private void init() {

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        routeBlue = new Path();
        routeGreen = new Path();

        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float w = getWidth();
        float h = getHeight();

        // -----------------------------
        // پس زمینه نقشه
        // -----------------------------

        canvas.drawColor(Color.rgb(241, 245, 241));


        // -----------------------------
        // خیابان های اصلی
        // -----------------------------

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(7);
        paint.setColor(Color.WHITE);

        for (float i = -h; i < w + h; i += 95) {

            canvas.drawLine(
                    i,
                    0,
                    i - 260,
                    h,
                    paint
            );

            canvas.drawLine(
                    i,
                    h,
                    i + 300,
                    0,
                    paint
            );
        }


        // -----------------------------
        // خیابان های فرعی
        // -----------------------------

        paint.setStrokeWidth(2);
        paint.setColor(Color.rgb(220, 228, 220));

        for (float i = -h; i < w + h; i += 48) {

            canvas.drawLine(
                    i,
                    0,
                    i - 220,
                    h,
                    paint
            );

            canvas.drawLine(
                    i,
                    h,
                    i + 240,
                    0,
                    paint
            );
        }


        // -----------------------------
        // green
        // -----------------------------

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(220, 237, 220));

        canvas.drawRect(
                w * 0.05f,
                h * 0.35f,
                w * 0.28f,
                h * 0.48f,
                paint
        );

        canvas.drawRect(
                w * 0.65f,
                h * 0.22f,
                w * 0.92f,
                h * 0.34f,
                paint
        );

        canvas.drawRect(
                w * 0.10f,
                h * 0.70f,
                w * 0.30f,
                h * 0.82f,
                paint
        );


        // -----------------------------
        // blue path
        // -----------------------------

        routeBlue.reset();

        routeBlue.moveTo(
                w * 0.50f,
                h * 0.29f
        );

        routeBlue.lineTo(
                w * 0.42f,
                h * 0.39f
        );

        routeBlue.lineTo(
                w * 0.58f,
                h * 0.51f
        );

        routeBlue.lineTo(
                w * 0.65f,
                h * 0.58f
        );

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(Color.rgb(55, 103, 224));

        canvas.drawPath(routeBlue, paint);


        // -----------------------------
        // path green
        // -----------------------------

        routeGreen.reset();

        routeGreen.moveTo(
                w * 0.65f,
                h * 0.58f
        );

        routeGreen.cubicTo(
                w * 0.72f,
                h * 0.66f,
                w * 0.75f,
                h * 0.70f,
                w * 0.70f,
                h * 0.76f
        );

        routeGreen.cubicTo(
                w * 0.64f,
                h * 0.82f,
                w * 0.53f,
                h * 0.83f,
                w * 0.45f,
                h * 0.84f
        );

        paint.setColor(Color.rgb(15, 166, 154));

        canvas.drawPath(routeGreen, paint);


        // -----------------------------
        // live location
        // -----------------------------

        paint.setStyle(Paint.Style.FILL);

        paint.setColor(Color.WHITE);

        canvas.drawCircle(
                w * 0.65f,
                h * 0.58f,
                12,
                paint
        );

        paint.setColor(Color.rgb(15, 166, 154));

        canvas.drawCircle(
                w * 0.65f,
                h * 0.58f,
                7,
                paint
        );
    }
}
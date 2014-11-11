package com.dam.actionbar;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

import com.dam.actionbar.CanvasView;


@SuppressLint("DrawAllocation")
public class CirculoView extends CanvasView {
    private Path trazo;
    private Paint pincel;


    public CirculoView(Context context) {
        super(context);
        trazo = new Path();
        pincel = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float radio;
        if (canvas.getWidth() > canvas.getHeight()) {
            radio = canvas.getHeight()/3;
        } else {
            radio = canvas.getWidth()/3;
        }
        int radioCirculo = 200;
        @SuppressWarnings("unused")
		RectF cuadrado = new RectF(super.getWidthCenter() - radio, super.getHeightCenter() - radio, super.getWidthCenter() + radio, super.getHeightCenter() + radio);
        trazo.addCircle(super.getWidthCenter(), super.getHeightCenter(), radioCirculo, Path.Direction.CW);
        //trazo.addRect(cuadrado, Path.Direction.CW);
        pincel.setColor(Color.RED);
        canvas.drawPath(trazo, pincel);
        trazo.reset();

    }
}
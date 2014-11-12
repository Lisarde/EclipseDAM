package com.dam.examen;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

import com.dam.examen.CanvasView;


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
        @SuppressWarnings("unused")
		RectF cuadrado = new RectF(super.getWidthCenter() - radio, super.getHeightCenter() - radio, super.getWidthCenter() + radio, super.getHeightCenter() + radio);
        trazo.addCircle(super.getWidthCenter(), super.getHeightCenter(), 200, Path.Direction.CW);
        //trazo.addRect(cuadrado, Path.Direction.CW);
     
        /* TRIANGULO
        trazo.moveTo(150,500);
        trazo.lineTo(450,500);
        trazo.lineTo(300,250);
        */
        
        pincel.setColor(Color.RED);
        canvas.drawPath(trazo, pincel);
        trazo.reset();
		
    }
}
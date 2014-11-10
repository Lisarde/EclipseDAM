package com.dam.patch;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;


public class EjemploGraficosActivity extends Activity {

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(new EjemploView(this));

    }

 

    public class EjemploView extends View {

            public EjemploView (Context context) {

                super(context);

            }


            protected void onDraw(Canvas canvas) {
        	
            //Dibujar aquí
            	 Path  trazo = new Path();

            	 trazo.moveTo(50, 100);

            	 trazo.cubicTo(70,80, 150,65, 200,110);

            	 trazo.lineTo(300,200);

            	 canvas.drawColor(Color.WHITE);

            	 Paint pincel = new Paint();

            	 pincel.setColor(Color.BLUE);

            	 pincel.setStrokeWidth(8);

            	 pincel.setStyle(Style.STROKE);

            	 canvas.drawPath(trazo, pincel);

            	 pincel.setStrokeWidth(1);

            	 pincel.setStyle(Style.FILL);

            	 pincel.setTextSize(20);

            	 pincel.setTypeface(Typeface.SANS_SERIF);

            	 canvas.drawTextOnPath("  Hecho por Carlos Lisarde", trazo, 20, 60, pincel);

        }

    }

}

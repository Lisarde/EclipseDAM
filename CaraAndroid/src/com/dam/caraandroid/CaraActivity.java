package com.dam.caraandroid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.View;


public class CaraActivity extends Activity {

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(new EjemploView(this));
        
        

    }

 

    public class EjemploView extends View {
    	
    	private ShapeDrawable miImagen;

            public EjemploView (Context context) {

                super(context);
                
                miImagen  = new ShapeDrawable(new OvalShape());

                miImagen.getPaint().setColor(0xff0000ff);

                
                
            }


            protected void onDraw(Canvas canvas) {
        	
            //Dibujar aquí
            	
            	int ancho =	canvas.getWidth()/5;
            	int alto = canvas.getHeight()/5;
            	
            	miImagen.setBounds(ancho, alto, ancho*4, alto*3);
            	 miImagen.draw(canvas);
            	 
            	 
            	
            	 Paint pincel = new Paint();
            	 pincel.setColor(Color.BLACK);
            	 pincel.setStrokeWidth(8);
            	 pincel.setStyle(Style.STROKE);
            	 canvas.drawCircle(200, 300, 100, pincel);
            	 
            	 
            	 
            	 Paint gorra = new Paint();
            	 gorra.setColor(Color.RED);
            	 gorra.setStrokeWidth(8);
            	 gorra.setStyle(Style.STROKE);
            	 canvas.drawLine(100, 220, 370, 220, gorra);
            	 
            	 
            	 Path  trazo = new Path();
            	 trazo.moveTo(100, 220);
            	 trazo.cubicTo(90,210, 140,165, 200,150);
            	 trazo.moveTo(200, 150);
            	 trazo.cubicTo(240,165, 290,210, 300,220);
            	 trazo.moveTo(200, 150);
            	 trazo.cubicTo(170,170, 150,195, 130,220);
            	 trazo.moveTo(200, 150);
            	 trazo.cubicTo(190,170, 180,195, 170,220);
            	 trazo.moveTo(200, 150);
            	 trazo.cubicTo(205,170, 210,195, 220,220);
            	 trazo.moveTo(200, 150);
            	 trazo.cubicTo(220,170, 240,195, 260,220);

            	 canvas.drawPath(trazo, gorra);
            	 
            	 
            	 
            	 
            	 Paint ojos = new Paint();
            	 ojos.setColor(Color.BLACK);
            	 ojos.setStrokeWidth(4);
            	 ojos.setStyle(Style.STROKE);
            	 canvas.drawCircle(170, 270, 15, ojos);
            	 canvas.drawCircle(230, 270, 15, ojos);
            	 
            	 Paint pupila = new Paint();
            	 pupila.setColor(Color.CYAN);
            	 pupila.setStrokeWidth(2);
            	 pupila.setStyle(Style.STROKE);
            	 canvas.drawCircle(167, 273, 5, pupila);
            	 canvas.drawCircle(227, 273, 5, pupila);
            	 
            	 
            	 Path  boca = new Path();
            	 boca.moveTo(170, 340);
            	 boca.cubicTo(175,350, 185,355, 195,360);
            	 boca.moveTo(195, 360);
            	 boca.cubicTo(205,355, 215,350, 220, 340);          	 
            	 canvas.drawPath(boca, ojos);
            	 
            	 Path nariz = new Path();           	 
            	 canvas.drawLine(190, 315, 205, 300, ojos);
            	 nariz.moveTo(190, 315);
            	 nariz.cubicTo(188,317, 190,319, 195,321);
            	 canvas.drawPath(nariz, ojos);
            	 
            	 
            	 Paint nombre = new Paint();
            	 nombre.setColor(Color.BLACK);
            	 nombre.setStrokeWidth(25);
            	 pupila.setStyle(Style.STROKE);
            	 canvas.drawText("Carlos    Lisarde", 278, 235, nombre);
        }

    }

}

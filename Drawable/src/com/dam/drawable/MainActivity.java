package com.dam.drawable;


import org.apache.commons.logging.Log;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;



public class MainActivity extends Activity {

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(new EjemploView(this));

    }

 

    public class EjemploView extends View {
    	 private Drawable miImagen;

    	 Display display = getWindowManager().getDefaultDisplay();
    	 
    	 
            public EjemploView (Context context) {
            	
            	super(context);
            	
            	Resources res = context.getResources();

                miImagen = res.getDrawable(R.drawable.mi_imagen);
            	      

            }

            protected void onDraw(Canvas canvas) {
        	
            	
            	  miImagen.setBounds(canvas.getWidth()/2-100,30,300,200);
            	
            	 miImagen.draw(canvas);
   	 
            	 Paint pincel = new Paint();
            	 pincel.setColor(Color.BLACK);
            	 canvas.drawText("Carlos Lisarde", 20, 240, pincel);

        }

    }

}

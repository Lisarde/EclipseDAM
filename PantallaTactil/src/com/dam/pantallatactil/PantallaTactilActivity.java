package com.dam.pantallatactil;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;


public class PantallaTactilActivity extends Activity implements OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_tactil);
        
        TextView entrada = (TextView)findViewById(R.id.TextViewEntrada);

        entrada.setOnTouchListener(this);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pantalla_tactil, menu);
        return true;
        
        
        
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public boolean onTouch(View vista, MotionEvent evento) {
		TextView salida = (TextView) findViewById(R.id.TextViewSalida);

		salida.setText(evento.toString()+"\n" );
		return true;
	}
	
	
	
}

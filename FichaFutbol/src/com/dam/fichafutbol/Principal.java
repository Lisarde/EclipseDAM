package com.dam.fichafutbol;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Principal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		 // Capturamos los objetos gráficos que vamos a usar
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
   
        // Fijamos un evento onclick para el button1, cada vez que
        // lo pulsemos se llamará a este método (que abrirá una actividad)
        button1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               Intent intent = new Intent(Principal.this, Ficha.class);
               startActivity(intent);
            }
         });
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               Intent intent = new Intent(Principal.this, Eliminar.class);
               startActivity(intent);
            }
         });
        
        button3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               Intent intent = new Intent(Principal.this, Actualizar.class);
               startActivity(intent);
            }
         });
       
        button4.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               Intent intent = new Intent(Principal.this, Mostrar.class);
               startActivity(intent);
            }
         });
        
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal, menu);
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
}

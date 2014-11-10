package com.dam.comunicacionactividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Actividad2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_actividad2);
		
		Bundle extras = getIntent().getExtras();

	       String textoConseguido = extras.getString("usuario");
	       
	       TextView tv = (TextView)findViewById(R.id.texto1);
	       tv.setText(textoConseguido);
  
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.actividad2, menu);
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
	
	public void aceptar(View view){    	
		Intent intent = new Intent();

	       intent.putExtra("resultado","Aceptado");

	       setResult(RESULT_OK, intent);

	       finish();
      }
	
	public void cancelar(View view){    	
		Intent intent = new Intent();

	       intent.putExtra("resultado","Rechazado");

	       setResult(RESULT_OK, intent);

	       finish();
      }
	
	
}

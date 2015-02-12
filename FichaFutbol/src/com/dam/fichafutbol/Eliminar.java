package com.dam.fichafutbol;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Eliminar extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eliminar);
		
Button volver = (Button) findViewById(R.id.volver);
		
		volver.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	finish();
            }
         });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.eliminar, menu);
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
	
	public void eliminarFicha(View view) {

		Intent intent = new Intent(this, RecibeEliminar.class);	
		// DNI:
		EditText dni = (EditText) findViewById(R.id.dni);
		intent.putExtra("dni", dni.getText().toString());

	
				if (dni.length() != 8) {
					Toast.makeText(this, "El DNI completo obligatorio",
							Toast.LENGTH_SHORT).show();					

				} else {
					startActivityForResult(intent, 1234);
				}
		}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == 1234 && resultCode == RESULT_OK) {

			String res = data.getExtras().getString("resultado");

			if (res.equals("Aceptado")) {

				EditText dni = (EditText) findViewById(R.id.dni);
				dni.setText("");


			}

		}

	}

	
}

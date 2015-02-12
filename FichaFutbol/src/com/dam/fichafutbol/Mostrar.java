package com.dam.fichafutbol;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Mostrar extends Activity {
	
	String lista;
	String sexo="";
	Spinner spinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mostrar);

		Button volver = (Button) findViewById(R.id.volver);

		volver.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
		
		spinner = (Spinner) findViewById(R.id.spinnerActu);
		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.spinnerActu, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mostrar, menu);
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

	public static boolean isNumber(String string) {
	    try {
	        Long.parseLong(string);
	    } catch (Exception e) {
	        return false;
	    }
	    return true;
	}
	
	public void radioBoton(View view) {
		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();

		// Check which radio button was clicked
		switch (view.getId()) {
		case R.id.hombre:
			if (checked)
				sexo = "Hombre";
			break;
		case R.id.mujer:
			if (checked)
				sexo = "Mujer";
			break;
		case R.id.bi:
			if (checked)
				sexo = "Ambos";
			break;
		}
	}
	
	public void mostrarFicha(View view) {

		Intent intent = new Intent(this, RecibeMostrar.class);
		// DNI:
		EditText dni = (EditText) findViewById(R.id.dni);
		intent.putExtra("dni", dni.getText().toString());
		// Nombre:
		EditText nombre = (EditText) findViewById(R.id.nombre);
		intent.putExtra("nombre", nombre.getText().toString());
		// Apellido:
		EditText apellido = (EditText) findViewById(R.id.apellido);
		intent.putExtra("apellido", apellido.getText().toString());
		// Apellido2:
		EditText apellido2 = (EditText) findViewById(R.id.apellido2);
		intent.putExtra("apellido2", apellido2.getText().toString());
		// Edad:
		EditText edad = (EditText) findViewById(R.id.edad);
		intent.putExtra("edad", edad.getText().toString());
		// Nivel
		lista = spinner.getSelectedItem().toString();
		intent.putExtra("spinnerActu", lista);
		// Sexo
		intent.putExtra("sexo", sexo);
		
		
		if (dni.length() != 8 && nombre.length() == 0 && apellido.length()==0 && apellido2.length()==0 && edad.length()==0 && lista.equalsIgnoreCase("Ninguno") && (sexo.length()==0 || sexo.equalsIgnoreCase("Ambos"))) {
			Toast.makeText(this, " Algun campo Obligatorio",
					Toast.LENGTH_SHORT).show();
		}  else {
			startActivityForResult(intent, 1234);
		}
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == 1234 && resultCode == RESULT_OK) {

			String res = data.getExtras().getString("resultado");

			if (res.equals("Aceptado")) {

				finish();

			}

		}

	}
}

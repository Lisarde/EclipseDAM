package com.dam.examen;

import com.dam.actionbar.R;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivityBar extends Activity {
	String lista="";
	String sexo="";
    static Spinner spinner1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_examen);
		
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner1, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner1.setAdapter(adapter);
		
		spinner1.setVisibility(View.INVISIBLE);
		
	    //Obtenemos una referencia a la actionbar
	    ActionBar barrita = getActionBar();
	 
	    //Establecemos el modo de navegaci�n por pesta�as
	    barrita.setNavigationMode(
	        ActionBar.NAVIGATION_MODE_TABS);
	 
	    //Ocultamos si queremos el t�tulo de la actividad
	    //abar.setDisplayShowTitleEnabled(false);
	 
	    //Creamos las pesta�as
	    ActionBar.Tab tab1 = barrita.newTab().setText("Pintado");
	 
	    ActionBar.Tab tab2 = barrita.newTab().setText("Formulario");
	 
	    //Creamos los fragments de cada pesta�a
	        Fragment tab1frag = new Tab1Fragment();
	        Fragment tab2frag = new Tab2Fragment();
	 
	        //Asociamos los listener a las pesta�as
	        tab1.setTabListener(new TabListener(tab1frag));
	        tab2.setTabListener(new TabListener(tab2frag));
	 
	        //A�adimos las pesta�as a la action bar
	        barrita.addTab(tab1);
	        barrita.addTab(tab2);
	        
	        
	        
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_examen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		  // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
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
		}
	}

	public void enviarFicha(View view) {
		Intent intent = new Intent(this, Actividad2.class);
		// Nombre:
		EditText nombre = (EditText) findViewById(R.id.nombre);
		intent.putExtra("nombre", nombre.getText().toString());
		// Apellido:
		EditText apellido = (EditText) findViewById(R.id.apellido);
		intent.putExtra("apellido", apellido.getText().toString());
		// Apellido2:
		EditText apellido2 = (EditText) findViewById(R.id.apellido2);
		intent.putExtra("apellido2", apellido2.getText().toString());
		// DNI:
		EditText dni = (EditText) findViewById(R.id.dni);
		intent.putExtra("dni", dni.getText().toString());
		// Edad:
		EditText edad = (EditText) findViewById(R.id.edad);
		intent.putExtra("edad", edad.getText().toString());
		// Nivel 
		
		lista = spinner1.getSelectedItem().toString();
		intent.putExtra("spinner1", lista);
		// Sexo
		intent.putExtra("sexo", sexo);

		if (nombre.length() == 0 ) {
			Toast.makeText(this, "El nombre es obligatorio", Toast.LENGTH_SHORT)
					.show();

		} else {
			if (apellido.length() == 0) {
				Toast.makeText(this, "El apellido es obligatorio",
						Toast.LENGTH_SHORT).show();

			} else {
				if (dni.length() != 8) {
					Toast.makeText(this, "El DNI completo obligatorio",
							Toast.LENGTH_SHORT).show();					

				} else {
					if (edad.length() == 0) {
						Toast.makeText(this, "La edad es obligatoria",
								Toast.LENGTH_SHORT).show();

					} else {
						
						if (sexo.length()==0) {
							Toast.makeText(this, "El sexo es obligatorio",
									Toast.LENGTH_SHORT).show();

						} else {
							if (isNumber(nombre.getText().toString()) || isNumber(apellido.getText().toString()) || isNumber(apellido2.getText().toString())) {
								Toast.makeText(this, "No se pueden introducir numeros en este campo",
										Toast.LENGTH_SHORT).show();
							}else {
								startActivityForResult(intent, 1234);
							}
								

						}

					}

				}

			}

		}

	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == 1234 && resultCode == RESULT_OK) {

			String res = data.getExtras().getString("resultado");

			if (res.equals("Aceptado")) {

				EditText nom = (EditText) findViewById(R.id.nombre);
				nom.setText("");
				EditText ape = (EditText) findViewById(R.id.apellido);
				ape.setText("");
				EditText ape2 = (EditText) findViewById(R.id.apellido2);
				ape2.setText("");
				EditText dni = (EditText) findViewById(R.id.dni);
				dni.setText("");
				EditText eda = (EditText) findViewById(R.id.edad);
				eda.setText("");

			}

		}

	}
	
	
	
	
}

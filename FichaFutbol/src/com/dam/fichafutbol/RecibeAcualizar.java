package com.dam.fichafutbol;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import android.widget.TextView;
import android.widget.Toast;

public class RecibeAcualizar extends Activity {
	
	private SQLiteDatabase db;
	String nombreDeFicha;
    String apellidoDeFicha;
    String apellido2DeFicha;
    String dniDeFicha;
    String edadDeFicha;
    String spinner1DeFicha;
    String sexoDeFicha;
    String sexo="";
    Spinner spinner;
    RadioButton r1;
    RadioButton r2;
    
    String lista;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recibe_acualizar);
		
		
Button volver = (Button) findViewById(R.id.volver);
		
		volver.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	finish();
            }
         });

		spinner = (Spinner) findViewById(R.id.spinner1);
		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.spinner1, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		
		
		FichaFutbolBD usdbh = new FichaFutbolBD(this,
				"DBFichaFutbol", null, 1);
		db = usdbh.getWritableDatabase();
		
		
		Bundle extrass = getIntent().getExtras();

	       dniDeFicha = extrass.getString("dni");

	       int dniConvert = Integer.parseInt(dniDeFicha.toString());
	       
	       String DNIFinal = letraDNI(dniConvert);
	       
	       Cursor c = db.rawQuery("SELECT * FROM Jugadores WHERE DNI=\""+DNIFinal+"\"", null);
	              
	       if (c.moveToFirst()) {
	    	     //Recorremos el cursor hasta que no haya más registros
	    	   //  do {
	    	   		dniDeFicha= c.getString(0);
	    	        nombreDeFicha= c.getString(1);
	    	        apellidoDeFicha = c.getString(2);
	    	        apellido2DeFicha= c.getString(3);
	    	        edadDeFicha= c.getString(4);
	    	        spinner1DeFicha= c.getString(5);
	    	        sexoDeFicha= c.getString(6);       	    	          	    	    
	    	 //    } while(c.moveToNext());
	    	} else {
	    		Toast.makeText(this, "No existe el DNI", Toast.LENGTH_SHORT).show();
	    	}
	       
	       
	       EditText nombre = (EditText)findViewById(R.id.nombre);
	       nombre.setText(nombreDeFicha);
	       EditText apellido = (EditText)findViewById(R.id.apellido);
	       apellido.setText(apellidoDeFicha);
	       EditText apellido2 = (EditText)findViewById(R.id.apellido2);
	       apellido2.setText(apellido2DeFicha);	       
	       EditText dni = (EditText)findViewById(R.id.dni);
	       dni.setText(dniDeFicha);
	       EditText edad = (EditText)findViewById(R.id.edad);
	       edad.setText(edadDeFicha);
	       r1=(RadioButton)findViewById(R.id.hombre);
	       r2=(RadioButton)findViewById(R.id.mujer);
	       if(sexoDeFicha.equalsIgnoreCase("Hombre")){
	    	   r1.setChecked(true); 
	       }
	       if(sexoDeFicha.equalsIgnoreCase("Mujer")){
	    	   r2.setChecked(true); 
	       }
	       
	       Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
	       
	       for (int i = 0; i < spinner1.getCount(); i++) {
			spinner1.setSelection(i);
			if(spinner1DeFicha.equalsIgnoreCase(spinner1.getSelectedItem().toString())){
				break;
			}

		}

	}

	public static final String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
	 
	  /**
	   * Devuelve un NIF completo a partir de un DNI. Es decir, añade la letra del NIF
	   * @param dni dni al que se quiere añadir la letra del NIF
	   * @return NIF completo.
	   */
	  public static String letraDNI(int dni) {
	    return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(dni % 23);
	  }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recibe_acualizar, menu);
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
		}
	}
	public void enviarFicha(View view) {
		Intent intentAC = new Intent(this, RecibeActualizarConfirm.class);
		// Nombre:
		EditText nombre = (EditText) findViewById(R.id.nombre);
		intentAC.putExtra("nombre", nombre.getText().toString());
		// Apellido:
		EditText apellido = (EditText) findViewById(R.id.apellido);
		intentAC.putExtra("apellido", apellido.getText().toString());
		// Apellido2:
		EditText apellido2 = (EditText) findViewById(R.id.apellido2);
		intentAC.putExtra("apellido2", apellido2.getText().toString());
		// DNI:
		EditText dni = (EditText) findViewById(R.id.dni);
		intentAC.putExtra("dni", dni.getText().toString());
		// Edad:
		EditText edad = (EditText) findViewById(R.id.edad);
		intentAC.putExtra("edad", edad.getText().toString());
		// Nivel
		lista = spinner.getSelectedItem().toString();
		intentAC.putExtra("spinner1", lista);
		// Sexo
		intentAC.putExtra("sexo", sexo);

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
						
						if (r1.isSelected() || r2.isSelected()) {
							Toast.makeText(this, "El sexo es obligatorio",
									Toast.LENGTH_SHORT).show();

						} else {
							if (isNumber(nombre.getText().toString()) || isNumber(apellido.getText().toString()) || isNumber(apellido2.getText().toString())) {
								Toast.makeText(this, "No se pueden introducir numeros en este campo",
										Toast.LENGTH_SHORT).show();
							}else {
								startActivityForResult(intentAC, 12345);
							}
								

						}

					}

				}

			}

		}

	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == 12345 && resultCode == RESULT_OK) {

			String res = data.getExtras().getString("resultado");

			if (res.equals("Aceptado")) {

				finish();

			}

		}

	}

}


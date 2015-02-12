package com.dam.fichafutbol;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RecibeFicha extends Activity {

	private SQLiteDatabase db;
	String nombreDeFicha;
    String apellidoDeFicha;
    String apellido2DeFicha;
    String dniDeFicha;
    String edadDeFicha;
    String spinner1DeFicha;
    String sexoDeFicha;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recibe_ficha);
		
		 // Abrimos la base de datos 'DBFichaFutbol' en modo escritura
		FichaFutbolBD usdbh = new FichaFutbolBD(this,
				"DBFichaFutbol", null, 1);
		db = usdbh.getWritableDatabase();
		
		
		
		Bundle extras = getIntent().getExtras();

	       nombreDeFicha = extras.getString("nombre");
	       apellidoDeFicha = extras.getString("apellido");
	       apellido2DeFicha = extras.getString("apellido2");
	       dniDeFicha = extras.getString("dni");
	       edadDeFicha = extras.getString("edad");
	       spinner1DeFicha = extras.getString("spinner1");
	       sexoDeFicha = extras.getString("sexo");
	       
	       
	       TextView nombre = (TextView)findViewById(R.id.nombreR);
	       nombre.setText(nombreDeFicha);
	       TextView apellido = (TextView)findViewById(R.id.apellidoR);
	       apellido.setText(apellidoDeFicha);
	       TextView apellido2 = (TextView)findViewById(R.id.apellido2R);
	       apellido2.setText(apellido2DeFicha);
	       
	       TextView dni = (TextView)findViewById(R.id.dniR);	
	       int dniConvert = Integer.parseInt(dniDeFicha.toString());
	       dni.setText(letraDNI(dniConvert));
	       
	       TextView edad = (TextView)findViewById(R.id.edadR);
	       edad.setText(edadDeFicha);
	       TextView spinner1 = (TextView)findViewById(R.id.spinner1R);
	       spinner1.setText(spinner1DeFicha);
	       TextView sexo = (TextView)findViewById(R.id.sexoR);
	       sexo.setText(sexoDeFicha);
	       
	       
	       
	       
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
		getMenuInflater().inflate(R.menu.recibe_ficha, menu);
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

			ContentValues nuevoRegistro = new ContentValues();	
			//pasamos primero a int el DNI para con el emtodo letraDNI añadirle la letra y hacerlo String;
			int dniConvert = Integer.parseInt(dniDeFicha.toString());
			nuevoRegistro.put("DNI", letraDNI(dniConvert));
			
			nuevoRegistro.put("nombre", nombreDeFicha);
			nuevoRegistro.put("apellido", apellidoDeFicha);
			nuevoRegistro.put("apellido2", apellido2DeFicha);
			nuevoRegistro.put("edad", edadDeFicha);
			nuevoRegistro.put("categoria", spinner1DeFicha);
			nuevoRegistro.put("sexo", sexoDeFicha);
					
			db.insert("Jugadores", null, nuevoRegistro);
	       
			
			Intent intent = new Intent();

		       intent.putExtra("resultado","Aceptado");

		       setResult(RESULT_OK, intent);
	   	
	       Toast.makeText(this, "Los datos se han guardado correctamente", Toast.LENGTH_SHORT).show();


	       finish();
      }
	
	public void cancelar(View view){    	
		Intent intentA = new Intent();

	       intentA.putExtra("resultado","Rechazado");

	       setResult(RESULT_OK, intentA);

	       finish();
      }
}

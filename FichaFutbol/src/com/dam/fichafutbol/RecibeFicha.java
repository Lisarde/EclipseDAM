package com.dam.fichafutbol;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RecibeFicha extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recibe_ficha);
		
		
		Bundle extras = getIntent().getExtras();

	       String nombreDeFicha = extras.getString("nombre");
	       String apellidoDeFicha = extras.getString("apellido");
	       String apellido2DeFicha = extras.getString("apellido2");
	       String dniDeFicha = extras.getString("dni");
	       String edadDeFicha = extras.getString("edad");
	       String spinner1DeFicha = extras.getString("spinner1");
	       String sexoDeFicha = extras.getString("sexo");
	       
	       
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
		Intent intent = new Intent();

	       intent.putExtra("resultado","Aceptado");

	       setResult(RESULT_OK, intent);
	   	
	       Toast.makeText(this, "Los datos se han guardado correctamente", Toast.LENGTH_SHORT).show();


	       finish();
      }
	
	public void cancelar(View view){    	
		Intent intent = new Intent();

	       intent.putExtra("resultado","Rechazado");

	       setResult(RESULT_OK, intent);

	       finish();
      }
}

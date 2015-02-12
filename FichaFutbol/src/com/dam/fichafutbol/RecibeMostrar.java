package com.dam.fichafutbol;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RecibeMostrar extends Activity {
	
	private SQLiteDatabase db;
	String nombreDeFicha;
    String apellidoDeFicha;
    String apellido2DeFicha;
    String dniDeFicha;
    String dniDeFichaC;
    String edadDeFicha;
    String spinner1DeFicha;
    String sexoDeFicha;
    String Total;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recibe_mostrar);
		
		FichaFutbolBD usdbh = new FichaFutbolBD(this,
				"DBFichaFutbol", null, 1);
		db = usdbh.getWritableDatabase();
		
		Bundle extras = getIntent().getExtras();

		String DNIFinal="";
			if(extras.getString("dni").length()==8) {
				
			
	       dniDeFicha = extras.getString("dni");

	       int dniConvert = Integer.parseInt(dniDeFicha.toString());
			
	       
	       DNIFinal = letraDNI(dniConvert);
			}
			
	       nombreDeFicha = extras.getString("nombre");
	       apellidoDeFicha = extras.getString("apellido");
	       apellido2DeFicha = extras.getString("apellido2");
	       edadDeFicha = extras.getString("edad");
	       spinner1DeFicha = extras.getString("spinnerActu");
	       sexoDeFicha = extras.getString("sexo");
			
	       String parametros = "";      
	       
	       //"CREATE TABLE Jugadores (DNI TEXT PRIMARY KEY, nombre TEXT, apellido TEXT, apellido2 TEXT, edad TEXT, categoria TEXT, sexo TEXT)";
	       
	       if (extras.getString("dni").length() > 0) {  
	         parametros += " OR DNI=\""+DNIFinal+"\"";
	       
	       }
	       if (nombreDeFicha.length() > 0) {
	    	 parametros += " OR nombre=\""+nombreDeFicha+"\"";
	       }
	       
	       if(apellidoDeFicha.length() > 0){
	    	   parametros += " OR apellido=\""+apellidoDeFicha+"\"";
	       }
	       if(apellido2DeFicha.length() > 0){
	    	   parametros += " OR apellido2=\""+apellido2DeFicha+"\"";
	       }
	       if(edadDeFicha.length() > 0){
	    	   parametros += " OR edad=\""+edadDeFicha+"\"";
	       }
	       if(!spinner1DeFicha.equalsIgnoreCase("Ninguno")){
	    	   parametros += " OR categoria=\""+spinner1DeFicha+"\"";
	       }
	       if(sexoDeFicha.length() > 0){
	    	   parametros += " OR sexo=\""+sexoDeFicha+"\"";
	       }
	              
	       Cursor c = db.rawQuery("SELECT * FROM Jugadores WHERE 1!=1"+ parametros, null);
	       
	       if (c.moveToFirst()) {
	    	   		dniDeFicha = c.getString(0);
	    	        nombreDeFicha = c.getString(1);
	    	        apellidoDeFicha = c.getString(2);
	    	        apellido2DeFicha = c.getString(3);
	    	        edadDeFicha = c.getString(4);
	    	        spinner1DeFicha = c.getString(5);
	    	        sexoDeFicha = c.getString(6);  
	    	        Total= ""+nombreDeFicha+" "+apellidoDeFicha+" "+apellido2DeFicha+"\n"+dniDeFicha+" "+edadDeFicha+" "+spinner1DeFicha+" "+sexoDeFicha+"\n";
	    	  	    	} else {
	    	  	    		Toast.makeText(this, "No existe el Registro", Toast.LENGTH_SHORT).show();
	    	  	    		finish();
	    	  	    	}	       	
	       //si el resultado devuelve mas de 1:
	    	        if (c.moveToNext()) {
	    	        	   do {
	    	        		   dniDeFicha = c.getString(0);
	    		    	        nombreDeFicha = c.getString(1);
	    		    	        apellidoDeFicha = c.getString(2);
	    		    	        apellido2DeFicha = c.getString(3);
	    		    	        edadDeFicha = c.getString(4);
	    		    	        spinner1DeFicha = c.getString(5);
	    		    	        sexoDeFicha = c.getString(6);  
		    	        Total += ""+nombreDeFicha+" "+apellidoDeFicha+" "+apellido2DeFicha+"\n"+dniDeFicha+" "+edadDeFicha+" "+spinner1DeFicha+" "+sexoDeFicha+"\n";
		    	       	} while(c.moveToNext());
	    	        }
	    	        
    	 
	      /* 
	       TextView nombre = (TextView)findViewById(R.id.nombreR);
	       nombre.setText(nombreDeFicha);
	       TextView apellido = (TextView)findViewById(R.id.apellidoR);
	       apellido.setText(apellidoDeFicha);
	       TextView apellido2 = (TextView)findViewById(R.id.apellido2R);
	       apellido2.setText(apellido2DeFicha);	       
	       TextView dni = (TextView)findViewById(R.id.dniR);
	       dni.setText(dniDeFicha);
	       TextView edad = (TextView)findViewById(R.id.edadR);
	       edad.setText(edadDeFicha);
	       TextView spinner1 = (TextView)findViewById(R.id.spinner1R);
	       spinner1.setText(spinner1DeFicha);
	       TextView sexo = (TextView)findViewById(R.id.sexoR);
	       sexo.setText(sexoDeFicha);
	       */
	    TextView total = (TextView)findViewById(R.id.totalR);
	    total.setText(Total);
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
		getMenuInflater().inflate(R.menu.recibe_mostrar, menu);
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

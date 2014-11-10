package com.dam.comunicacionactividades;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Comunicacion extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunicacion);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.comunicacion, menu);
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
    
    public void lanzarActividad2(View view){    	
        Intent intent = new Intent(this, Actividad2.class);
        EditText et = (EditText)findViewById(R.id.textoPasa);
        intent.putExtra("usuario", et.getText().toString());
        startActivityForResult(intent, 1234);
      }
    
   protected void onActivityResult (int requestCode,int resultCode, Intent data){

	   	if (requestCode==1234 && resultCode==RESULT_OK) {

	   				String res = data.getExtras().getString("resultado");
	   				
	   		       
	   		       TextView tv = (TextView)findViewById(R.id.textoconse);
	   		       tv.setText(res);
	   				
	   				
	   				}
   }
    
}

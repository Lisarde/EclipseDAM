package com.dam.actionbar;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivityBar extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_bar);
		
	    //Obtenemos una referencia a la actionbar
	    ActionBar abar = getActionBar();
	 
	    //Establecemos el modo de navegación por pestañas
	    abar.setNavigationMode(
	        ActionBar.NAVIGATION_MODE_TABS);
	 
	    //Ocultamos si queremos el título de la actividad
	    //abar.setDisplayShowTitleEnabled(false);
	 
	    //Creamos las pestañas
	    ActionBar.Tab tab1 = abar.newTab().setText("Tab 1 Cir");
	 
	    ActionBar.Tab tab2 = abar.newTab().setText("Tab 2 Cuad");
	 
	    //Creamos los fragments de cada pestaña
	        Fragment tab1frag = new Tab1Fragment();
	        Fragment tab2frag = new Tab2Fragment();
	 
	        //Asociamos los listener a las pestañas
	        tab1.setTabListener(new TabListener(tab1frag));
	        tab2.setTabListener(new TabListener(tab2frag));
	 
	        //Añadimos las pestañas a la action bar
	        abar.addTab(tab1);
	        abar.addTab(tab2);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_bar, menu);
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
	
	
}

package com.dam.examen;


import com.dam.actionbar.R;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.util.Log;
import android.view.View;
 
public class TabListener implements ActionBar.TabListener {
 
    private Fragment fragment;
 
    public TabListener(Fragment fg)
    {
        this.fragment = fg;
    }
 
    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        Log.i("ActionBar", tab.getText() + " reseleccionada.");
    }
 
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        Log.i("ActionBar", tab.getText() + " seleccionada.");
        ft.replace(R.id.contenedor, fragment);
        //la id.contenedor es el id que le doy al layout principal;
        
        if(tab.getText()=="Formulario") {
        	MainActivityBar.spinner1.setVisibility(View.VISIBLE);
        }
       if(tab.getText()=="Pintado"){
    	   MainActivityBar.spinner1.setVisibility(View.INVISIBLE);
       }
    }
 
    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        Log.i("ActionBar", tab.getText() + " deseleccionada.");
        ft.remove(fragment);
    }
}

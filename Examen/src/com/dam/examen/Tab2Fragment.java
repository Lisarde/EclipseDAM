package com.dam.examen;



import com.dam.actionbar.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


 
public class Tab2Fragment extends Fragment {
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	
    	FrameLayout rootView = (FrameLayout) inflater.inflate(R.layout.activity_tab2_fragment, container, false);
    	
   
        return rootView;
    }

 
    
}


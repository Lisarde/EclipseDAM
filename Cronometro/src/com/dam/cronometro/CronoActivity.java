package com.dam.cronometro;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;

public class CronoActivity extends Activity {

	Chronometer cronometro;
	Long memoCronometro;
	String contnue = "inactive";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crono);

		cronometro = (Chronometer) findViewById(R.id.chronometer1);
		//se asigna el cronometro del xml

		final Button btnStart = (Button) findViewById(R.id.btn_star);
		final Button btnStop = (Button) findViewById(R.id.btn_stop);

		btnStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Boton Start
				if (contnue == "inactive") {
					cronometro.setBase(SystemClock.elapsedRealtime());
					cronometro.start();
					contnue = "active";
					btnStart.setText("Pause");
					return;
				}
				if (contnue == "active") {
					memoCronometro = SystemClock.elapsedRealtime();
					cronometro.stop();
					contnue = "pause";
					 btnStart.setText("Continue");
					return;
				}
				if (contnue == "pause") {
					cronometro.setBase((long) cronometro.getBase()
							- memoCronometro + SystemClock.elapsedRealtime());
					cronometro.start();
					contnue = "active";
					if(btnStart.getText()=="Continue"){
						btnStart.setText("Pause");
					}
				}

			}
		});// fin boton start

		
		btnStop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Boton Stop
				cronometro.stop();
				btnStart.setText("Start");
				contnue = "inactive";
			}
		});// fin boton stop
	}

}

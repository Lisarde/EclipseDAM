package com.dam.asynctaskprogreso;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainProgreso extends Activity {
	private EditText entrada;
	private TextView salida;

	class MiTarea extends AsyncTask<Integer, Integer, Integer> {
		private ProgressDialog progreso;

		@Override
		protected void onPreExecute() {
			progreso = new ProgressDialog(MainProgreso.this);
			progreso.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			progreso.setMessage("Subiendo Archivo...");
			progreso.setCancelable(true);
			progreso.setMax(100);
			progreso.setProgress(0);
			progreso.show();

			progreso.setOnCancelListener(new OnCancelListener() {

				@Override
				public void onCancel(DialogInterface dialog) {
					MiTarea.this.cancel(true);
				}
			});
		}
		@Override
		protected Integer doInBackground(Integer... n) {
			int res = 1;
			// aqui iria la carga del archivo en background pero no hay que
			// hacerla es un ejemplo.
			for (int i = 1; i <= 9 && !isCancelled(); i++) {
				res *= i;
				SystemClock.sleep(1000);
				publishProgress(i * 100 / 9);
			} //el bucle calcula lo que tardara la barra de progreso o circulo de carga.

			return res;
		}

		@Override
		protected void onProgressUpdate(Integer... porc) {
			progreso.setProgress(porc[0]);
		}

		@Override
		protected void onPostExecute(Integer res) {
			progreso.dismiss();
			salida.append("Archivo " + entrada.getText().toString()
					+ " Subido !!!");
		}

		@Override
		protected void onCancelled() {

			salida.append("Subida de archivo " + entrada.getText().toString()
					+ " Cancelada\n\n por favor intentelo en unos minutos.");

		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main_progreso);

		entrada = (EditText) findViewById(R.id.entrada);

		salida = (TextView) findViewById(R.id.salida);

	}

	public void subirArchivo(View view) {

		salida.setText("");// limpia antes de escribir uno nuevo

		MiTarea tarea = new MiTarea();

		tarea.execute();

	}



}
package com.dam.factoriahilos;

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

public class MainActivityFactorial extends Activity {

	private EditText entrada;
	private TextView salida;

	class MiTarea extends AsyncTask<Integer, Integer, Integer> {
		private ProgressDialog progreso;

		@Override
		protected void onPreExecute() {
			progreso = new ProgressDialog(MainActivityFactorial.this);
			progreso.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			progreso.setMessage("Calculando...");
			progreso.setCancelable(true);
			progreso.setMax(100);
			progreso.setProgress(0);
			progreso.show();

			
			progreso.setOnCancelListener(new OnCancelListener() {

		           @Override public void onCancel(DialogInterface dialog) {

		               MiTarea.this.cancel(true);

		           }

		       });
		}

		@Override
		protected Integer doInBackground(Integer... n) {

			int res = 1;

			for (int i = 1; i <= n[0] && !isCancelled(); i++) {
				res *= i;
				SystemClock.sleep(1000);
				publishProgress(i * 100 / n[0]);
			}
			return res;
		}

		@Override
		protected void onProgressUpdate(Integer... porc) {
			progreso.setProgress(porc[0]);
		}

		@Override
		protected void onPostExecute(Integer res) {
			progreso.dismiss();
			salida.append(res + "\n");
		}
		
		@Override protected void onCancelled() {

            salida.append("cancelado\n");

      }
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main_activity_factorial);

		entrada = (EditText) findViewById(R.id.entrada);

		salida = (TextView) findViewById(R.id.salida);

	}

	public void calcularOperacion(View view) {

		int n = Integer.parseInt(entrada.getText().toString());
		salida.setText("");//limpia antes de escribir uno nuevo
		salida.append(n + "! = ");

		MiThread thread = new MiThread(n);

		thread.start();

	}
/*
	public int factorial(int n) {

		int res = 1;

		for (int i = 1; i <= n; i++) {

			res *= i;

			//SystemClock.sleep(1000);

		}

		return res;

	}
*/
	// nuevo hilo
	class MiThread extends Thread {

		private int n, res;/* ,res2,res3,res4,res5; */

		public MiThread(int n) {

			this.n = n;

		}

		@Override
		public void run() {

			//res = factorial(n);
			/*
			 * res2 = factorial(n-1); res3 = factorial(n-2); res4 =
			 * factorial(n-3); res5 = factorial(n-4);
			 */

			runOnUiThread(new Runnable() {

				@Override
				public void run() {

					//salida.append(res + "\n");
					
					MiTarea tarea = new MiTarea();

		             tarea.execute(n);
					
				}

			});

		}

	}
	// fin nuevo hilo
}
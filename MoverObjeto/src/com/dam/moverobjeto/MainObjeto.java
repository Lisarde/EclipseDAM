package com.dam.moverobjeto;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainObjeto extends Activity {

	ImageView imageView;
	RelativeLayout.LayoutParams mParams; 
	 int screenHeight;
	 int screenWidth;
	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_objeto);

		imageView = (ImageView) findViewById(R.id.imageView1);
		mParams =  (RelativeLayout.LayoutParams) imageView.getLayoutParams();
		 
		
		//Sacar tamaño pantalla
		Rect rect = new Rect(); 
        Window win = getWindow();  // Get the Window
        win.getDecorView().getWindowVisibleDisplayFrame(rect); 
        // Get the height of Status Bar 
        int statusBarHeight = rect.top; 
        // Get the height occupied by the decoration contents 
        int contentViewTop = win.findViewById(Window.ID_ANDROID_CONTENT).getTop(); 
        // Calculate titleBarHeight by deducting statusBarHeight from contentViewTop  
        int titleBarHeight = contentViewTop - statusBarHeight; 

	     DisplayMetrics metrics = new DisplayMetrics();  
	     getWindowManager().getDefaultDisplay().getMetrics(metrics);   
	     screenHeight = metrics.heightPixels-titleBarHeight-120;//saca la Y de la pantalla entera
	     screenWidth= metrics.widthPixels; // saca la X de la pantalla entera
	     
	}
	

	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub	
		
		switch (keyCode) {
		
		case KeyEvent.KEYCODE_W:	
			if (mParams.topMargin>0){
			mParams.topMargin = mParams.topMargin - 10;
			imageView.setLayoutParams(mParams);
			}
			return true;
			
		case KeyEvent.KEYCODE_S:
			if (mParams.topMargin <= screenHeight-imageView.getHeight()){
			mParams.topMargin = mParams.topMargin + 10;
			imageView.setLayoutParams(mParams);
			}
			
			return true;
			
		case KeyEvent.KEYCODE_A:
			if (mParams.leftMargin>0){
			mParams.leftMargin = mParams.leftMargin - 10;
			imageView.setLayoutParams(mParams);
			}
			return true;
			
		case KeyEvent.KEYCODE_D:
			if (mParams.leftMargin<screenWidth-imageView.getWidth()-10/*(10 del borde de la pantalla)*/){
			mParams.leftMargin = mParams.leftMargin + 10;
			imageView.setLayoutParams(mParams);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	public boolean onTouchEvent(MotionEvent event) {
		int eid = event.getAction();

		switch (eid) {

		case MotionEvent.ACTION_MOVE:
			// se mueve cuando arrastras (drag and drop)
			int x = (int) event.getRawX();
			int y = (int) event.getRawY();
			mParams.leftMargin = x - 35;
			mParams.topMargin = y - 120;
			imageView.setLayoutParams(mParams);
			break;

		case MotionEvent.ACTION_UP:
			// Se mueve cuando pinchas
			int x2 = (int) event.getRawX();
			int y2 = (int) event.getRawY() - 120;

			if (x2 < imageView.getLeft()) {
				mParams.leftMargin = mParams.leftMargin - 10;
			}
			if (x2 > imageView.getRight()) {
				mParams.leftMargin = mParams.leftMargin + 10;
			}
			if (y2 < imageView.getTop()) {
				mParams.topMargin = mParams.topMargin - 10;
			}
			if (y2 > imageView.getTop()) {
				mParams.topMargin = mParams.topMargin + 10;
			}
			imageView.setLayoutParams(mParams);
			break;
		}
		return true;
	}

}
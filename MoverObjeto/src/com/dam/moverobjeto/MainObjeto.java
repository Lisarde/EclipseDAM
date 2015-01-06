package com.dam.moverobjeto;

import android.os.Bundle;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainObjeto extends Activity {

    ImageView imageView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_objeto);
        imageView = (ImageView)findViewById(R.id.imageView1);

        imageView.setOnTouchListener(new OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                int eid = event.getAction();
                switch (eid) {
                case MotionEvent.ACTION_MOVE:

                    RelativeLayout.LayoutParams mParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                    int x = (int) event.getRawX();
                    int y = (int) event.getRawY();
                    mParams.leftMargin = x-50;
                    mParams.topMargin = y-50;
                    imageView.setLayoutParams(mParams);


                    break;

                default:
                    break;
                }
                return true;
            }
        });
    }




}
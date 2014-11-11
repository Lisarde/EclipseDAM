package com.dam.actionbar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class CanvasView extends View {
	private int heightCenter;
	private int widthCenter;

	public CanvasView(Context context) {
		super(context);
		heightCenter = 0;
		widthCenter = 0;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		heightCenter = canvas.getHeight() / 2;
		widthCenter = canvas.getWidth() / 2;
	}

	public int getHeightCenter() {
		return heightCenter;
	}

	public int getWidthCenter() {
		return widthCenter;
	}
}

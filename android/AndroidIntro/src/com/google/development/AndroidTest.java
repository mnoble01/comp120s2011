package com.google.development;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class AndroidTest extends Activity
{
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);
		tv.setText("Hey, this works!");
		tv.setTextSize(1000);
		setContentView(tv);
	}
}

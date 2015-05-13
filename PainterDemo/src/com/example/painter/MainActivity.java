package com.example.painter;

import android.app.Activity;
import android.os.Bundle;

//import android.widget.FrameLayout;

public class MainActivity extends Activity
{

	Draw draw;
//	FrameLayout fl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//新建一个Draw类
		draw = new Draw(MainActivity.this);
		//将界面设为Draw类
		setContentView(draw);
		
		/*若要在特定的FrameLayout中显示，只需改为下述语句即可*/
//		setContentView(R.layout.activity_main); //设置显示的View
//		fl = (FrameLayout) findViewById(R.id.FrameLayout1); //绑定FrameLayout
//		fl.addView(draw); //添加Draw类
	}
}

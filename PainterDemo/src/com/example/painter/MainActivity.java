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
		//�½�һ��Draw��
		draw = new Draw(MainActivity.this);
		//��������ΪDraw��
		setContentView(draw);
		
		/*��Ҫ���ض���FrameLayout����ʾ��ֻ���Ϊ������伴��*/
//		setContentView(R.layout.activity_main); //������ʾ��View
//		fl = (FrameLayout) findViewById(R.id.FrameLayout1); //��FrameLayout
//		fl.addView(draw); //���Draw��
	}
}

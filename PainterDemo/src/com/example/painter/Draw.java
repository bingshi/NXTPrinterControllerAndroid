package com.example.painter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Draw extends View implements View.OnClickListener
{
	
	private float start_x;//声明起点坐标x
	private float start_y;//声明起点坐标y
	private float end_x;//声明终点坐标x
	private float end_y;//声明终点坐标y
	private Canvas canvas;//声明画笔
	private Paint paint;//声明画布
	private Bitmap bitmap;//声明位图

	public Draw(Context context)
	{
		super(context);
		// TODO 自动生成的构造函数存根
		paint = new Paint(Paint.DITHER_FLAG);//创建一个画笔
		bitmap = Bitmap.createBitmap(320, 480, Bitmap.Config.RGB_565);//设置位图的宽高
		canvas = new Canvas(bitmap);
		canvas.drawColor(Color.WHITE);
		
		paint.setStyle(Paint.Style.STROKE);//设置非填充
		paint.setStrokeWidth(5);//笔宽5像素
		paint.setColor(Color.RED);//设置为红笔
		paint.setAntiAlias(false);//锯齿不显示
		//paint.setDither(true);//设置图像抖动处理
		paint.setStrokeJoin(Paint.Join.ROUND);//设置图像的结合方式
		paint.setStrokeCap(Paint.Cap.ROUND);//设置画笔为圆形样式
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		// TODO 自动生成的方法存根
		super.onDraw(canvas);
		canvas.drawBitmap(bitmap, 0, 0, paint);
//		canvas.drawPath(path, paint);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		// TODO 自动生成的方法存根
		
		//检测手指落下的动作
		if(event.getAction() == MotionEvent.ACTION_DOWN)
		{
			start_x = event.getX();//获取手指落下的x坐标
			start_y = event.getY();//获取手指落下的y坐标
			canvas.drawPoint(start_x, start_y, paint);//在画布上画点

		}

		//检测手指移动的动作
		if(event.getAction() == MotionEvent.ACTION_MOVE)
		{			
			end_x = event.getX();//获取手指移动的x坐标
			end_y = event.getY();//获取手指移动的y坐标
			canvas.drawLine(start_x, start_y, end_x, end_y, paint);//在画布上画线
			start_x = end_x;//将上一个终止点的x坐标赋值给起始点的x坐标
			start_y = end_y;//将上一个终止点的y坐标赋值给起始点的y坐标
		}		

		invalidate();//使绘画动作生效
					
		return true;
	}
	
	@Override
	public void onClick(View v)
	{
		// TODO 自动生成的方法存根
		
	}

}

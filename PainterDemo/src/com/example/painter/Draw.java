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
	
	private float start_x;//�����������x
	private float start_y;//�����������y
	private float end_x;//�����յ�����x
	private float end_y;//�����յ�����y
	private Canvas canvas;//��������
	private Paint paint;//��������
	private Bitmap bitmap;//����λͼ

	public Draw(Context context)
	{
		super(context);
		// TODO �Զ����ɵĹ��캯�����
		paint = new Paint(Paint.DITHER_FLAG);//����һ������
		bitmap = Bitmap.createBitmap(320, 480, Bitmap.Config.RGB_565);//����λͼ�Ŀ��
		canvas = new Canvas(bitmap);
		canvas.drawColor(Color.WHITE);
		
		paint.setStyle(Paint.Style.STROKE);//���÷����
		paint.setStrokeWidth(5);//�ʿ�5����
		paint.setColor(Color.RED);//����Ϊ���
		paint.setAntiAlias(false);//��ݲ���ʾ
		//paint.setDither(true);//����ͼ�񶶶�����
		paint.setStrokeJoin(Paint.Join.ROUND);//����ͼ��Ľ�Ϸ�ʽ
		paint.setStrokeCap(Paint.Cap.ROUND);//���û���ΪԲ����ʽ
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		// TODO �Զ����ɵķ������
		super.onDraw(canvas);
		canvas.drawBitmap(bitmap, 0, 0, paint);
//		canvas.drawPath(path, paint);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		// TODO �Զ����ɵķ������
		
		//�����ָ���µĶ���
		if(event.getAction() == MotionEvent.ACTION_DOWN)
		{
			start_x = event.getX();//��ȡ��ָ���µ�x����
			start_y = event.getY();//��ȡ��ָ���µ�y����
			canvas.drawPoint(start_x, start_y, paint);//�ڻ����ϻ���

		}

		//�����ָ�ƶ��Ķ���
		if(event.getAction() == MotionEvent.ACTION_MOVE)
		{			
			end_x = event.getX();//��ȡ��ָ�ƶ���x����
			end_y = event.getY();//��ȡ��ָ�ƶ���y����
			canvas.drawLine(start_x, start_y, end_x, end_y, paint);//�ڻ����ϻ���
			start_x = end_x;//����һ����ֹ���x���긳ֵ����ʼ���x����
			start_y = end_y;//����һ����ֹ���y���긳ֵ����ʼ���y����
		}		

		invalidate();//ʹ�滭������Ч
					
		return true;
	}
	
	@Override
	public void onClick(View v)
	{
		// TODO �Զ����ɵķ������
		
	}

}

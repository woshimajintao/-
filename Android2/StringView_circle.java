package com.Goowin.stringapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;

public class StringView extends View {
	private final int NUM = 20; // Ҫ��ʾ���ַ����ĸ���
	
	private Point[] point; // �洢���ַ�����ʼλ�õ�����
	private int cxView; // ���
	private int cyView; // �߶�
	
	// ���캯��
	public StringView (Context context) {
		super(context);
		point = new Point[NUM]; // ���䴴��NUM������Point��������point
		
		setBackgroundColor(Color.WHITE); // ������ͼ������ɫΪ��ɫ
	}
	
	
	protected void onDraw (Canvas canvas) {
		Paint paint = new Paint(); // ����ָ�����ƶ��󱳾�����ȫ���й����Ե�Paint����
		
		cxView = getWidth(); // ��ȡview�Ŀ��
		cyView = getHeight(); // ��ȡview�ĸ߶�
		
		paint.setAntiAlias(true); // ��canvas�Ŀ���ݣ�������⻬Ч��������
		DisplayString(canvas, paint); // ��ʾ�ַ���
		
		super.onDraw(canvas);
	}
	
	private void DisplayString (Canvas canvas, Paint paint) {
		String str = "15281080�ľ���";
		
		calcPos(); // ������ַ����ĺ�����ʼ����
		
		paint.setTextSize(20); // �����ַ����������С
		for (int i = 0; i != point.length; ++i) {
			paint.setColor(Color.rgb(200 - (i * 10), 0, 50 + (i * 10))); // �����ַ�������ɫ
			
			canvas.drawText (str, point[i].x, point[i].y, paint); // �����ַ���
		}
	}
	
	private void calcPos () {
		for (int i = 0; i != NUM; ++i) {
			point[i] = new Point(); // ��ʼ��
			point[i].x = i * cxView /(NUM * 2); // x��0~cxView/2�ķ�Χ�ڱ仯��ʹ��(i * cxView /(NUM * 2))ʹ���0��cxView/2��������
			point[i].y = (int) (cyView / 2 - Math.sqrt((int)(point[i].x * cxView - point[i].x * point[i].x)));; // Բ�ķ���Ϊ(x - cxView / 2) * (x - cxView / 2) + (y - cyView / 2) * (y - cyView / 2) = cxView * cxView / 4�����y = cyView / 2 - Math.sqrt((int)(point[i].x * cxView - point[i].x * point[i].x))
		}
	}
}

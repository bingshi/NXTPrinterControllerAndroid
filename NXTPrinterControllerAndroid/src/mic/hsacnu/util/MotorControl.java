package mic.hsacnu.util;

import mic.hsacnu.util.NXTControl;

public class MotorControl {
	
	public static int Motor2Integer(String motor){
		switch (motor.charAt(0)) {
		case 'A':
			return 0;
		case 'B':
			return 1;
		case 'C':
			return 2;
		default:
			return -1;
		}
	}

	public static void start_motor11(int left, int right){
		NXTControl.changeMotorSpeed(left, 100);
	}
	
	public static void start_motor12(int left, int right){
		NXTControl.changeMotorSpeed(left, -100);
	}
	
	public static void start_motor21(int left, int right){
		NXTControl.changeMotorSpeed(right, 100);
	}
	
	public static void start_motor22(int left, int right){
		NXTControl.changeMotorSpeed(right, -100);
	}
	
	public static void stop_motor11(final int left, int right){
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				NXTControl.changeMotorSpeed(left, -100);
//				try {
//					Thread.sleep(30);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				NXTControl.changeMotorSpeed(left, 0);
//			}
//		}).start();
		NXTControl.changeMotorSpeed(left, 0);
	}
	
	public static void stop_motor12(final int left, int right){
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				NXTControl.changeMotorSpeed(left, 100);
//				try {
//					Thread.sleep(30);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				NXTControl.changeMotorSpeed(left, 0);
//			}
//		}).start();
		NXTControl.changeMotorSpeed(left, 0);
	}
	
	public static void stop_motor21(int left, final int right){
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				NXTControl.changeMotorSpeed(right, -100);
//				try {
//					Thread.sleep(30);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				NXTControl.changeMotorSpeed(right, 0);
//			}
//		}).start();
		NXTControl.changeMotorSpeed(right, 0);
	}
	
	public static void stop_motor22(int left, final int right){
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				NXTControl.changeMotorSpeed(right, 100);
//				try {
//					Thread.sleep(30);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				NXTControl.changeMotorSpeed(right, 0);
//			}
//		}).start();
		NXTControl.changeMotorSpeed(right, 0);
	}
}

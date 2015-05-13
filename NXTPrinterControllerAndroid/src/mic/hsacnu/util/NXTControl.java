package mic.hsacnu.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import mic.hsacnu.data.GlobalData;
import mic.hsacnu.util.SensorControl;
import android.R.integer;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.bluetooth.BluetoothClass.Device;
import android.content.Context;
import android.widget.Toast;

public class NXTControl {

	public static OutputStream nxtos;
	public static InputStream nxtis;
	public static BluetoothSocket bt_socket=null;
	
	public static class ReceiveMessageListenerThread extends Thread{

		public boolean do_flag=false;
		
		public ReceiveMessageListenerThread() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public void run() {
			while(true){
				if(do_flag==true){
					try {
						ArrayList<Byte> temp;
						byte[] message=receiveMessage();
						switch (message[1]) {
						case 0x07:
							SensorControl.analyzeSensorData(message);
							
							temp=new ArrayList<Byte>();
							for(int i=0;i<message.length;++i){
								temp.add(new Byte(message[i]));
							}
							GlobalData.another_messages.addAll(temp);
							break;

						default:
							temp=new ArrayList<Byte>();
							for(int i=0;i<message.length;++i){
								temp.add(new Byte(message[i]));
							}
							GlobalData.another_messages.addAll(temp);
							break;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static ReceiveMessageListenerThread messageListener=new ReceiveMessageListenerThread();
	
	static{
		messageListener.start();
	}
	
	public static void reinit(BluetoothDevice current_device, Context c){
		Method m;
		try {
			m=current_device.getClass().getMethod("createRfcommSocket", new Class[]{int.class});
			bt_socket=(BluetoothSocket) m.invoke(current_device, GlobalData.bluetooth_port);
			bt_socket.connect();
			nxtis=bt_socket.getInputStream();
			nxtos=bt_socket.getOutputStream();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(c, "NXTBC can't connect the NXT device, but you can try the control.", Toast.LENGTH_LONG).show();
		}
	}
	
//	public static void stop(){
//		try {
//			bt_socket.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public static void sendMessage(byte[] message){
        int messageLength = message.length;
        try {
        	nxtos.write(messageLength);
            nxtos.write(messageLength >> 8);
            nxtos.write(message, 0, message.length);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
	
	public static byte[] receiveMessage() throws IOException {
        int length = nxtis.read();
        length = (nxtis.read() << 8) + length;
        byte[] returnMessage = new byte[length];
        nxtis.read(returnMessage);
        return returnMessage;
    }    
	
	public static void doBeep(int frequency, int duration) {
        byte[] message = LCPMessage.getBeepMessage(frequency, duration);
        sendMessage(message);
    }
    
	public static void doAction(int actionNr) {
        byte[] message = LCPMessage.getActionMessage(actionNr);
        sendMessage(message);
    }

	public static void startProgram(String programName) {
        byte[] message = LCPMessage.getStartProgramMessage(programName);
        sendMessage(message);
    }

	public static void stopProgram() {
        byte[] message = LCPMessage.getStopProgramMessage();
        sendMessage(message);
    }
    
	public static void getProgramName() {
        byte[] message = LCPMessage.getProgramNameMessage();
        sendMessage(message);
    }
    
	public static void changeMotorSpeed(int motor, int speed) {
        if (speed > 100)
            speed = 100;

        else if (speed < -100)
            speed = -100;

        byte[] message = LCPMessage.getMotorMessage(motor, speed);
        sendMessage(message);
    }

	public static void rotateTo(int motor, int end) {
        byte[] message = LCPMessage.getMotorMessage(motor, -100, end);
        sendMessage(message);
    }

	public static void reset(int motor) {
        byte[] message = LCPMessage.getResetMessage(motor);
        sendMessage(message);
    }

	public static void readMotorState(int motor) {
        byte[] message = LCPMessage.getOutputStateMessage(motor);
        sendMessage(message);
    }

	public static void getFirmwareVersion() {
        byte[] message = LCPMessage.getFirmwareVersionMessage();
        sendMessage(message);
    }

	public static void findFiles(boolean findFirst, int handle) {
        byte[] message = LCPMessage.getFindFilesMessage(findFirst, handle, "*.*");
        sendMessage(message);
    }
	
	public static void setSenseModeMessage(int port, int type, int mode){
		byte[] message=LCPMessage.getSetSenseModeMessage(port, type, mode);
		sendMessage(message);
	}
	
	public static void requestSensorValue(int port){
		byte[] message=LCPMessage.getRequestSensorValueMessage(port);
		sendMessage(message);
	}
}

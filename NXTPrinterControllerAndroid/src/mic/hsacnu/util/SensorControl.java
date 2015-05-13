package mic.hsacnu.util;

import android.R.integer;
import mic.hsacnu.util.SensorModel;

public class SensorControl {

	public static SensorModel current_sensor_values[];
	
	static{
		current_sensor_values=new SensorModel[4];
		for(int i=0;i<4;++i){
			current_sensor_values[i]=new SensorModel();
		}
	}
	
	public static SensorModel analyzeSensorData(byte[] message){
		SensorModel result=new SensorModel();
		////数据转换 start
		result.port=message[3];
		result.valid=message[4]==0?false:true;
		result.calid=message[5]==0?false:true;
		result.type=message[6];
		result.mode=message[7];
		result.raw=(message[9]<<8)+message[8];
		result.normal=(message[11]<<8)+message[10];
		result.scale=(message[13]<<8)+message[12];
		result.cali=(message[15]<<8)+message[14];
		////数据转换 end
		current_sensor_values[result.port]=result;
		return result;
	}
}

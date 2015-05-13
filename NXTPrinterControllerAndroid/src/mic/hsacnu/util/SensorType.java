package mic.hsacnu.util;

import java.util.ArrayList;

import mic.hsacnu.util.SensorTypeModel;

public class SensorType {

	public static final int NO_SENSOR=0x00;
    public static final int SWITCH=0x01;
    public static final int TEMPERATURE=0x02;
    public static final int REFLECTION=0x03;
    public static final int ANGLE=0x04;
    public static final int LIGHT_ACTIVE=0x05;
    public static final int LIGHT_INACTIVE=0x06;
    public static final int SOUND_DB=0x07;
    public static final int SOUND_DBA=0x08;
    public static final int CUSTOM=0x09;
    public static final int LOWSPEED=0x0A;
    public static final int LOWSPEED_9V=0x0B;
    public static final int NO_OF_SENSOR_TYPES=0x0C;
    
    public static final int RAWMODE=0x00;
    public static final int BOOLEANMODE=0x20;
    public static final int TRANSITIONCNTMODE=0x40;
    public static final int PERIODCOUNTERMODE=0x60;
    public static final int PCTFULLSCALEMODE=0x80;
    public static final int CELSIUSMODE=0xA0;
    public static final int FAHRENHEITMODE=0xC0;
    public static final int ANGLESTEPSMODE=0xE0;
    public static final int SLOPEMASK=0x1F;
    public static final int MODEMASK=0xE0;
    
    public static ArrayList<SensorTypeModel> typeList;
    static{
    	typeList=new ArrayList<SensorTypeModel>();
    	SensorTypeModel stmt;
    	//此部分代码可以被扩展
    	stmt=new SensorTypeModel();
    	stmt.type="NO_SENSOR";
    	stmt.mode="RAWMODE";
    	stmt.type_value=0x00;
    	stmt.mode_value=0x00;
    	typeList.add(stmt);
    	stmt=new SensorTypeModel();
    	stmt.type="SWITCH";
    	stmt.mode="BOOLEANMODE";
    	stmt.type_value=0x01;
    	stmt.mode_value=0x20;
    	typeList.add(stmt);
    	stmt=new SensorTypeModel();
    	stmt.type="TEMPERATURE";
    	stmt.mode="TRANSITIONCNTMODE";
    	stmt.type_value=0x02;
    	stmt.mode_value=0x40;
    	typeList.add(stmt);
    	stmt=new SensorTypeModel();
    	stmt.type="REFLECTION";
    	stmt.mode="PERIODCOUNTERMODE";
    	stmt.type_value=0x03;
    	stmt.mode_value=0x60;
    	typeList.add(stmt);
    	stmt=new SensorTypeModel();
    	stmt.type="ANGLE";
    	stmt.mode="PCTFULLSCALEMODE";
    	stmt.type_value=0x04;
    	stmt.mode_value=0x80;
    	typeList.add(stmt);
    	stmt=new SensorTypeModel();
    	stmt.type="LIGHT_ACTIVE";
    	stmt.mode="CELSIUSMODE";
    	stmt.type_value=0x05;
    	stmt.mode_value=0xA0;
    	typeList.add(stmt);
    	stmt=new SensorTypeModel();
    	stmt.type="LIGHT_INACTIVE";
    	stmt.mode="FAHRENHEIMODE";
    	stmt.type_value=0x06;
    	stmt.mode_value=0xC0;
    	typeList.add(stmt);
    	stmt=new SensorTypeModel();
    	stmt.type="SOUND_DB";
    	stmt.mode="ANGLESTEPSMODE";
    	stmt.type_value=0x07;
    	stmt.mode_value=0xE0;
    	typeList.add(stmt);
    	stmt=new SensorTypeModel();
    	stmt.type="SOUND_DBA";
    	stmt.mode="SLOPEMASK";
    	stmt.type_value=0x08;
    	stmt.mode_value=0x1F;
    	typeList.add(stmt);
    	stmt=new SensorTypeModel();
    	stmt.type="CUSTOM";
    	stmt.mode="MODEMASK";
    	stmt.type_value=0x09;
    	stmt.mode_value=0xE0;
    	typeList.add(stmt);
    	stmt=new SensorTypeModel();
    	stmt.type="LOWSPEED";
    	stmt.mode="RAWMODE";
    	stmt.type_value=0x0A;
    	stmt.mode_value=0x00;
    	typeList.add(stmt);
    	stmt=new SensorTypeModel();
    	stmt.type="LOWSPEED_9V";
    	stmt.mode="BOOLEANMODE";
    	stmt.type_value=0x0B;
    	stmt.mode_value=0x20;
    	typeList.add(stmt);
    	stmt=new SensorTypeModel();
    	stmt.type="NO_OF_SENSOR_TYPE";
    	stmt.mode="TRANSITIONCNTMODE";
    	stmt.type_value=0x0C;
    	stmt.mode_value=0x40;
    	typeList.add(stmt);
    }
}

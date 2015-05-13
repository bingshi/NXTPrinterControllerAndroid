package mic.hsacnu.data;

import java.util.ArrayList;
import java.util.Set;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.SharedPreferences;

public class GlobalData {

	public static BluetoothAdapter bt_adapter;
	public static Set<BluetoothDevice> nxt_list;
	public static BluetoothDevice current_printer=null;
	public static int bluetooth_port=1;
	public static ArrayList<Byte> another_messages=new ArrayList<Byte>();
	public static SharedPreferences sp;
}

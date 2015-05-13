package mic.hsacnu.nxtprintercontrollerandroid;

import java.util.Set;

import mic.hsacnu.data.GlobalData;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class FunctionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_function);
		setTitle("Choose Functions");
		GlobalData.bt_adapter=BluetoothAdapter.getDefaultAdapter();
		GlobalData.nxt_list=GlobalData.bt_adapter.getBondedDevices();
		SharedPreferences sp=getSharedPreferences("images", MODE_PRIVATE);
	}
	
	public void bluetooth_control(View source){
		Intent intent=new Intent(this, BluetoothControlActivity.class);
		startActivity(intent);
	}
	
	public void choose_printer(View source){
		Intent intent=new Intent(this, ChooseDeviceActivity.class);
		startActivity(intent);
	}
	
	public void manage_image(View source){
		
	}
	
	public void send_jobs(View source){
		
	}
}

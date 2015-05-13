package mic.hsacnu.nxtprintercontrollerandroid;

import mic.hsacnu.data.GlobalData;
import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class BluetoothControlActivity extends Activity {

	private TextView bluetooth_status;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bluetooth_control);
		setTitle("Control Bluttooth");
		bluetooth_status=(TextView) findViewById(R.id.bluetooth_status);
		String status;
		if(GlobalData.bt_adapter.isEnabled()==false){
			status="Your Bluetooth Device is Disable! Please Open It by Pressing the Button following.";
		}else{
			status="Your Bluetooth Device is Enable! Just press the Back Button to Use your NXTPrinter!";
		}
		bluetooth_status.setText(status);
	}
	
	public void open_bluetooth(View source){
		if(GlobalData.bt_adapter.isEnabled()==false){
			Intent enable_bluetooth_dialog = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
	        startActivity(enable_bluetooth_dialog);
		}else{
			AlertDialog.Builder adb=new AlertDialog.Builder(this);
			adb.setTitle("Message");
			adb.setMessage("Your Bluetooth Device is Enable! Just press the Button to Use your NXTPrinter!");
			adb.setPositiveButton("Okay", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					BluetoothControlActivity.this.finish();
				}
			});
			adb.show();
		}
	}
}

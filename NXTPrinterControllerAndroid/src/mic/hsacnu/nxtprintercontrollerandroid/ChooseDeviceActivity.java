package mic.hsacnu.nxtprintercontrollerandroid;

import java.util.ArrayList;
import java.util.Iterator;

import mic.hsacnu.data.GlobalData;
import mic.hsacnu.data.NXTPrinterAdapter;
import android.R.integer;
import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ChooseDeviceActivity extends Activity {

	private ListView device_list;
	private NXTPrinterAdapter adapter;
	private ArrayList<BluetoothDevice> temp=new ArrayList<BluetoothDevice>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_device);
		setTitle("Choose NXTPrinter");
		device_list=(ListView) findViewById(R.id.device_list);
		Iterator<BluetoothDevice> iter=GlobalData.nxt_list.iterator();
		for(int i=0;i<GlobalData.nxt_list.size();++i){
			temp.add(iter.next());
		}
		adapter=new NXTPrinterAdapter(this, R.layout.nxtprinter_list_item, temp);
		device_list.setAdapter(adapter);
		device_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				GlobalData.current_printer=temp.get(arg2);
				finish();
			}
		});
	}
	
	public void refresh(View source){
		temp.clear();
		GlobalData.nxt_list=GlobalData.bt_adapter.getBondedDevices();
		Iterator<BluetoothDevice> iter=GlobalData.nxt_list.iterator();
		for(int i=0;i<GlobalData.nxt_list.size();++i){
			temp.add(iter.next());
		}
		adapter.notifyDataSetChanged();
	}
}

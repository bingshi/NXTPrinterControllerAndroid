package mic.hsacnu.data;

import java.util.List;

import mic.hsacnu.nxtprintercontrollerandroid.R;
import android.R.integer;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NXTPrinterAdapter extends ArrayAdapter<BluetoothDevice> {

	int resourceId;
	
	public NXTPrinterAdapter(Context context, int resource,
			List<BluetoothDevice> objects) {
		super(context, resource, objects);
		resourceId=resource;
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View result=LayoutInflater.from(getContext()).inflate(resourceId, null);
		BluetoothDevice temp_data=getItem(position);
		TextView name=(TextView) result.findViewById(R.id.nxtprinter_name);
		TextView mac=(TextView) result.findViewById(R.id.nxtprinter_mac);
		name.setText(temp_data.getName());
		mac.setText(temp_data.getAddress());
		return result;
	}
}

package mic.hsacnu.data;

import java.util.List;

import mic.hsacnu.nxtprintercontrollerandroid.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ImageFileAdapter extends ArrayAdapter<ImageFileModel>{

	public ImageFileAdapter(Context context, int resource,
			List<ImageFileModel> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View result=LayoutInflater.from(getContext()).inflate(R.layout.image_file_list_item, null);
		String filename=getItem(position).filename;
		((TextView) result.findViewById(R.id.image_file_name)).setText(filename);
		return result;
	}
}

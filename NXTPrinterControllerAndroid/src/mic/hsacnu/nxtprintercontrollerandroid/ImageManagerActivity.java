package mic.hsacnu.nxtprintercontrollerandroid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import mic.hsacnu.data.GlobalData;
import mic.hsacnu.data.ImageFileAdapter;
import mic.hsacnu.data.ImageFileModel;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class ImageManagerActivity extends Activity {

	private ListView image_list;
	private ImageFileAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_manager);
		setTitle("Manage Images");
		SharedPreferences sp=getSharedPreferences("image_filenames", MODE_PRIVATE);
		GlobalData.image_file_set=sp.getStringSet("image_filenames", null);
		GlobalData.images=new ArrayList<ImageFileModel>();
		if(GlobalData.image_file_set!=null){
			Iterator<String> iter=GlobalData.image_file_set.iterator();
			while(iter.hasNext()==true){
				String temp_filename=iter.next();
				ImageFileModel itemp=new ImageFileModel();
				itemp.filename=temp_filename;
				GlobalData.images.add(itemp);
			}
			adapter=new ImageFileAdapter(this, R.layout.image_file_list_item, GlobalData.images);
		}
	}
}

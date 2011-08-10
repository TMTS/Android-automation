package com.taobao.tmts.framework.app;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ListViewActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.listview_layout);

		ListView listview = (ListView) findViewById(R.id.my_listview);
		
		ArrayList<HashMap<String, Object>> listitem = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 100; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("itemimage", R.drawable.icon);
			map.put("itemTitle", "Item" + i);
			map.put("itemText", "Thank you!");
			listitem.add(map);
		}

		SimpleAdapter listitemAdapter = new SimpleAdapter(this, listitem,
				R.layout.listview_item_layout, new String[] { "itemimage",
						"itemTitle", "itemText" }, new int[] { R.id.ItemImage,
						R.id.ItemTitle, R.id.ItemText });

		listview.setAdapter(listitemAdapter);
		
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
			}

		});

		listview.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {

			@Override
			public void onCreateContextMenu(ContextMenu menu, View v,
					ContextMenuInfo menuInfo) {
				menu.setHeaderTitle("Hello");
				menu.add(0, 0, 0, "Item One");
				menu.add(0, 1, 0, "Item Two");

			}
		});
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 0:
			Toast.makeText(this, "Item One", Toast.LENGTH_SHORT).show();
			break;
			
		case 1:
			Toast.makeText(this, "Item Two", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
		return super.onContextItemSelected(item);
	}
}

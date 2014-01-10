package com.example.simpletodo;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class TodoActivity extends Activity {
	ArrayList<String> items;
	ArrayAdapter<String> itemsAdapter;
	ListView lvItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_todo);
		populateArrayItems();
		itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
		lvItems =  (ListView) findViewById(R.id.lvItems);
		lvItems.setAdapter(itemsAdapter);
		setupListViewListener();	
	}
	
	public void setupListViewListener() {
		lvItems.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View item,
					int pos, long id) {
			items.remove(pos);
			itemsAdapter.notifyDataSetChanged();
				return true;
			}
		});
	}
	
	private void populateArrayItems() {
		items = new ArrayList<String>();
		items.add("Get Milk");
		items.add("Take meds");
		items.add("Walk dog");
	} 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.todo, menu);
		return true;
	}
	public void addTodoItem(View v) {
		EditText etNewItem = (EditText) findViewById(R.id.etBasicTextBox);
		itemsAdapter.add(etNewItem.getText().toString());
		etNewItem.setText("");

	}

}

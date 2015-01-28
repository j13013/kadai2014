package com.example.database;

import java.util.Calendar;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.carender.R;

public class DatabaseActivity extends Activity {

	static SQLiteDatabase mydb;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_database);

		Button button2 = (Button)this.findViewById(R.id.modoru);
		view();
		button2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(com.example.database.DatabaseActivity.this, com.example.calendartest.MainActivity.class);
				startActivity(intent);
			}
		});

		Button button = (Button)this.findViewById(R.id.button01);
		view();
		button.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				add();
				view();
			}
		});
	}

		private void add() {
			EditText editText = (EditText)findViewById(R.id.editText01);
			DatabaseHelper dbHelper = new DatabaseHelper(this);
			SQLiteDatabase db = dbHelper.getWritableDatabase();
			String created = Calendar.getInstance().getTime().toString();
			String comment = editText.getText().toString();
			ContentValues values = new ContentValues();
			values.put("created", created);
			values.put("comment", comment);
				//Insert
			long rowID = db.insert("bbs", "", values);
			editText.setText("");
			if(rowID==-1){
				db.close();
				throw new SQLException("Failed to insert row");
			}db.close();

		}

	private void view() {
		DatabaseHelper hlpr = new	DatabaseHelper(getApplicationContext());
		mydb = hlpr.getWritableDatabase();
		ListView listView = (ListView)findViewById(R.id.listView01);
		try{
			Cursor cr = mydb.rawQuery("select*From bbs Order By id desc", null);
			cr.moveToFirst();
				if(cr.getCount()>0){
					Integer[] data = new Integer[cr.getCount()]; //Start
					ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
					for(int cnt =0;cnt<cr.getCount();cnt++){
						data[cnt] = cr.getInt(0);
						adapter.add("ID:"+cr.getString(0)+",\ncreated:"+cr.getString(1)+",\ncomment:" + cr.getString(2));
						cr.moveToNext();
						listView.setAdapter(adapter);
					}
				}else listView.setAdapter(null);
		}finally{
			mydb.close();
		}
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.database, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void onClick(View arg0) {
		Intent intent = new Intent(com.example.database.DatabaseActivity.this, com.example.database.DatabaseActivity.class);
		startActivity(intent);

	}
}

package com.developmentapps.womensafety;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

public class Verify extends Activity {
	Button button1,button2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_verify);
		button1=findViewById(R.id.button1);
		button2=findViewById(R.id.button2);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText source_no =findViewById(R.id.editText1);
				String str_source_no=source_no.getText().toString();
				SQLiteDatabase db;
				db=openOrCreateDatabase("NumDB", Context.MODE_PRIVATE, null);
				if(source_no.getText()!=null){

				db.execSQL("CREATE TABLE IF NOT EXISTS source(number VARCHAR);");
				db.execSQL("INSERT INTO source VALUES('"+str_source_no+"');");
				Toast.makeText(getApplicationContext(), str_source_no+" Successfully Saved",Toast.LENGTH_SHORT).show();
				db.close();
	}
		else{
			Toast.makeText(getApplicationContext(), "Enter Your Number.",Toast.LENGTH_SHORT).show();
					}
			}
		});
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i_back=new Intent(Verify.this,MainActivity.class);
				startActivity(i_back);
			}
		});
		//setupActionBar();
		
		
		
	}
	
	
	



	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	/*@TargetApi(Build.VERSION_CODES.KITKAT)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.verify, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


}

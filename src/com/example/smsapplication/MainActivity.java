package com.example.smsapplication;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button btnSend;
	EditText etPhoneNo;
	EditText etMsg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etPhoneNo = (EditText) findViewById(R.id.phno);		
		etMsg = (EditText) findViewById(R.id.smstxt);
		btnSend = (Button) findViewById(R.id.send);
		
		btnSend.setOnClickListener(new OnClickListener() {			 
			@Override
			public void onClick(View v) { 
			  String phoneNo = etPhoneNo.getText().toString();
			  String msg = etMsg.getText().toString(); 
			  try {
				  
				SmsManager smsManager = SmsManager.getDefault();
				smsManager.sendTextMessage(phoneNo, null, msg, null, null);				
				Toast.makeText(getApplicationContext(), "Message Sent",
							Toast.LENGTH_LONG).show();
			  } catch (Exception ex) {
				Toast.makeText(getApplicationContext(),
					ex.getMessage().toString(),
					Toast.LENGTH_LONG).show();
				ex.printStackTrace();
			  }
 
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}

package com.example.instant;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText e1,e2,e3;
	Button b;
	TextView t1,t2,t3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void maketask(View v)
	{
		//Toast.makeText(getApplicationContext(), "alarm is on",Toast.LENGTH_LONG).show();
		
		int hours=0,minutes=0,seconds=0;
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		e3=(EditText)findViewById(R.id.editText3);
		t1=(TextView)findViewById(R.id.textView1);
		t1.setTextColor(Color.parseColor("blue"));
		t2=(TextView)findViewById(R.id.textView2);
		t2.setTextColor(Color.parseColor("green"));
		t3=(TextView)findViewById(R.id.textView3);
		t3.setTextColor(Color.parseColor("red"));
		
	
		
		String s1=e1.getText().toString();
		String time[]=s1.split(":");
		 hours=Integer.parseInt(time[0]);
		 minutes=Integer.parseInt(time[1]);
		 seconds=Integer.parseInt(time[2]);
		
		
		hours=hours*60*60*1000;
		minutes=minutes*60*1000;
		seconds=seconds*1000;
		
		int total=hours+minutes+seconds;
		String num=e2.getText().toString();
		String msg=e3.getText().toString();
		
		Intent i=new Intent(this,Next.class);
		i.putExtra("n",num);
		i.putExtra("m",msg);
		PendingIntent pi=PendingIntent.getBroadcast(MainActivity.this,1,i,0);
		AlarmManager am=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
		am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+total, pi);
		Toast.makeText(getApplicationContext(), "alarm is on",Toast.LENGTH_LONG).show();
		
	}

}

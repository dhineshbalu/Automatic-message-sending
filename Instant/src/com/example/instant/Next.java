package com.example.instant;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.telephony.gsm.SmsManager;
import android.widget.Toast;

public class Next extends BroadcastReceiver
{
	 @Override
	    public void onReceive(Context context, Intent intent)
	    {
		
		String s1=intent.getStringExtra("n");
		String s2=intent.getStringExtra("m");
		
		
		 Toast.makeText(context,"ur message sended",Toast.LENGTH_LONG).show();
		 
		SmsManager sms=SmsManager.getDefault();
		sms.sendTextMessage(s1, null,s2, null,null);
	    }

	

	
}

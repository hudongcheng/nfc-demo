package com.sec.print.mobileprint;

import com.sec.print.mobileprint.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
	
	private Button nfcBtn;

    @Override
	protected void onNewIntent(Intent intent) {
		Log.i("nfc", "onNewIntent intent " + intent.toString());
		//Tag tagFromIntent = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
		//Log.i("nfc", "tag " + tagFromIntent.toString());
		super.onNewIntent(intent);
	}

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("nfc", "onCreate, intent: " + getIntent().toString());
        
        nfcBtn = (Button) findViewById(R.id.button1);
        nfcBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, NfcActivity.class);
				startActivity(intent);
				
			}
		});
        
        Intent intent = new Intent(MainActivity.this, NfcActivity.class);
		startActivity(intent);
		finish();
        
        //NfcAdapter nfc = NfcAdapter.getDefaultAdapter(this);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
}

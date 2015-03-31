package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest02Secondary extends Activity {

	
	private Button buton_ok;
	private Button buton_cancel;
	
	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	
	private class ButtonClickListener implements View.OnClickListener  {
		
		@Override
		public void onClick(View v) {
			
			if(buton_ok.equals((Button)v)){
				setResult(RESULT_OK, new Intent());
				finish();
			}
			else if(buton_cancel.equals((Button)v)){
				setResult(RESULT_CANCELED, new Intent());
				finish();
			}
		}
	}

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test02_secondary);
		
		EditText t1 = (EditText) findViewById(R.id.textul1);
		EditText t2 = (EditText) findViewById(R.id.textul2);
		
		Intent intent = getIntent();
		if(intent != null){
			System.out.println("intentie nu e nulla");
			boolean telefon = intent.getBooleanExtra("telefon", false);
			boolean email = intent.getBooleanExtra("email", false);
			t2.setText(String.valueOf(telefon));
			
		
				t1.setText(String.valueOf(email));
		}
		
		buton_ok = (Button) findViewById(R.id.ok_buton);
		buton_cancel = (Button) findViewById(R.id.cancel_buton);
		
		buton_ok.setOnClickListener(buttonClickListener);
		buton_cancel.setOnClickListener(buttonClickListener);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test02_secondary, menu);
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

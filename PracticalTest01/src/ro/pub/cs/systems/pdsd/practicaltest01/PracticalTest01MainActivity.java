package ro.pub.cs.systems.pdsd.practicaltest01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class PracticalTest01MainActivity extends Activity {
	
	Button b1;
	EditText t1, t2;
	CheckBox c1, c2;
	
	private TextListener textL = new TextListener();
	
	public class TextListener implements TextWatcher{

		@Override
		public void afterTextChanged(Editable s) {
			
			
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			t1 = (EditText) findViewById(R.id.text1);
			t2 = (EditText) findViewById(R.id.text2);
			c1 = (CheckBox) findViewById(R.id.check1);
			c2 = (CheckBox) findViewById(R.id.check2);
			
			if(t1.getText().toString() != null){
				if(isEmailValid(t1.getText().toString())){
					c1.setChecked(true);
				}
				else{
					c1.setChecked(false);
				}
			}
			
			if(t2.getText().toString() != null){
				if(t2.getText().toString().length() == 10 && t2.getText().toString().matches("[0-9]+")){
					c2.setChecked(true);
				}
				else{
					c2.setChecked(false);
				}
			}
			
		}
		
	}
	
	public static boolean isEmailValid(String email) {
	    boolean isValid = false;

	    String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	    CharSequence inputStr = email;

	    Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(inputStr);
	    if (matcher.matches()) {
	        isValid = true;
	    }
	    return isValid;
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        
        t1 = (EditText) findViewById(R.id.text1);
		t2 = (EditText) findViewById(R.id.text2);
		c1 = (CheckBox) findViewById(R.id.check1);
		c2 = (CheckBox) findViewById(R.id.check2);
		
		t1.addTextChangedListener(textL);
		t2.addTextChangedListener(textL);
    }
    
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
      super.onSaveInstanceState(savedInstanceState);
      
      
      t1 = (EditText) findViewById(R.id.text1);
      t2 = (EditText) findViewById(R.id.text2);
      c1 = (CheckBox) findViewById(R.id.check1);
      c2 = (CheckBox) findViewById(R.id.check2);

      
      savedInstanceState.putString("textul1", t1.getText().toString());
      savedInstanceState.putString("textul2", t2.getText().toString());
      savedInstanceState.putBoolean("check1", c1.isChecked());
      savedInstanceState.putBoolean("check2", c2.isChecked());
      
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
      super.onRestoreInstanceState(savedInstanceState);
    
      
      t1 = (EditText) findViewById(R.id.text1);
      t2 = (EditText) findViewById(R.id.text2);
      c1 = (CheckBox) findViewById(R.id.check1);
      c2 = (CheckBox) findViewById(R.id.check2);

      
      t1.setText(savedInstanceState.getString("textul1"));
      t2.setText(savedInstanceState.getString("textul2"));
      c1.setActivated(savedInstanceState.getBoolean("check1"));
      c2.setActivated(savedInstanceState.getBoolean("check2"));
    }
    
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_main, menu);
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

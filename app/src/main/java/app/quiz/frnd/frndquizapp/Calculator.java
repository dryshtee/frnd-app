package app.quiz.frnd.frndquizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Farheen on 14-Apr-16.
 */
public class Calculator extends Activity {

    TextView tvBacktoHome;

    String total="";
    double v1,v2;
    String sign="";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        tvBacktoHome = (TextView) findViewById(R.id.tvBacktoHome);

        tvBacktoHome.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
              Intent launchActivity1 = new Intent(getApplicationContext(), Home.class);
              startActivity(launchActivity1);
              }
              }
        );
    }
    public void onClick(View v) {
        Button button = (Button)v;
        String str = button.getText().toString();
        total+=str;
        EditText edit = (EditText)findViewById(R.id.editText);
        edit.setText(total);
    }
    public void OnAdd(View v) {
        v1 = Double.parseDouble(total);
        total="";
        Button button = (Button)v;
        String str = button.getText().toString();
        sign = str;
        EditText edit = (EditText)findViewById(R.id.editText);
        edit.setText("");
    }
    public void OnCalculate(View v) {
        EditText edit = (EditText)findViewById(R.id.editText);
        String str2 = edit.getText().toString();
        v2 = Double.parseDouble(str2);
        double grand_total=0;
        if(sign.equals("+")) {
            grand_total = v1+v2;
        }
        else if(sign.equals("-")) {
            grand_total = v1-v2;
        }
        else if(sign.equals("*")) {
            grand_total = v1*v2;
        }
        else if(sign.equals("/")) {
            grand_total = v1/v2;
        }
        edit.setText(grand_total+"");
    }
    public void OnClear(View v) {
        EditText edit = (EditText) findViewById(R.id.editText);
        edit.setText("");
        total="";
    }
}

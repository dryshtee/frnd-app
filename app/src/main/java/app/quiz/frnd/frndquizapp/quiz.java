package app.quiz.frnd.frndquizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by Farheen on 13-Apr-16.
 */
public class quiz extends Activity {

    Button button ;
    TextView tv;
    RadioGroup rg;
    RadioButton r1, r2, r3, r4;

    public static String questions [] = {"What are the colours of a Mauritian Flag?","How many zero(s) are there in one hundred thousand?","How many hours are there in two days?","Which of the following is not a reptile?","What is the capital city of France?","Which gas do we need to breathe to stay alive?","Which planet is closest to the sun?","How does a semicolon look like?","How many millimetres are there in 1cm?","How many consonants are there in the English alphabet?"};
    String answers [] = {"Red, Blue, Yellow, Green","Five","48 Hours","Spider","Paris","Oxygen","Mercury",";","10mm","21"};
    String opts [] = {"Orange, White, Green","Red, Blue, Yellow, Green","Green, Yellow, Red","Blue, Red, White","Three","Four","Five","Six","24 Hours","36 Hours","48 Hours","72 Hours","Turtle","Spider","Lizard","None","London","Berlin","Paris","Sydney","Oxygen","Carbon Dioxide","Nitrogen","Hydrogen","The Earth","Venus","Jupiter","Mercury",";",":",",",":-","1mm","10mm","100mm","1000mm","18","5","26","21"};

    int position=0;
    public static int correct;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        tv = (TextView) findViewById(R.id.question);
        button = (Button) findViewById(R.id.movebutton);
        rg = (RadioGroup) findViewById(R.id.rg);
        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        r4 = (RadioButton) findViewById(R.id.r4);

        tv.setText(questions[position]);
        r1.setText(opts[position]);
        r2.setText(opts[position+1]);
        r3.setText(opts[position+2]);
        r4.setText(opts[position+3]);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton selectedans = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                String selectedansText = selectedans.getText().toString();

                if(selectedansText==answers[position]){
                    correct++;
                }
                position++;
                if(position<questions.length){
                    tv.setText(questions[position]);

                    r1.setText(opts[position*4]);
                    r2.setText(opts[position*4+1]);
                    r3.setText(opts[position*4+2]);
                    r4.setText(opts[position*4+3]);
                }else{

                    Intent in = new Intent(getApplicationContext(),result.class);
                    startActivity(in);

                }
            }
        });
    }
}
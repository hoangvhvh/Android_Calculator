package org.coolstyles.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText weight;
    private EditText height;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weight = (EditText) findViewById(R.id.weight);
        height = (EditText) findViewById(R.id.height);
        result = (TextView) findViewById(R.id.result);
    }

    public void calculateCAL(View v) {
        String weightStr = weight.getText().toString();
        String heightStr = height.getText().toString();

        if(heightStr !=null && !"".equals(heightStr)
             && weightStr !=null && !"".equals(weightStr)) {
           float heightValue = Float.parseFloat(heightStr) / 100;
           float weightValue = Float.parseFloat(weightStr);
           float cal = weightValue / (heightValue * heightValue);
           displayCAL(cal);
        }
    }

    public void displayCAL(float cal) {
        String calLabel = "";

        if (Float.compare(cal, 18.5f) < 0) {
            calLabel = getString(R.string.underweight);
        } else if (Float.compare(cal, 18.5f) > 0  &&  Float.compare(cal, 22.9f) <= 0) {
            calLabel = getString(R.string.normal);
        } else if (Float.compare(cal, 23f) > 0  &&  Float.compare(cal, 24.9f) <= 0) {
            calLabel = getString(R.string.overweight);
        } else if (Float.compare(cal, 25f) > 0  &&  Float.compare(cal, 29.9f) <= 0) {
            calLabel = getString(R.string.obese_class_i);
        } else if (Float.compare(cal, 30f) > 0  &&  Float.compare(cal, 39.9f) <= 0) {
            calLabel = getString(R.string.obese_class_ii);
        } else {
            calLabel = getString(R.string.obese_class_iii);
        }
        calLabel = cal + "\n\n" + calLabel;
        result.setText(calLabel);
    }
}
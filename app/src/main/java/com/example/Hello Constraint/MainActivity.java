package com.example.HelloConstraint;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.HelloConstraint.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int mCount= 0;
    private TextView mShowCount;
    private Button reset, count;
    private String counterValue;
    private int countVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ActivityMainBinding activityMainBinding;

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        View view = activityMainBinding.getRoot();
        setContentView(view);

        mShowCount = findViewById(R.id.show_count);
        reset = findViewById(R.id.buttonReset);
        count = findViewById(R.id.button2);

        activityMainBinding.buttonReset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount=0;
                mShowCount.setText("0");
                reset.setBackgroundColor(Color.GRAY);
            }
        });

        activityMainBinding.button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                mShowCount.setText(Integer.toString(mCount));
                reset.setBackgroundColor(Color.MAGENTA);

                if(mCount%2==0){
                    count.setBackgroundColor(Color.YELLOW);
                }
                else{
                    count.setBackgroundColor(Color.CYAN);
                }
            }
        });


    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

}
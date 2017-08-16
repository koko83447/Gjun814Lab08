package com.example.android.lab08;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

public class Activity1 extends AppCompatActivity {

    public static final String Q1_ANSWER_KEY = "Q1";
    private CharSequence m_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
    }


    public void next(View view) {
        Intent intent = new Intent(this,Activity2.class);
        intent.putExtra(Q1_ANSWER_KEY,m_answer);
        startActivity(intent);
    }

    public void click(View view){
        switch (view.getId()){
            case R.id.radio_a:
                m_answer = "A";
                break;
            case R.id.radio_b:
                m_answer = "B";
                break;
            case R.id.radio_c:
                m_answer = "C";
                break;
        }
    }

}

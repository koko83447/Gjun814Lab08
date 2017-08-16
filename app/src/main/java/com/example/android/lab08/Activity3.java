package com.example.android.lab08;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import static com.example.android.lab08.Activity1.Q1_ANSWER_KEY;
import static com.example.android.lab08.Activity2.Q2_ANSWER_KEY;

public class Activity3 extends AppCompatActivity {

    private static final String TAG = "Activity3";
    public static final String Q3_ANSWER_KEY = "Q3";
    private CharSequence m_q1_answer;
    private CharSequence m_q2_answer;
    private CharSequence m_q3_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        m_q1_answer = getIntent().getExtras().getString(Q1_ANSWER_KEY);
        m_q2_answer = getIntent().getExtras().getString(Q2_ANSWER_KEY);
        Log.d(TAG,"m_q1_answer = " + m_q1_answer);
        Log.d(TAG,"m_q2_answer = " + m_q2_answer);
    }


    public void next(View view) {
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra(Q1_ANSWER_KEY,m_q1_answer);
        intent.putExtra(Q2_ANSWER_KEY,m_q2_answer);
        intent.putExtra(Q3_ANSWER_KEY,m_q3_answer);
        startActivity(intent);
    }

    public void click(View view){
        switch (view.getId()){
            case R.id.radio_a:
                m_q3_answer = "A";
                break;
            case R.id.radio_b:
                m_q3_answer = "B";
                break;
            case R.id.radio_c:
                m_q3_answer = "C";
                break;
        }
    }
}

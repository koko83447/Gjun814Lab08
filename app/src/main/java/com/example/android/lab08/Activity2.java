package com.example.android.lab08;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import static com.example.android.lab08.Activity1.Q1_ANSWER_KEY;

public class Activity2 extends AppCompatActivity {

    private static final String TAG = "Activity2";
    public static final String Q2_ANSWER_KEY = "Q2";
    private CharSequence m_q1_answer;
    private CharSequence m_q2_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        m_q1_answer = getIntent().getExtras().getString(Q1_ANSWER_KEY);
        Log.d(TAG,"m_q1_answer = " + m_q1_answer);
    }

    public void next(View view) {
        Intent intent = new Intent(this,Activity3.class);
        intent.putExtra(Q1_ANSWER_KEY,m_q1_answer);
        intent.putExtra(Q2_ANSWER_KEY,m_q2_answer);
        startActivity(intent);
    }

    public void click(View view){
        switch (view.getId()){
            case R.id.radio_a:
                m_q2_answer = "A";
                break;
            case R.id.radio_b:
                m_q2_answer = "B";
                break;
            case R.id.radio_c:
                m_q2_answer = "C";
                break;
        }
    }
}

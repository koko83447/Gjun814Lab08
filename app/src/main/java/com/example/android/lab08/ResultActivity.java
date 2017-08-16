package com.example.android.lab08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static com.example.android.lab08.Activity1.Q1_ANSWER_KEY;
import static com.example.android.lab08.Activity2.Q2_ANSWER_KEY;
import static com.example.android.lab08.Activity3.Q3_ANSWER_KEY;

public class ResultActivity extends AppCompatActivity {

    private static final String TAG = "ResultActivity";

    private CharSequence m_q1_answer;
    private CharSequence m_q2_answer;
    private CharSequence m_q3_answer;

    private TextView m_tv_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        m_q1_answer = getIntent().getExtras().getString(Q1_ANSWER_KEY);
        m_q2_answer = getIntent().getExtras().getString(Q2_ANSWER_KEY);
        m_q3_answer = getIntent().getExtras().getString(Q3_ANSWER_KEY);
        Log.d(TAG,"m_q1_answer = " + m_q1_answer);
        Log.d(TAG,"m_q2_answer = " + m_q2_answer);
        Log.d(TAG,"m_q3_answer = " + m_q3_answer);

        StringBuilder result = new StringBuilder();
        result.append("1.").append(m_q1_answer).append("\n")
              .append("2.").append(m_q2_answer).append("\n")
              .append("3.").append(m_q3_answer);

        m_tv_result = (TextView)findViewById(R.id.tv_result);
        m_tv_result.setText(result);
    }

    public void main(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}

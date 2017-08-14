package com.example.android.lab08;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

public class Activity3 extends AppCompatActivity {

    private static final String TAG = "Activity3";

    public static final String Q3_ANSWER_KEY = "Q3";
    private CharSequence m_answer;

    private void saveData(){
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(Q3_ANSWER_KEY,m_answer.toString());
        editor.commit();
    }

    private void restoreData(){
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        m_answer = prefs.getString(Q3_ANSWER_KEY,"@string/question_3_radio_a");

        RadioButton radio = null;
        switch (m_answer.toString()){
            case "@string/question_3_radio_a":
                radio = (RadioButton)findViewById(R.id.radio_a);
                break;
            case "@string/question_3_radio_b":
                radio = (RadioButton)findViewById(R.id.radio_b);
                break;
            case "@string/question_3_radio_c":
                radio = (RadioButton)findViewById(R.id.radio_c);
                break;
        }
        if (radio != null){
            radio.setChecked(true);
        }
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"onResume");
        restoreData();
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"onPause");
        saveData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        String q2Answer = getIntent().getExtras().getString(Activity2.Q2_ANSWER_KEY);
        Log.d(TAG,"q2Answer=" + q2Answer);
    }

    public void next(View view) {
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra(Q3_ANSWER_KEY,m_answer);
        startActivity(intent);
    }
}

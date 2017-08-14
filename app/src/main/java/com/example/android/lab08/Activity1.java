package com.example.android.lab08;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

public class Activity1 extends AppCompatActivity {

    private static final String TAG = "Activity1";

    public static final String Q1_ANSWER_KEY = "Q1";
    private CharSequence m_answer;

    private void saveData(){
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(Q1_ANSWER_KEY,m_answer.toString());
        editor.commit();
    }

    private void restoreData(){
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        m_answer = prefs.getString(Q1_ANSWER_KEY,"@string/question_1_radio_a");

        RadioButton radio = null;
        switch (m_answer.toString()){
            case "@string/question_1_radio_a":
                radio = (RadioButton)findViewById(R.id.radio_a);
                break;
            case "@string/question_1_radio_b":
                radio = (RadioButton)findViewById(R.id.radio_b);
                break;
            case "@string/question_1_radio_c":
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
        setContentView(R.layout.activity_1);
    }

    public void next(View view) {
        Intent intent = new Intent(this,Activity2.class);
        intent.putExtra(Q1_ANSWER_KEY,m_answer);
        startActivity(intent);
    }
}

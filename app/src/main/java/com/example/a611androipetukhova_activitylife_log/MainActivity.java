package com.example.a611androipetukhova_activitylife_log;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static TextView textView = null;
    private static final String TAG = MainActivity.class.getSimpleName();
    StringBuilder textViewA = new StringBuilder();
    StringBuilder methodName = new StringBuilder();
    int count = 0;
    SharedPreferences sPref;
    private static final String SAVED_TEXT = "saved_text";
    // private SharedPreferences.Editor ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
       sPref = getSharedPreferences("data", MODE_PRIVATE);
        loadText();
        createMethodName();
        saveText();
      // String savedText = sPref.getString(SAVED_TEXT, null);
//        if (savedText == null) {
//            createMethodName();
//        } else {
//            loadText();
//            createMethodName();
//        }

    }



    void saveText() {
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, textView.getText().toString());
        ed.apply();

    }

    void loadText() {
        String savedText = sPref.getString(SAVED_TEXT, null);
        if (savedText == null) {
            System.out.println("первый запуск");

        } else {
            textView.setText(savedText);
        }
    }

    private void createMethodName() {

        //StringBuilder methodName = new StringBuilder();
        final StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];

        count++;
        methodName.append(count);
        methodName.append("Lifecycle ");
        methodName.append(stackTraceElement.getMethodName());
        methodName.append("\n ");
        //methodName.append(msg);
        Log.d(TAG, methodName.toString());
        // textView = findViewById(R.id.textView);
        StringBuilder textViewA = new StringBuilder();
        textViewA.append("\n" + methodName + " ");
        // textViewA.append(methodName);
        //textViewA.toString();
        textView.setText(textViewA);

    }


    @Override
    protected void onStart() {
        super.onStart();
        createMethodName();
        saveText();

    }


    @Override
    protected void onResume() {
        super.onResume();
        createMethodName();
        saveText();
    }

    @Override
    protected void onPause() {
        super.onPause();
        createMethodName();
        saveText();
    }

    @Override
    protected void onStop() {
        super.onStop();
        createMethodName();
        saveText();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        createMethodName();
        saveText();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        createMethodName();
        saveText();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createMethodName();
        saveText();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        createMethodName();
        saveText();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
        //createMethodName();

    }

    @Override
    public boolean onKeyLongPress(int keyCode,
                                  KeyEvent event) {
        return super.onKeyLongPress(keyCode, event);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        createMethodName();
        saveText();
    }

    //
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        createMethodName();
        saveText();
    }
}

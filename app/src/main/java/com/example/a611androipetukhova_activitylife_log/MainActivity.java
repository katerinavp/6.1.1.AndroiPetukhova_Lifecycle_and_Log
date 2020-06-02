package com.example.a611androipetukhova_activitylife_log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView = null;
    private static final String TAG = MainActivity.class.getSimpleName();
    StringBuilder methodName = new StringBuilder();
    final static String textViewTexKey = "TEXTVIEW_TEXT";
    final static String nameVariableKey = "NAME_VARIABLE";
    String text = null;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        //createMethodName();

        //textView.setText(text);
        Log.i("myTag", "call onCreate()");
        if (savedInstanceState == null) {
            createMethodName();
            textView.setText(text);
            Log.i("myTag", "saveInstanceState == null");
        } else {
            onRestoreInstanceState(savedInstanceState);
            Log.i("myTag", "saveInstanceState != null");
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        createMethodName();
        //textView.setText(text);
        // outState.putString(nameVariableKey, text);
        //TextView textView = findViewById(R.id.textView);
        outState.putString(textViewTexKey, text);
        System.out.println("save");
        super.onSaveInstanceState(outState);

    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
         super.onRestoreInstanceState(savedInstanceState);
        createMethodName();
        //text = savedInstanceState.getString(nameVariableKey);
        String textViewText = savedInstanceState.getString(textViewTexKey);
//        //TextView textView = findViewById(R.id.textView);
//        textView.setText(textViewText);
        textView.setText(textViewText);

        System.out.println("restore");

    }

    private void createMethodName() {

        final StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];

        count++;
        methodName.append(count);
        methodName.append("Lifecycle ");
        methodName.append(stackTraceElement.getMethodName());
        methodName.append("\n");
        Log.d(TAG, methodName.toString());
        StringBuilder textViewA = new StringBuilder();
        textViewA.append("\n" + methodName);
        text = textViewA.toString();
        //textView.setText(text);

    }

    @Override
    protected void onStart() {
        super.onStart();
        createMethodName();
        textView.setText(text);

    }


    @Override
    protected void onResume() {
        super.onResume();
        createMethodName();
        textView.setText(text);
    }

    @Override
    protected void onPause() {
        super.onPause();
        createMethodName();
        textView.setText(text);
    }

    @Override
    protected void onStop() {
        super.onStop();
        createMethodName();
        textView.setText(text);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        createMethodName();
        textView.setText(text);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        createMethodName();
        textView.setText(text);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createMethodName();
        textView.setText(text);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        createMethodName();
        textView.setText(text);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        createMethodName();
        textView.setText(text);
        return super.onKeyDown(keyCode, event);


    }

    @Override
    public boolean onKeyLongPress(int keyCode,
                                  KeyEvent event) {
        createMethodName();
        textView.setText(text);
        return super.onKeyLongPress(keyCode, event);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        createMethodName();
        textView.setText(text);
    }


}

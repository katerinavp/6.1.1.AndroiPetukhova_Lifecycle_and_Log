package com.example.a611androipetukhova_activitylife_log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView = null;
    private static final String TAG = MainActivity.class.getSimpleName();
    final static String TEXT_VIEW_TEXT_KEY = "TEXTVIEW_TEXT";
    private StringBuilder text = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        Log.i("myTag", "call onCreate()");
        if (savedInstanceState == null) {
            createMethodName();
            Log.i("myTag", "saveInstanceState == null");
        } else {
            text.append(savedInstanceState.getString(TEXT_VIEW_TEXT_KEY));
            createMethodName();
            Log.i("myTag", "saveInstanceState != null");
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        createMethodName();
        outState.putString(TEXT_VIEW_TEXT_KEY, text.toString());
        System.out.println("save");
        super.onSaveInstanceState(outState);

    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        createMethodName();
        System.out.println("restore");

    }

    private void createMethodName() {

        final StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];

        String methodName = stackTraceElement.getMethodName();
        int count;
        if (TextUtils.isEmpty(text)) {
            count = 1;

        } else {
            count = text.toString().split("\n").length + 1; // кол-ва строк в тексте
        }
        text.append(count);
        text.append(")");
        text.append(" ");
        text.append(methodName);
        text.append("\n");
        Log.d(TAG, methodName);
        textView.setText(text);

    }

    @Override
    protected void onStart() {
        super.onStart();
        createMethodName();
    }


    @Override
    protected void onResume() {
        super.onResume();
        createMethodName();
    }

    @Override
    protected void onPause() {
        super.onPause();
        createMethodName();
    }

    @Override
    protected void onStop() {
        super.onStop();
        createMethodName();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        createMethodName();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        createMethodName();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createMethodName();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        createMethodName();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        createMethodName();
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode,
                                  KeyEvent event) {
        createMethodName();
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        createMethodName();
    }


}

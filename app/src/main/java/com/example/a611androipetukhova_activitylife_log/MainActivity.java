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
    String name = "undefined";
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        createMethodName();
        Log.i("myTag", "call onCreate()");
        if (savedInstanceState == null) {
            Log.i("myTag", "saveInstanceState == null");
        } else {
            Log.i("myTag", "saveInstanceState != null");
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        createMethodName();
        outState.putString(nameVariableKey, name);
        TextView textView = findViewById(R.id.textView);
        outState.putString(textViewTexKey, textView.getText().toString());
        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        createMethodName();
        name = savedInstanceState.getString(nameVariableKey);
        String textViewText = savedInstanceState.getString(textViewTexKey);
        TextView nameView = findViewById(R.id.textView);
        nameView.setText(textViewText);

    }

    private void createMethodName() {

        final StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];

        count++;
        methodName.append(count);
        methodName.append("Lifecycle ");
        methodName.append(stackTraceElement.getMethodName());
        methodName.append("\n ");
        Log.d(TAG, methodName.toString());
        StringBuilder textViewA = new StringBuilder();
        textViewA.append("\n" + methodName + " ");
        textView.setText(textViewA);

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

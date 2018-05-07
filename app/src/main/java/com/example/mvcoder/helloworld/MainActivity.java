package com.example.mvcoder.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.drearming.testlib.TestLibActivity;

public class MainActivity extends AppCompatActivity {

    private final String TAG = TestLibActivity.class.getSimpleName();

    private Button bt;
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = findViewById(R.id.bt_join);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joinToTestLibActivity();
            }
        });
    }

    private void joinToTestLibActivity(){
        Intent intent = new Intent(this, TestLibActivity.class);
        startActivity(intent);

        Log.e(TAG, "getString : " + TestLibActivity.testString());
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}

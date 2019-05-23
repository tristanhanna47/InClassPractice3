package com.example.t00584336.inclasspractice3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity {

    public static final int REQUEST_CODE = 1;
    TextView numberDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        numberDetail = findViewById(R.id.numberDetail);
        Intent intent = getIntent();
        int number = intent.getIntExtra(MainActivity.NUMBER_KEY,0);
        numberDetail.setText("Your important number is: \n" + number);

    }

    public void takePhoto(View view)
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (intent.resolveActivity(getPackageManager()) != null)
        {
            //we found an activity to take photo

            //goes to anothr activity
            startActivityForResult(intent, REQUEST_CODE );
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            Log.v("potato", "got a picture!");

        }
    }



}

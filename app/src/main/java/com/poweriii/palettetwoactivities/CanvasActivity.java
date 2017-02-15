package com.poweriii.palettetwoactivities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

public class CanvasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        Intent rec_int = getIntent();
        String color = rec_int.getStringExtra("msg_key_1");
        findViewById(R.id.activity_canvas).setBackgroundColor(Color.parseColor(color));
    }
}

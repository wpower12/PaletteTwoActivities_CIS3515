package com.poweriii.palettetwoactivities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;

public class PaletteActivity extends Activity {

    private boolean first_fire = true;
    private final String MSG_KEY = "msg_key_1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        final ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("White");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Magenta");
        colors.add("Purple");

        final View layout = findViewById(R.id.activity_palette);
        Spinner spin = (Spinner) findViewById(R.id.color_spinner);
        PaletteAdapter pa = new PaletteAdapter( this, colors );
        spin.setAdapter( pa );

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if( first_fire ) {
                    first_fire = false;
                    return;
                }
                try {

                    Intent onspinIntent = new Intent( PaletteActivity.this, CanvasActivity.class );
                    String color = colors.get(position);
                    onspinIntent.putExtra( MSG_KEY, color );
                    startActivity(onspinIntent);
                } catch (Exception e ){

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                layout.setBackgroundColor(Color.WHITE);
            }
        });
    }

}

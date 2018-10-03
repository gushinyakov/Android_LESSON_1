package com.example.eugenia.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private ImageView imageIcChildFriendly;
    private ImageView imageIcMotorcycle;
    private ImageView imageIcBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageIcChildFriendly = findViewById(R.id.ic_child_friendly);
        imageIcMotorcycle = findViewById(R.id.ic_motorcycle);
        imageIcBus = findViewById(R.id.ic_bus);

        Spinner spinnerStyle = findViewById(R.id.spinner_style);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                                R.array.spinnerStyles, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStyle.setAdapter(adapter);

        setColorForIcImage(getResources().getColor(R.color.drawableDark));
        spinnerStyle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        setColorForIcImage(getResources().getColor(R.color.drawableDark));
                        break;
                    case 1:
                        setColorForIcImage(getResources().getColor(R.color.drawableLight));
                        break;
                    case 2:
                        imageIcChildFriendly.setColorFilter(getResources().getColor(R.color.drawableHappy_one));
                        imageIcMotorcycle.setColorFilter(getResources().getColor(R.color.drawableHappy_two));
                        imageIcBus.setColorFilter(getResources().getColor(R.color.drawableHappy_three));
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setColorForIcImage(int color) {
        imageIcChildFriendly.setColorFilter(color);
        imageIcMotorcycle.setColorFilter(color);
        imageIcBus.setColorFilter(color);
    }
}

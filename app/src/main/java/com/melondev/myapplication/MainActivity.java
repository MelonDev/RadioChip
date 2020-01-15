package com.melondev.myapplication;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.melondev.radiochip.RadioChip;
import com.melondev.radiochip.RadioChipController;
import com.melondev.radiochip.RadioChipLayout;
import com.melondev.radiochip.RadioChipStyle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.colorBottomNavigation)));
        //getSupportActionBar().setDisplayShowTitleEnabled(false);



        //quickRadioChipPreview();
        radioChipPreview();
    }

    private void quickRadioChipPreview(){
        RadioChipLayout layout = (RadioChipLayout) findViewById(R.id.radio_chip_layout);
        RadioChipController controller = new RadioChipController(this, layout);
        controller.addStringListToChips(getData());
        controller.build();
    }

    private void radioChipPreview(){
        RadioChipLayout layout = (RadioChipLayout) findViewById(R.id.radio_chip_layout);

        RadioChipStyle style = new RadioChipStyle();

        //style.setBackgroundColor(R.color.colorTranslucent);
        style.setIconColor(R.color.colorRadio);
        style.setActiveIconColor(R.color.colorAccent);
        style.setRipperColor(R.color.colorAccent);

        RadioChipController controller = new RadioChipController(this, layout,style);

        controller.addStringListToChips(getData());
        controller.addListener(new RadioChipController.OnChangeListener() {
            @Override
            public void onChanged(RadioChip radioChip, int position) {
                //TODO
            }
        });
        controller.setDefaultPosition(2);
        controller.build();
    }

    private ArrayList<String> getData(){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("One");
        arr.add("Two");
        arr.add("Three");
        arr.add("Four");
        arr.add("Five");
        arr.add("Six");
        arr.add("Seven");
        arr.add("Eight");
        arr.add("Nine");
        arr.add("Ten");
        return arr;
    }


}

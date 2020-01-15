package com.melondev.radiochip;

import android.content.Context;
import android.util.AttributeSet;

import com.google.android.material.chip.ChipGroup;

public class RadioChipLayout extends ChipGroup {
    public RadioChipLayout(Context context) {
        super(context);
        initial();
    }

    public RadioChipLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initial();
    }

    public RadioChipLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initial();
    }

    private void initial(){
        this.setSingleSelection(true);
        this.setChipSpacing(20);
    }

    public void add(RadioChip radioChip){
        this.addView(radioChip);

    }


}
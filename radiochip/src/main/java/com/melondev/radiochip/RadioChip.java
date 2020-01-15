package com.melondev.radiochip;

import android.content.Context;
import android.util.AttributeSet;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;

public class RadioChip extends Chip {


    public RadioChip(Context context) {
        super(context);
    }

    public RadioChip(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RadioChip(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RadioChip createRadioChip(String text) {
        setChipDrawable(getRadioChipDrawable());
        setText(text);
        return this;
    }

    public RadioChip createRadioChip(String text, ChipDrawable chipDrawable) {
        setChipDrawable(chipDrawable);
        setText(text);
        return this;
    }

    public RadioChip setStyle(ChipDrawable chipDrawable) {
        setChipDrawable(chipDrawable);
        return this;
    }

    private ChipDrawable getRadioChipDrawable() {
        return ChipDrawable.createFromAttributes(
                getContext(),
                null,
                0,
                R.style.CustomChipSelection
        );
    }

    public static ChipDrawable getRadioChipDrawable(Context context) {
        return ChipDrawable.createFromAttributes(
                context,
                null,
                0,
                R.style.CustomChipSelection
        );
    }

}

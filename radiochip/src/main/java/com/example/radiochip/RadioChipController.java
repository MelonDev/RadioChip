package com.example.radiochip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class RadioChipController {

    private Context context;
    private RadioChipLayout radioChipLayout;
    private ArrayList<RadioChip> list = new ArrayList<RadioChip>();
    private RadioChipStyle style = null;
    private OnChangeListener onChangeListener;

    private int chipSelectId = -1;



    public RadioChipController(Context context, RadioChipLayout radioChipLayout) {
        this.context = context;
        this.radioChipLayout = radioChipLayout;
        radioChipLayout.setVisibility(View.GONE);

    }

    public RadioChipController(Context context, RadioChipLayout radioChipLayout, RadioChipStyle radioChipStyle) {
        this.context = context;
        this.radioChipLayout = radioChipLayout;
        this.style = radioChipStyle;
        radioChipLayout.setVisibility(View.GONE);

    }

    public interface OnChangeListener {
        void onChanged(RadioChip radioChip, int position);
    }

    public void setDefaultPosition(int position){
        checkByPosition(position);
    }

    private void checkByPosition(int position) {
        if(position <= list.size()){
            checkById(list.get(position).getId());
        }else {
            checkById(list.get(list.size() - 1).getId());

        }
    }

    private void checkById(int id) {
        //radioChipLayout.check(id);
        chipSelectId = id;
    }

    public void addListener(final OnChangeListener onChangeListener) {

        this.onChangeListener = onChangeListener;

    }

    public void build() {
        if(list.size() > 0 && chipSelectId == -1){
            checkByPosition(0);
        }
        radioChipLayout.check(chipSelectId);

        radioChipLayout.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup chipGroup, int id) {

                compressListener(chipGroup,id);

            }
        });

        radioChipLayout.setVisibility(View.VISIBLE);
    }

    private void compressListener(ChipGroup chipGroup, int id){
        singleSelectionController(chipGroup,id);
        if(onChangeListener != null) {
            for (int x = 0; x < list.size(); x++) {
                if (list.get(x).getId() == chipGroup.getCheckedChipId()) {
                    onChangeListener.onChanged(list.get(x), x);
                }
            }
        }
    }

    private void singleSelectionController(ChipGroup chipGroup, int id){
        if (id == -1) {
            chipGroup.check(chipSelectId);
        } else {
            chipSelectId = id;
        }
    }

    public void addRadioChip(RadioChip radioChip) {
        radioChipLayout.add(radioChip);
        list.add(radioChip);
    }

    public void addRadioChip(String text) {
        final RadioChip radioChip;
        if (style != null) {

            ChipDrawable chipDrawable = configStyle();

            radioChip = new RadioChip(context).createRadioChip(text, chipDrawable);
        } else {
            radioChip = new RadioChip(context).createRadioChip(text);
        }
        addRadioChip(radioChip);
    }

    private ChipDrawable configStyle(){
        ChipDrawable chipDrawable = RadioChip.getRadioChipDrawable(context);

        if (style.getBackgroundColor() > 0) {
            chipDrawable.setChipBackgroundColor(convertToColorStateList(style.getBackgroundColor()));
        }
        if (style.getIconColor() > 0) {
            chipDrawable.setChipIconTint(convertToColorStateList(style.getIconColor()));
        }

        if(style.getActiveIconColor() > 0){
            Drawable drawable = ContextCompat.getDrawable(context,R.drawable.ic_radio_on);
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(context,style.getActiveIconColor()), PorterDuff.Mode.SRC_ATOP));
                chipDrawable.setCheckedIcon(drawable);
            }
        }
        if(style.getRipperColor() > 0){
            chipDrawable.setRippleColor(convertToColorStateList(style.getRipperColor()));
        }
        return chipDrawable;
    }

    public void addListToChips(ArrayList<RadioChip> chips) {
        for (int i = 0; i < chips.size(); i++) {
            RadioChip radioChip = chips.get(i);
            addRadioChip(radioChip);
        }
    }

    public void addStringListToChips(ArrayList<String> texts) {
        for (int i = 0; i < texts.size(); i++) {
            String text = texts.get(i);
            addRadioChip(text);
        }
    }

    private ColorStateList convertToColorStateList(int resource) {
        return ColorStateList.valueOf(
                ContextCompat.getColor(
                        context,
                        resource
                )
        );
    }

    private void addRadioChipToLayout(ChipDrawable chipDrawable) {
        for (int i = 0; i < list.size(); i++) {
            RadioChip radioChip = list.get(i);
            radioChip.setStyle(chipDrawable);
            radioChipLayout.add(radioChip);
        }
    }


}

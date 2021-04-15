package com.example.pairprogram3;

import android.view.MotionEvent;
import android.view.View;

import androidx.core.view.GestureDetectorCompat;

public class TouchListener implements View.OnTouchListener {
    MainActivity mainActivity;

    public TouchListener(MainActivity ma) {
        this.mainActivity = ma;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int maskedAction = motionEvent.getActionMasked();
        switch(maskedAction){
            case MotionEvent.ACTION_DOWN:
                mainActivity.rotate(180);
                break;
            case MotionEvent.ACTION_UP:
                mainActivity.rotate(0);
                break;
        }

        return true;
    }

}

package com.example.hider.table;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Card extends FrameLayout {
    private TextView tv;
    private int num = 0;

    public Card(@NonNull Context context) {
        super(context);
        tv = new TextView(getContext());
        tv.setTextSize(32);
        tv.setGravity(Gravity.CENTER);
        tv.setBackgroundColor(0x33ffffff);
        LayoutParams params = new LayoutParams(-1, -1);
        params.setMargins(10, 10, 0, 0);
        addView(tv, params);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
        if (this.num <= 0) {
            tv.setText("");
        } else {
            tv.setText("" + num);
        }

        switch (num) {
            case 0:
                tv.setBackgroundColor(0x33ffffff);
                break;
            case 2:
                tv.setBackgroundColor(0xffeee4da);
                break;
            case 4:
                tv.setBackgroundColor(0xffede0c8);
                break;
            case 8:
                tv.setBackgroundColor(0xfff2b179);
                break;
            case 16:
                tv.setBackgroundColor(0xfff59563);
                break;
            case 32:
                tv.setBackgroundColor(0xfff67c5f);
                break;
            case 64:
                tv.setBackgroundColor(0xfff65e3b);
                break;
            case 128:
                tv.setBackgroundColor(0xffedcf72);
                break;
            case 256:
                tv.setBackgroundColor(0xffedcc61);
                break;
            case 512:
                tv.setBackgroundColor(0xffedc850);
                break;
            case 1024:
                tv.setBackgroundColor(0xffedc53f);
                break;
            case 2048:
                tv.setBackgroundColor(0xffedc22e);
                break;
            default:
                tv.setBackgroundColor(0xff3c3a32);
                break;
        }
    }

    public boolean equals(Card c){
        return getNum()==c.getNum();
    }
}

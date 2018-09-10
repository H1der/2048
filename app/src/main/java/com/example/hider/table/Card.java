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
    }

    public boolean equals(Card c){
        return getNum()==c.getNum();
    }
}

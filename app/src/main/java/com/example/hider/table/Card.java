package com.example.hider.table;

import android.content.Context;
import android.graphics.Typeface;
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
        tv.setTextSize(50);
        tv.setGravity(Gravity.CENTER);
//        tv.setBackgroundResource(R.drawable.bk);
//        tv.setBackgroundColor(0x33ffffff);
        tv.setBackgroundColor(0x70FFFFFF);
        tv.setTextColor(0xFFFF0000);
        tv.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        LayoutParams params = new LayoutParams(-1, -1);
        params.setMargins(10, 10, 0, 0);
        addView(tv, params);
    }

    public int getNum() {
        return num;
    }


    //设置数字并且给每个数字设置专属素材
    public void setNum(int num) {
        this.num = num;
        if (this.num <= 0) {
            tv.setText("");
        } else {
            tv.setText("" + num);
        }

        switch (num) {
            case 0:
                tv.setBackgroundColor(0x70FFFFFF);
                break;
            case 2:
                tv.setBackgroundResource(R.drawable.xg);
                tv.getBackground().setAlpha(200);
                break;
            case 4:
                tv.setBackgroundResource(R.drawable.kl);
                tv.getBackground().setAlpha(200);
                break;
            case 8:
                tv.setBackgroundResource(R.drawable.xb);
                tv.getBackground().setAlpha(200);
                break;
            case 16:
//                tv.setBackgroundColor(0xfff59563);
                tv.setBackgroundResource(R.drawable.nm);
                tv.getBackground().setAlpha(200);
                break;
            case 32:
                tv.setBackgroundResource(R.drawable.mj);
                tv.getBackground().setAlpha(200);
                break;
            case 64:
                tv.setBackgroundResource(R.drawable.tx);
                tv.getBackground().setAlpha(200);
                break;
            case 128:
                tv.setBackgroundResource(R.drawable.bql);
                tv.getBackground().setAlpha(200);
                break;
            case 256:
                tv.setBackgroundResource(R.drawable.px);
                tv.getBackground().setAlpha(200);
                break;
            case 512:
                tv.setBackgroundResource(R.drawable.sm);
                tv.getBackground().setAlpha(200);
                break;
            case 1024:
                tv.setBackgroundResource(R.drawable.hx);
                tv.getBackground().setAlpha(200);
                break;
            case 2048:
                tv.setBackgroundResource(R.drawable.hmbb);
                tv.getBackground().setAlpha(200);
                break;
            default:
                tv.setBackgroundColor(0x70FFFFFF);
                break;
        }
    }


    //是否相等
    public boolean equals(Card c){
        return getNum()==c.getNum();
    }
}

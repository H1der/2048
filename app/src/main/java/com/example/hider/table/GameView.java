package com.example.hider.table;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GameView extends GridLayout {
    private Card[][] cardsMap = new Card[4][4];
    private List<Point> lists = new ArrayList<Point>();

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initGame();
    }


    private void initGame() {
        setColumnCount(4);
        setBackgroundColor(0xffbbada0);
        addCard(GetCardWidth(), GetCardWidth());
        startGame();

        setOnTouchListener(new OnTouchListener() {
            float startX, startY, offsetX, offsetY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();
                        startY = event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        offsetX = event.getX() - startX;
                        offsetY = event.getY() - startY;
                        if (Math.abs(offsetX) > Math.abs(offsetY)) {
                            if (offsetX < 0) {
                                swipeLeft();
                            } else if (offsetX > 0) {
                                swipeRight();
                            }
                        } else {
                            if (offsetY < 0) {
                                swipeUp();
                            } else if (offsetY > 0) {
                                swipeDown();
                            }
                        }
                        break;
                    default:
                        break;

                }
                return true;
            }
        });
    }

    private void swipeLeft() {
        boolean add = false;
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                for (int x1 = x + 1; x1 < 4; x1++) {
                    if (cardsMap[x1][y].getNum() > 0) {
                        if (cardsMap[x][y].getNum() <= 0) {
                            cardsMap[x][y].setNum(cardsMap[x1][y].getNum());
                            cardsMap[x1][y].setNum(0);
                            x--;
                            add = true;
                        } else if (cardsMap[x][y].equals(cardsMap[x1][y])) {
                            cardsMap[x][y].setNum(cardsMap[x1][y].getNum() * 2);
                            cardsMap[x1][y].setNum(0);
                            MainActivity.addScore(cardsMap[x][y].getNum());
                            add = true;
                        }
                        break;
                    }
                }
            }
        }
        if (add) {
            addRandomNum();
        }
    }

    private void swipeRight() {
        boolean add = false;
        for (int y = 0; y < 4; y++) {
            for (int x = 3; x >= 0; x--) {
                for (int x1 = x-1; x1 >=0; x1--) {
                    if (cardsMap[x1][y].getNum() > 0) {
                        if (cardsMap[x][y].getNum() <= 0) {
                            cardsMap[x][y].setNum(cardsMap[x1][y].getNum());
                            cardsMap[x1][y].setNum(0);
                            x++;
                            add = true;
                        } else if (cardsMap[x][y].equals(cardsMap[x1][y])) {
                            cardsMap[x][y].setNum(cardsMap[x][y].getNum() * 2);
                            cardsMap[x1][y].setNum(0);
                            MainActivity.addScore(cardsMap[x][y].getNum());
                            add = true;
                        }
                        break;
                    }
                }
            }
        }
        if (add) {
            addRandomNum();
        }
    }

    private void swipeUp() {
        boolean add = false;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                for (int y1 = y + 1; y1 < 4; y1++) {
                    if (cardsMap[x][y1].getNum() > 0) {
                        if (cardsMap[x][y].getNum() <= 0) {
                            cardsMap[x][y].setNum(cardsMap[x][y1].getNum());
                            cardsMap[x][y1].setNum(0);
                            y--;
                            add = true;
                        } else if (cardsMap[x][y].equals(cardsMap[x][y1])) {
                            cardsMap[x][y].setNum(cardsMap[x][y1].getNum() * 2);
                            cardsMap[x][y1].setNum(0);
                            MainActivity.addScore(cardsMap[x][y].getNum());
                            add = true;
                        }
                        break;
                    }
                }
            }
        }
        if (add) {
            addRandomNum();
        }
    }

    private void swipeDown() {
        boolean add = false;
        for (int x = 0; x < 4; x++) {
            for (int y = 3; y >= 0; y--) {
                for (int y1 = y - 1; y1 >= 0; y1--) {
                    if (cardsMap[x][y1].getNum() > 0) {
                        if (cardsMap[x][y].getNum() <= 0) {
                            cardsMap[x][y].setNum(cardsMap[x][y1].getNum());
                            cardsMap[x][y1].setNum(0);
                            y++;
                            add = true;
                        } else if (cardsMap[x][y].equals(cardsMap[x][y1])) {
                            cardsMap[x][y].setNum(cardsMap[x][y1].getNum() * 2);
                            cardsMap[x][y1].setNum(0);
                            MainActivity.addScore(cardsMap[x][y].getNum());
                            add = true;
                        }
                        break;
                    }
                }
            }
        }
        if (add) {
            addRandomNum();
        }
    }


    private void addRandomNum() {
        lists.clear();
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (cardsMap[x][y].getNum() <= 0) {
                    lists.add(new Point(x, y));
                }
            }
        }
        Point p = lists.remove((int) (Math.random() * lists.size()));
        cardsMap[p.x][p.y].setNum(Math.random() > 0.1 ? 2 : 4);
    }


    public void startGame() {
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                cardsMap[x][y].setNum(0);
            }
        }
        addRandomNum();
        addRandomNum();
    }


    private void addCard(int cardWidth, int cardHeight) {
        Card c;
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                c = new Card(getContext());
                addView(c, cardWidth, cardHeight);
                cardsMap[x][y] = c;
            }
        }
    }

//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
//        int cardWidth =(Math.min(w, h)-10)/4;
//        addCard(cardWidth, cardWidth);
//
//    }


    private int GetCardWidth() {

        //屏幕信息的对象
        DisplayMetrics displayMetrics;
        displayMetrics = getResources().getDisplayMetrics();

        //获取屏幕信息
        int cardWidth;
        cardWidth = displayMetrics.widthPixels;

        //一行有四个卡片，每个卡片占屏幕的四分之一
        return (cardWidth - 10) / 4;
    }
}

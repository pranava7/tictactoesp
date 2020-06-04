package com.example.tictactoesp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class players2view extends View {
    Paint paintline;
    Paint paintrect;
    Bitmap omp;
    Bitmap xmp;
    MediaPlayer mediaPlayerx;
    MediaPlayer mediaPlayero;
    MediaPlayer tie;
    int[][] a;
    int chance = 1;
    int count = 0;
    boolean gameover = false;
    int roundinprogress = 1;

    public static int roundswonbyX = 0;
    public static int roundswonbyO = 0;

    public players2view(Context context) {
        super(context);
        init(null);
    }

    public players2view(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }


    private void init(@Nullable AttributeSet set) {
        paintline = new Paint();
        paintline.setColor(Color.BLACK);
        paintline.setAntiAlias(true);
        paintline.setStrokeWidth(50);

        paintrect = new Paint();
        paintrect.setColor(Color.YELLOW);
        paintrect.setAntiAlias(true);
        paintrect.setTextSize(250);

        a = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = -1;
            }
        }


        xmp = BitmapFactory.decodeResource(getResources(), R.drawable.imageofx);

        omp = BitmapFactory.decodeResource(getResources(), R.drawable.imageofo);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (gameover) {
            canvas.drawColor(Color.WHITE);
            gameover = true;
        }

        if (roundinprogress > MainActivity.rounds) {
            canvas.drawText("Hurray!", 75, 2 * getHeight() / 3, paintrect);
            return;
        }


        canvas.drawRect(0, 0, getWidth() / 3, getHeight() / 3, paintrect);
        canvas.drawRect(0, getHeight() / 3, getWidth() / 3, 2 * getHeight() / 3, paintrect);
        canvas.drawRect(0, 2 * getHeight() / 3, getWidth() / 3, getHeight(), paintrect);
        canvas.drawRect(getWidth() / 3, 0, 2 * getWidth() / 3, getHeight() / 3, paintrect);
        canvas.drawRect(getWidth() / 3, getHeight() / 3, 2 * getWidth() / 3, 2 * getHeight() / 3, paintrect);
        canvas.drawRect(getWidth() / 3, 2 * getHeight() / 3, 2 * getWidth() / 3, getHeight(), paintrect);
        canvas.drawRect(2 * getWidth() / 3, 0, getWidth(), getHeight() / 3, paintrect);
        canvas.drawRect(2 * getWidth() / 3, getHeight() / 3, getWidth(), 2 * getHeight() / 3, paintrect);
        canvas.drawRect(2 * getWidth() / 3, 2 * getHeight() / 3, getWidth(), getHeight(), paintrect);

        canvas.drawLine(getWidth() / 3, 0, getWidth() / 3, getHeight(), paintline);
        canvas.drawLine(2 * getWidth() / 3, 0, 2 * getWidth() / 3, getHeight(), paintline);
        canvas.drawLine(0, getHeight() / 3, getWidth(), getHeight() / 3, paintline);
        canvas.drawLine(0, 2 * getHeight() / 3, getWidth(), 2 * getHeight() / 3, paintline);

//
        if (a[0][0] == 1) {
            canvas.drawBitmap(xmp, 25, 25, null);
        } else if (a[0][0] == 0) {
            canvas.drawBitmap(omp, 25, 25, null);
        }

        if (a[0][1] == 1) {
            canvas.drawBitmap(xmp, getWidth() / 3 + 50, 25, null);
        } else if (a[0][1] == 0) {
            canvas.drawBitmap(omp, getWidth() / 3 + 50, 25, null);
        }

        if (a[0][2] == 1) {
            canvas.drawBitmap(xmp, 2 * getWidth() / 3 + 50, 25, null);
        } else if (a[0][2] == 0) {
            canvas.drawBitmap(omp, 2 * getWidth() / 3 + 50, 25, null);
        }

        if (a[1][0] == 1) {
            canvas.drawBitmap(xmp, 25, getHeight() / 3 + 25, null);
        } else if (a[1][0] == 0) {
            canvas.drawBitmap(omp, 25, getHeight() / 3 + 25, null);
        }

        if (a[1][1] == 1) {
            canvas.drawBitmap(xmp, getWidth() / 3 + 50, getHeight() / 3 + 25, null);
        } else if (a[1][1] == 0) {
            canvas.drawBitmap(omp, getWidth() / 3 + 50, getHeight() / 3 + 25, null);
        }

        if (a[1][2] == 1) {
            canvas.drawBitmap(xmp, 2 * getWidth() / 3 + 50, getHeight() / 3 + 25, null);
        } else if (a[1][2] == 0) {
            canvas.drawBitmap(omp, 2 * getWidth() / 3 + 50, getHeight() / 3 + 25, null);
        }

        if (a[2][0] == 1) {
            canvas.drawBitmap(xmp, 25, 2 * getHeight() / 3 + 25, null);
        } else if (a[2][0] == 0) {
            canvas.drawBitmap(omp, 25, 2 * getHeight() / 3 + 25, null);
        }

        if (a[2][1] == 1) {
            canvas.drawBitmap(xmp, getWidth() / 3 + 50, 2 * getHeight() / 3 + 25, null);
        } else if (a[2][1] == 0) {
            canvas.drawBitmap(omp, getWidth() / 3 + 50, 2 * getHeight() / 3 + 25, null);
        }

        if (a[2][2] == 1) {
            canvas.drawBitmap(xmp, 2 * getWidth() / 3 + 50, 2 * getHeight() / 3 + 25, null);
        } else if (a[2][2] == 0) {
            canvas.drawBitmap(omp, 2 * getWidth() / 3 + 50, 2 * getHeight() / 3 + 25, null);
        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                if (chance == 1) {

                    if (x < getWidth() / 3 && y < getHeight() / 3) {
                        a[0][0] = 1;


                        postInvalidate();
                        chance = 0;
                    }
                    if (getWidth() / 3 < x && x < 2 * getWidth() / 3 && y < getHeight() / 3) {
                        a[0][1] = 1;

                        postInvalidate();
                        chance = 0;
                    }
                    if (2 * getWidth() / 3 < x && x < getWidth() && y < getHeight() / 3) {
                        a[0][2] = 1;

                        postInvalidate();
                        chance = 0;
                    }
                    if (x < getWidth() / 3 && y < 2 * getHeight() / 3 && y > getHeight() / 3) {

                        a[1][0] = 1;

                        postInvalidate();
                        chance = 0;
                    }
                    if (x < 2 * getWidth() / 3 && x > getWidth() / 3 && y < 2 * getHeight() / 3 && y > getHeight() / 3) {
                        a[1][1] = 1;

                        postInvalidate();
                        chance = 0;
                    }
                    if (x > 2 * getWidth() / 3 && y < 2 * getHeight() / 3 && y > getHeight() / 3) {
                        a[1][2] = 1;

                        postInvalidate();
                        chance = 0;
                    }
                    if (x < getWidth() / 3 && y < getHeight() && y > 2 * getHeight() / 3) {
                        a[2][0] = 1;
                        postInvalidate();
                        chance = 0;
                    }
                    if (x < 2 * getWidth() / 3 && x > getWidth() / 3 && y < getHeight() && y > 2 * getHeight() / 3) {
                        a[2][1] = 1;

                        postInvalidate();
                        chance = 0;
                    }
                    if (x < getWidth() && x > 2 * getWidth() / 3 && y < getHeight() && y > 2 * getHeight() / 3) {
                        a[2][2] = 1;

                        postInvalidate();
                        chance = 0;
                    }


                } else {
                    if (x < getWidth() / 3 && y < getHeight() / 3) {
                        a[0][0] = 0;
                        chance = 1;

                        postInvalidate();
                    }
                    if (getWidth() / 3 < x && x < 2 * getWidth() / 3 && y < getHeight() / 3) {
                        a[0][1] = 0;
                        chance = 1;

                        postInvalidate();
                    }
                    if (2 * getWidth() / 3 < x && x < getWidth() && y < getHeight() / 3) {
                        a[0][2] = 0;
                        chance = 1;

                        postInvalidate();
                    }
                    if (x < getWidth() / 3 && y < 2 * getHeight() / 3 && y > getHeight() / 3) {
                        a[1][0] = 0;
                        chance = 1;

                        postInvalidate();
                    }
                    if (x < 2 * getWidth() / 3 && x > getWidth() / 3 && y < 2 * getHeight() / 3 && y > getHeight() / 3) {
                        a[1][1] = 0;
                        chance = 1;

                        postInvalidate();
                    }
                    if (x > 2 * getWidth() / 3 && y < 2 * getHeight() / 3 && y > getHeight() / 3) {
                        a[1][2] = 0;
                        chance = 1;

                        postInvalidate();
                    }
                    if (x < getWidth() / 3 && y < getHeight() && y > 2 * getHeight() / 3) {
                        a[2][0] = 0;
                        chance = 1;
                        postInvalidate();
                    }
                    if (x < 2 * getWidth() / 3 && x > getWidth() / 3 && y < getHeight() && y > 2 * getHeight() / 3) {
                        a[2][1] = 0;
                        chance = 1;

                        postInvalidate();
                    }
                    if (x < getWidth() && x > 2 * getWidth() / 3 && y < getHeight() && y > 2 * getHeight() / 3) {
                        a[2][2] = 0;
                        chance = 1;

                        postInvalidate();
                    }
                }


                if (a[0][0] == a[0][1] && a[0][2] == a[0][1]) {
                    if (a[0][0] == 1) {
                        if (roundinprogress < MainActivity.rounds) {
                            Toast.makeText(getContext(), "\" X \" has WON this round", Toast.LENGTH_SHORT).show();
                        }
                        chance = 1;
                        gameover = true;
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                a[i][j] = -1;
                            }
                        }
                        postInvalidate();
                        roundswonbyX++;
                        players2activity.roundswonbyxtv.setText(roundswonbyX + "");
                        roundinprogress++;

                    } else if (a[0][0] == 0) {
                        if (roundinprogress < MainActivity.rounds) {
                            Toast.makeText(getContext(), "\" O \" has WON this round", Toast.LENGTH_SHORT).show();
                        }
                        chance = 1;
                        gameover = true;
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                a[i][j] = -1;
                            }
                        }
                        roundswonbyO++;
                        players2activity.roundswonbyotv.setText("" + roundswonbyO);
                        postInvalidate();
                        roundinprogress++;

                    }


                }
                if (a[1][0] == a[1][1] && a[1][2] == a[1][1]) {
                    if (a[1][0] == 1) {
                        if (roundinprogress < MainActivity.rounds) {
                            Toast.makeText(getContext(), "\" X \" has WON this round", Toast.LENGTH_SHORT).show();
                        }
                        chance = 1;
                        gameover = true;

                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                a[i][j] = -1;
                            }
                        }


                        roundswonbyX++;
                        players2activity.roundswonbyxtv.setText(roundswonbyX + "");
                        roundinprogress++;
                        postInvalidate();
                    } else if (a[1][0] == 0) {
                        if (roundinprogress < MainActivity.rounds) {
                            Toast.makeText(getContext(), "\" O \" has WON this round", Toast.LENGTH_SHORT).show();
                        }
                        chance = 1;
                        gameover = true;
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                a[i][j] = -1;
                            }
                        }
                        roundswonbyO++;
                        players2activity.roundswonbyotv.setText("" + roundswonbyO);
                        roundinprogress++;
                        postInvalidate();
                    }
                }
                if (a[2][0] == a[2][1] && a[2][2] == a[2][1]) {
                    if (a[2][0] == 1) {
                        if (roundinprogress < MainActivity.rounds) {
                            Toast.makeText(getContext(), "\" X \" has WON this round", Toast.LENGTH_SHORT).show();
                        }
                        chance = 1;
                        gameover = true;
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                a[i][j] = -1;
                            }
                        }
                        roundswonbyX++;
                        players2activity.roundswonbyxtv.setText(roundswonbyX + "");
                        roundinprogress++;
                        postInvalidate();
                    } else if (a[2][0] == 0) {
                        if (roundinprogress < MainActivity.rounds) {
                            Toast.makeText(getContext(), "\" O \" has WON this round", Toast.LENGTH_SHORT).show();
                        }
                        chance = 1;
                        gameover = true;
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                a[i][j] = -1;
                            }
                        }
                        roundswonbyO++;
                        players2activity.roundswonbyotv.setText("" + roundswonbyO);
                        roundinprogress++;
                        postInvalidate();
                    }
                }
                if (a[0][0] == a[1][0] && a[2][0] == a[1][0]) {
                    if (a[0][0] == 1) {
                        if (roundinprogress < MainActivity.rounds) {
                            Toast.makeText(getContext(), "\" X \" has WON this round", Toast.LENGTH_SHORT).show();
                        }
                        chance = 1;
                        gameover = true;
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                a[i][j] = -1;
                            }
                        }
                        roundswonbyX++;
                        players2activity.roundswonbyxtv.setText(roundswonbyX + "");
                        roundinprogress++;
                        postInvalidate();
                    } else if (a[0][0] == 0) {
                        if (roundinprogress < MainActivity.rounds) {
                            Toast.makeText(getContext(), "\" O \" has WON this round", Toast.LENGTH_SHORT).show();
                        }
                        chance = 1;
                        gameover = true;
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                a[i][j] = -1;
                            }
                        }
                        roundswonbyO++;
                        players2activity.roundswonbyotv.setText("" + roundswonbyO);
                        roundinprogress++;
                        postInvalidate();

                    }
                }
                if (a[0][1] == a[1][1] && a[2][1] == a[1][1]) {
                    if (a[0][1] == 1) {
                        if (roundinprogress < MainActivity.rounds) {
                            Toast.makeText(getContext(), "\" X \" has WON this round", Toast.LENGTH_SHORT).show();
                        }
                        chance = 1;
                        gameover = true;
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                a[i][j] = -1;
                            }
                        }
                        roundswonbyX++;
                        players2activity.roundswonbyxtv.setText(roundswonbyX + "");
                        roundinprogress++;
                        postInvalidate();
                    } else if (a[0][1] == 0) {
                        if (roundinprogress < MainActivity.rounds) {
                            Toast.makeText(getContext(), "\" O \" has WON this round", Toast.LENGTH_SHORT).show();
                        }
                        chance = 1;
                        gameover = true;
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                a[i][j] = -1;
                            }
                        }
                        roundswonbyO++;
                        players2activity.roundswonbyotv.setText("" + roundswonbyO);
                        roundinprogress++;
                        postInvalidate();
                    }
                }
                if (a[0][2] == a[1][2] && a[2][2] == a[1][2]) {
                    if (a[0][2] == 1) {
                        if (roundinprogress < MainActivity.rounds) {
                            Toast.makeText(getContext(), "\" X \" has WON this round", Toast.LENGTH_SHORT).show();
                        }
                        chance = 1;
                        gameover = true;
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                a[i][j] = -1;
                            }
                        }
                        roundswonbyX++;
                        players2activity.roundswonbyxtv.setText(roundswonbyX + "");
                        roundinprogress++;
                        postInvalidate();
                    } else if (a[0][2] == 0) {
                        if (roundinprogress < MainActivity.rounds) {
                            Toast.makeText(getContext(), "\" O \" has WON this round", Toast.LENGTH_SHORT).show();
                        }
                        chance = 1;
                        gameover = true;
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                a[i][j] = -1;
                            }
                        }
                        roundswonbyO++;
                        players2activity.roundswonbyotv.setText("" + roundswonbyO);
                        roundinprogress++;
                        postInvalidate();
                    }
                }
                if (a[0][0] == a[1][1] && a[1][1] == a[2][2]) {
                    if (a[0][0] == 1) {
                        if (roundinprogress < MainActivity.rounds) {
                            Toast.makeText(getContext(), "\" X \" has WON this round", Toast.LENGTH_SHORT).show();
                        }
                        chance = 1;
                        gameover = true;
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                a[i][j] = -1;
                            }
                        }
                        roundswonbyX++;
                        players2activity.roundswonbyxtv.setText(roundswonbyX + "");
                        roundinprogress++;
                        postInvalidate();
                    } else if (a[0][0] == 0) {
                        if (roundinprogress < MainActivity.rounds) {
                            Toast.makeText(getContext(), "\" O \" has WON this round", Toast.LENGTH_SHORT).show();
                        }
                        chance = 1;
                        gameover = true;
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                a[i][j] = -1;
                            }
                        }
                        roundswonbyO++;
                        players2activity.roundswonbyotv.setText("" + roundswonbyO);
                        roundinprogress++;
                        postInvalidate();
                    }
                }
                if (a[0][2] == a[1][1] && a[1][1] == a[2][0]) {
                    if (a[0][2] == 1) {
                        if (roundinprogress < MainActivity.rounds) {
                            Toast.makeText(getContext(), "\" X \" has WON this round", Toast.LENGTH_SHORT).show();
                        }
                        chance = 1;
                        gameover = true;
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                a[i][j] = -1;
                            }
                        }
                        roundswonbyX++;
                        players2activity.roundswonbyxtv.setText(roundswonbyX + "");
                        roundinprogress++;
                        postInvalidate();
                    } else if (a[0][2] == 0) {
                        if (roundinprogress < MainActivity.rounds) {
                            Toast.makeText(getContext(), "\" O \" has WON this round", Toast.LENGTH_SHORT).show();
                        }
                        chance = 1;
                        gameover = true;
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                a[i][j] = -1;
                            }
                        }
                        roundswonbyO++;
                        players2activity.roundswonbyotv.setText("" + roundswonbyO);
                        roundinprogress++;
                        postInvalidate();
                    }
                }


                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (a[i][j] != -1) {
                            count++;
                        }
                    }
                }
                if (count < 9) {
                    count = 0;
                } else if (count == 9) {
                    count=0;
                    if (roundinprogress < MainActivity.rounds) {
                        Toast.makeText(getContext(), "It was a DRAW", Toast.LENGTH_SHORT).show();
                    }
                    chance = 1;
                    gameover = true;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            a[i][j] = -1;
                        }
                    }
                    roundinprogress++;
                    postInvalidate();
                }


                if (roundinprogress > MainActivity.rounds) {
                    if (roundswonbyX > roundswonbyO) {
                        Toast.makeText(getContext(), "Player 'X' has won the game😀😀", Toast.LENGTH_LONG).show();
                        mediaPlayerx = MediaPlayer.create(getContext(), R.raw.leopard3);

                        mediaPlayerx.start();
                    } else if (roundswonbyX < roundswonbyO) {
                        Toast.makeText(getContext(), "Player 'O' has won the game😀😀", Toast.LENGTH_LONG).show();
                        mediaPlayero = MediaPlayer.create(getContext(), R.raw.cuckoo);

                        mediaPlayero.start();
                    } else {
                        Toast.makeText(getContext(), "It's a DRAW", Toast.LENGTH_LONG).show();
                        tie = MediaPlayer.create(getContext(), R.raw.alarm);

                        tie.start();

                    }

                }

        }


        return true;

    }

}


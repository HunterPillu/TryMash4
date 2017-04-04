package com.studio.trymash.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.studio.trymash.R;
import com.studio.trymash.utils.CircularProgressBar;
import com.studio.trymash.utils.Constant;
import com.studio.trymash.utils.Fruits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int ran = 0;
    //public  int fetch = 0;
    public RelativeLayout rlGameLayout = null;
    public static String selected = null;
    public static ArrayList selectedFruitArr = new ArrayList();
    public static HashMap fruitsMap = new HashMap();
    public static ImageView iv = null;
    public static ImageView chImage1 = null;
    public static ImageView chImage2 = null;
    public static ImageView chImage3 = null;
    public static ImageView chImage4 = null;
    public static ImageView buciv = null;
    public static ImageView aiv = null;
    public static TextView tv = null;
    //public static TextView tvTimer = null;
    public static Boolean pause = false;
    public static int width = 0;
    public static int height = 0;
    public static int mcount = 0;
    public static int level = 2;
    //static int score=0;
    public static int a = 0;
    public static MainActivity act = null;
    public MediaPlayer bgsong = null;
    public static MediaPlayer ssong = null;
    public static MediaPlayer csong = null;
    public static CircularProgressBar cpbProgress = null;
    static Boolean sound = true;
    private CountDownTimer cntTimer;
    private Thread addFruitThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //change here....
        //change from studio...
        width = getWidth(getBaseContext());
        height = getHeight(getBaseContext());
        if (sound) {
            bgsong = MediaPlayer.create(MainActivity.this, R.raw.bgsound);
            bgsong.start();
        }
        act = this;
        rlGameLayout = (RelativeLayout) findViewById(R.id.rlGameLayout);
        cpbProgress = (CircularProgressBar) findViewById(R.id.cpProgress);
        iv = (ImageView) findViewById(R.id.iv);
        buciv = (ImageView) findViewById(R.id.buciv);
        aiv = (ImageView) findViewById(R.id.aiv);
        tv = (TextView) findViewById(R.id.tv);
       /* tvTimer = (TextView) findViewById(R.id.tvTimer);
        tvTimer.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (!pause) {
                    pause = true;
                    if (sound) {
                        bgsong.stop();
                    }
                } else {
                    pause = false;
                    if (sound) {
                        bgsong = MediaPlayer.create(MainActivity.this, R.raw.bgsound);
                        bgsong.start();
                    }
                }
            }
        });*/

        fruitsMap.put(Constant.APPLE, R.drawable.apple);
        fruitsMap.put(Constant.ORANGE, R.drawable.orange);
        fruitsMap.put(Constant.STRAWBERRY, R.drawable.strawberry);
        fruitsMap.put(Constant.MANGO, R.drawable.shalu);
        fruitsMap.put(Constant.GRAPES, R.drawable.grapes);
        fruitsMap.put(Constant.PEAR, R.drawable.pear);
        fruitsMap.put(Constant.LICHEE, R.drawable.lichee);
        fruitsMap.put(Constant.ANAR, R.drawable.anar);

       /* start adding Fruit object */
        addFruits();

        //Start timer for progress bar
        cntTimer = new CountDownTimer(Constant.TOTAL_GAME_TIME_IN_SECOND * Constant.ONE_SECOND_IN_MS, Constant.ONE_SECOND_IN_MS) {

            public void onTick(long millisUntilFinished) {
                // this will run after every second -- update progress bar
                int sec = (int) ((millisUntilFinished / 1000) % 60);
                MainActivity.cpbProgress.setProgress(sec);
                if (sec == 1) {
                    Toast.makeText(getApplicationContext(), Constant.TIME_UP, Toast.LENGTH_SHORT).show();//////..........not working............///////
                }
            }

            public void onFinish() {
                //on timer ends cancel countDownTimer ,finish this screen and go to previous screen
                cntTimer.cancel();
                finish();
            }
        }.start();
    }

    private void addFruits() {
        addFruitThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (!pause) {
                        ran = new Random().nextInt(6);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                switch (ran) {
                                    case 0:
                                        rlGameLayout.addView(new Fruits.Apple(getApplicationContext()));
                                        break;
                                    case 1:
                                        rlGameLayout.addView(new Fruits.Orange(getApplicationContext()));
                                        break;
                                    case 2:
                                        rlGameLayout.addView(new Fruits.Strawberry(getApplicationContext()));
                                        break;
                                    case 3:
                                        rlGameLayout.addView(new Fruits.Grapes(getApplicationContext()));
                                        break;
                                    case 4:
                                        rlGameLayout.addView(new Fruits.Mango(getApplicationContext()));
                                        break;
                                    case 5:
                                        rlGameLayout.addView(new Fruits.Pear(getApplicationContext()));
                                        break;
                                    case 6:
                                        rlGameLayout.addView(new Fruits.Lichee(getApplicationContext()));
                                        break;
                                    case 7:
                                        rlGameLayout.addView(new Fruits.Anar(getApplicationContext()));
                                        break;
                                }
                            }
                        });
                    }
                    try {
                        //stop thread for half second ,so next fruit object will be added after half second
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        addFruitThread.start();
    }

    @SuppressLint("NewApi")
    public int getWidth(Context mContext) {
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        return width;
    }

    @SuppressLint("NewApi")
    public int getHeight(Context mContext) {
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int height = size.y;
        return height;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        int var = item.getItemId();

        switch (var) {
            case R.id.m1: {
                Intent in = new Intent(getApplicationContext(), SoundSettingsActivity.class);
                startActivity(in);
                break;
            }
            case R.id.m2: {
                Intent in2 = new Intent(getApplicationContext(), HelpActivity.class);
                startActivity(in2);
                break;
            }
            case R.id.m3: {
                //Intent in=new Intent(getApplicationContext(), AboutUs.class);
                //startActivity(in);
                finish();
                System.exit(0);
                break;
            }
        }
        return super.onOptionsItemSelected(item);


    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
       /* bgsong.release();
        finish();
        ssong.release();
        finish();
        csong.release();
        finish();*/
    }
}

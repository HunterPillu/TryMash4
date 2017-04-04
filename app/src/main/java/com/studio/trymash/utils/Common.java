///android gmap api v2
//go first link
//get stratted
//go debug....somthing option......
///copy a cmd into notepad
//then paste the our eclipse debug key store path into "  " and then edited cmd run on cmd prompt

//open google api consol.....
//go net create project
//project name   then go further and google map android api v2
//then go again up and go to API Access ......go to eclipse and create proj for using GApi......Go to ...create new android key....then paste  here shai   into a blang space then add semicolon....and then write hereour package name....  click and then we get our google android Api key... 
//add api key to our aap
//copy  
//go aap ,,manifest......application...copy metadata....copy Api key here in name att
//then copy permissions from net...and paste into manifest....
//copy user feature...
//paste in manifest....
//now for adding map;
//copy fragment tag and paste into the aap.....xml file...
///open android sdk manager...go extra library...go to google play services...if not then import from...folder..
//google play services_lib....import....
//eclips debug store...
package com.studio.trymash.utils;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.studio.trymash.R;
import com.studio.trymash.activity.EndActivity;
import com.studio.trymash.activity.MainActivity;

class Common extends ImageView {
    Handler handle = null;
    Context cont = null;
    int num = 0;

    public Common(Context context) {
        super(context);
        cont = context;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(48, 48);
        setLayoutParams(layoutParams);
        handle = new Handler();
        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= MainActivity.height / 2 - 60; i++) {
                    if (!MainActivity.pause) {

                        handle.post(new Runnable() {

                            @Override
                            public void run() {
                                // TODO Auto-generated method stub
                                setY(getY() + 2);
                            }

                        });
                    } else {
                        i--;
                    }
                    try {
                        Thread.sleep(25);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }

                if (MainActivity.selectedFruitArr.contains(Common.this)) {
                    handle.post(new Runnable() {
                        @Override
                        public void run() {
                            //Toast.makeText(cont, "Selected", Toast.LENGTH_SHORT).show();
                            MainActivity.selectedFruitArr.remove(Common.this);
                            MainActivity.selected = null;  //////////for removing select item//
                            if ((MainActivity.selectedFruitArr.size()) == 1) {
                                MainActivity.iv.setBackgroundResource(R.drawable.bg11);
                            }
                            if ((MainActivity.selectedFruitArr.size()) == 2) {
                                MainActivity.iv.setBackgroundResource(R.drawable.bg22);
                            }
                            if ((MainActivity.selectedFruitArr.size()) == 0) {
                                MainActivity.iv.setBackgroundResource(R.drawable.blankbg);
                                MainActivity.iv.setImageDrawable(null);
                            }
                        }
                    });
                }
                handle.post(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        Common.this.setVisibility(View.GONE);
                    }
                });
            }
        }.start();

        setOnClickListener(new OnClickListener() {

                               @Override
                               public void onClick(View arg0) {
                                   // TODO Auto-generated method stub
                                   ImageView img = (ImageView) arg0;
                                   MainActivity.ssong = MediaPlayer.create(cont, R.raw.blop);
                                   MainActivity.ssong.start();

                                   if (MainActivity.selected != null) {
                                       if (!(MainActivity.selected.equals(img.getTag().toString()))) {

                                           MainActivity.a--;
                                           MainActivity.tv.setText(Constant.SCORE + MainActivity.a);

                                           for (int i = 0; i < MainActivity.selectedFruitArr.size(); i++) {
                                               ImageView chImage = (ImageView) MainActivity.selectedFruitArr.get(i);
                                               chImage.setImageResource(Integer.parseInt(MainActivity.fruitsMap.get(MainActivity.selected).toString()));
                                           }
                                           MainActivity.selectedFruitArr.removeAll(MainActivity.selectedFruitArr);
                                           MainActivity.selected = img.getTag().toString();
                                           MainActivity.selectedFruitArr.add(img);

                                       } else {
                                           if (MainActivity.selected.equals(img.getTag().toString())) {
                                               if (!MainActivity.selectedFruitArr.contains(img)) {
                                                   MainActivity.selectedFruitArr.add(img);
                                               }
                                           }
                                       }


                                   } else {
                                       MainActivity.selected = img.getTag().toString();
                                       if (!MainActivity.selectedFruitArr.contains(img)) {
                                           MainActivity.selectedFruitArr.add(img);
                                       }
                                   }

                                   int acount = MainActivity.selectedFruitArr.size();
                                   if (acount == 1) {
                                       ImageView let1 = (ImageView) MainActivity.selectedFruitArr.get(0);
                                       MainActivity.iv.setBackgroundResource(R.drawable.bg11);
                                   }
                                   if (acount == 2) {
                                       ImageView let1 = (ImageView) MainActivity.selectedFruitArr.get(0);
                                       MainActivity.iv.setBackgroundResource(R.drawable.bg22);
                                   }
                                   if (acount == 3) {
                                       ImageView let1 = (ImageView) MainActivity.selectedFruitArr.get(0);
                                       MainActivity.iv.setBackgroundResource(R.drawable.bg33);
                                   }
                                   MainActivity.iv.setImageResource(Integer.parseInt(MainActivity.fruitsMap.get(MainActivity.selected).toString()));

                                   //////////////////////////////////////main logic\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

                                   if (MainActivity.selectedFruitArr.size() == 3) {
                                       MainActivity.selected = null;
                                       MainActivity.chImage1 = (ImageView) MainActivity.selectedFruitArr.get(0);
                                       MainActivity.chImage2 = (ImageView) MainActivity.selectedFruitArr.get(1);
                                       MainActivity.chImage3 = (ImageView) MainActivity.selectedFruitArr.get(2);

                                       Animation anim1 = AnimationUtils.loadAnimation(getContext(), R.anim.splash3anim);
                                       MainActivity.chImage1.startAnimation(anim1);
                                       MainActivity.chImage2.startAnimation(anim1);
                                       MainActivity.chImage3.startAnimation(anim1);
                                       anim1.setAnimationListener(new AnimationListener() {
                                           @Override
                                           public void onAnimationStart(Animation arg0) {
                                               // TODO Auto-generated method stub
                                               MainActivity.iv.setBackgroundResource(R.drawable.bg33);
                                               MainActivity.chImage1.setImageResource(R.drawable.crush);
                                               MainActivity.chImage2.setImageResource(R.drawable.crush);
                                               MainActivity.chImage3.setImageResource(R.drawable.crush);
                                           }

                                           @Override
                                           public void onAnimationRepeat(Animation arg0) {
                                               // TODO Auto-generated method stub

                                           }

                                           @Override
                                           public void onAnimationEnd(Animation arg0) {
                                               // TODO Auto-generated method stub
                                               MainActivity.iv.setBackgroundResource(R.drawable.blankbg);
                                               MainActivity.iv.setImageDrawable(null);
                                               MainActivity.chImage1.setImageDrawable(null);
                                               MainActivity.chImage2.setImageDrawable(null);
                                               MainActivity.chImage3.setImageDrawable(null);
                                           }
                                       });

                                       MainActivity.selectedFruitArr.removeAll(MainActivity.selectedFruitArr);
                                       MainActivity.csong = MediaPlayer.create(cont, R.raw.crushs);
                                       MainActivity.csong.start();
                                       MainActivity.mcount++;
                                       Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.myanim);
                                       MainActivity.aiv.startAnimation(anim);
                                       anim.setAnimationListener(new AnimationListener() {

                                           @Override
                                           public void onAnimationStart(Animation arg0) {
                                               // TODO Auto-generated method stub
                                               MainActivity.aiv.setImageResource(R.drawable.finalarrow);
                                           }

                                           @Override
                                           public void onAnimationRepeat(Animation arg0) {
                                               // TODO Auto-generated method stub

                                           }

                                           @Override
                                           public void onAnimationEnd(Animation arg0) {
                                               // TODO Auto-generated method stub
                                               MainActivity.aiv.setImageDrawable(null);
                                               MainActivity.a = MainActivity.a + 20;
                                               if (MainActivity.mcount == 1) {
                                                   MainActivity.buciv.setBackgroundResource(R.drawable.one);
                                               }
                                               if (MainActivity.mcount == 2) {
                                                   MainActivity.buciv.setBackgroundResource(R.drawable.two);
                                                   //MainActivity.tv.setText("Score : 20");
                                               }
                                               if (MainActivity.mcount == 3) {
                                                   MainActivity.buciv.setBackgroundResource(R.drawable.three);
                                               }
                                               if (MainActivity.mcount == 4) {
                                                   MainActivity.buciv.setBackgroundResource(R.drawable.four);
                                                   //MainActivity.tv.setText("Score : 30");
                                               }
                                               if (MainActivity.mcount == 5) {
                                                   MainActivity.buciv.setBackgroundResource(R.drawable.five);
                                                   //MainActivity.tv.setText("Score : 30");
                                               }
                                               if (MainActivity.mcount == 6) {
                                                   MainActivity.buciv.setBackgroundResource(R.drawable.six);
                                                   //MainActivity.tv.setText("Score : 30");
                                               }
                                               if (MainActivity.mcount == 7) {
                                                   MainActivity.buciv.setBackgroundResource(R.drawable.seven);
                                                   //MainActivity.tv.setText("Score : 30");
                                               }
                                               if (MainActivity.mcount == 8) {
                                                   MainActivity.buciv.setBackgroundResource(R.drawable.eight);
                                                   //MainActivity.tv.setText("Score : 30");

                                                   if (MainActivity.level == 2) {
                                                       Toast t1 = Toast.makeText(cont, Constant.GAME_OVER, Toast.LENGTH_SHORT);
                                                       t1.show();
                                                       Intent nin = new Intent(cont, EndActivity.class);
                                                       nin.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                       cont.startActivity(nin);
                                                       MainActivity.act.finish();
                                                   }
                                               }
                                               MainActivity.tv.setText(Constant.SCORE + MainActivity.a);
                                           }
                                       });

                                   }

                                   ///////////////////////////////////////main logic////////////////////////////////////////////////////////////
                                   if (img.getTag() == Constant.APPLE) {
                                       //String astr=img.getTag().toString();
                                       setImageResource(R.drawable.smallappbck);
                                   } else if (img.getTag() == Constant.ORANGE) {
                                       setImageResource(R.drawable.orangebackground);
                                       //MainActivity.iv.setImageResource(R.drawable.apple);
                                   } else if (img.getTag() == Constant.STRAWBERRY) {
                                       setImageResource(R.drawable.strawberrybackground);
                                       //MainActivity.iv.setImageResource(R.drawable.apple);
                                   } else if (img.getTag() == Constant.GRAPES) {
                                       setImageResource(R.drawable.grapesbackground);
                                       //MainActivity.iv.setImageResource(R.drawable.apple);
                                   } else if (img.getTag() == Constant.MANGO) {
                                       setImageResource(R.drawable.mangobackground);
                                       //MainActivity.iv.setImageResource(R.drawable.apple);
                                   } else if (img.getTag() == Constant.PEAR) {
                                       setImageResource(R.drawable.pearback);
                                       //MainActivity.iv.setImageResource(R.drawable.apple);
                                   } else if (img.getTag() == Constant.LICHEE) {
                                       setImageResource(R.drawable.licheeback);
                                       //MainActivity.iv.setImageResource(R.drawable.apple);
                                   } else if (img.getTag() == Constant.ANAR) {
                                       setImageResource(R.drawable.anarback);
                                       //MainActivity.iv.setImageResource(R.drawable.apple);
                                   }
                               }
                           }
        );
    }
}
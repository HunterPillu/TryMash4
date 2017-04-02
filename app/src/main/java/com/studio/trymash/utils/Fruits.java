package com.studio.trymash.utils;

import android.content.Context;

import com.studio.trymash.R;
import com.studio.trymash.activity.MainActivity;

import java.util.Random;

/**
 * Created by WarFly on 4/2/2017.
 */

public class Fruits {
    public static class Apple extends Common {

        public Apple(Context context) {
            super(context);
            setImageResource(R.drawable.apple);
            int r = new Random().nextInt(MainActivity.width - 50);
            setY(0);
            setX(r);
            setTag(Constant.APPLE);
            // TODO Auto-generated constructor stub
        }
    }

    public static class Orange extends Common {

        public Orange(Context context) {
            super(context);
            setImageResource(R.drawable.orange);
            int r = new Random().nextInt(MainActivity.width - 50);
            setY(0);
            setX(r);
            setTag(Constant.ORANGE);
            // TODO Auto-generated constructor stub
        }
    }

    public static class Strawberry extends Common {

        public Strawberry(Context context) {
            super(context);
            setImageResource(R.drawable.strawberry);
            int r = new Random().nextInt(MainActivity.width - 50);
            setY(0);
            setX(r);
            setTag(Constant.STRAWBERRY);
            // TODO Auto-generated constructor stub
        }
    }

    public static class Grapes extends Common {
        public Grapes(Context context) {
            super(context);
            setImageResource(R.drawable.grapes);
            int r = new Random().nextInt(MainActivity.width - 50);
            setY(0);
            setX(r);
            setTag(Constant.GRAPES);
            // TODO Auto-generated constructor stub
        }
    }

    public static class Mango extends Common {

        public Mango(Context context) {
            super(context);
            setImageResource(R.drawable.shalu);
            int r = new Random().nextInt(MainActivity.width - 50);
            setY(0);
            setX(r);
            setTag(Constant.MANGO);
            // TODO Auto-generated constructor stub
        }
    }

    public static class Anar extends Common {

        public Anar(Context context) {
            super(context);
            setImageResource(R.drawable.anar);
            int r = new Random().nextInt(MainActivity.width - 50);
            setY(0);
            setX(r);
            setTag(Constant.ANAR);
            // TODO Auto-generated constructor stub
        }
    }

    public static class Lichee extends Common {

        public Lichee(Context context) {
            super(context);
            setImageResource(R.drawable.lichee);
            int r = new Random().nextInt(MainActivity.width - 50);
            setY(0);
            setX(r);
            setTag(Constant.LICHEE);
            // TODO Auto-generated constructor stub
        }
    }

    public static class Pear extends Common {

        public Pear(Context context) {
            super(context);
            setImageResource(R.drawable.pear);
            int r = new Random().nextInt(MainActivity.width - 50);
            setY(0);
            setX(r);
            setTag(Constant.PEAR);
            // TODO Auto-generated constructor stub
        }
    }
}


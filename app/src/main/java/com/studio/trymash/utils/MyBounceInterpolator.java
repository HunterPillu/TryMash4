package com.studio.trymash.utils;

import android.view.animation.Interpolator;


/**
 * Created by desktop on 27-03-2017.
 */

public class MyBounceInterpolator implements Interpolator {
    double mAmplitude = 1;
    double mFrequency = 10;

    public MyBounceInterpolator(double amplitude, double frequency) {
        mAmplitude = amplitude;
        mFrequency = frequency;
    }

    public float getInterpolation(float time) {
        double amplitude = mAmplitude;
        if (amplitude == 0) { amplitude = 0.05; }

        // The interpolation curve equation:
        //    -e^(-time / amplitude) * cos(frequency * time) + 1
        //
        // View the graph live: https://www.desmos.com/calculator/6gbvrm5i0s
        return (float) (-1 * Math.pow(Math.E, -time/ mAmplitude) * Math.cos(mFrequency * time) + 1);
    }
}

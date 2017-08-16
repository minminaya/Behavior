package com.minminaya.coordinatebehavior.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;

/** 第二种方法，互相
 * Created by Niwa on 2017/8/16.
 */

public class CustomBehavior2 extends CoordinatorLayout.Behavior<View> {
    /**
     * 滑动距离累加值
     */
    private int directionChange = 0;

    public CustomBehavior2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {

        float translationY = Math.abs(dependency.getY());
        //移动
        child.setTranslationY(translationY);
        return true;
    }

}

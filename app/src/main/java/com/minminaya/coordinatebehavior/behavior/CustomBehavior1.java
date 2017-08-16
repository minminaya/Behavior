package com.minminaya.coordinatebehavior.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;

/**
 * Created by Niwa on 2017/8/16.
 */

public class CustomBehavior1 extends CoordinatorLayout.Behavior<View> {
    /**
     * 滑动距离累加值
     */
    private int directionChange = 0;

    public CustomBehavior1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        if (dy > 0 && directionChange < 0 || dy < 0 && directionChange > 0) {

            child.animate().cancel();
            Log.e("CustomBehavior1", "reset");
            //dy是一直刷新的，累加值会一直加到很大或者很小，这里累加值归零0的触发条件是
            // 1.向上滑，并且累加值是负的（说明上次滑动是向下）
            //2.向下滑，并且累加值是正的（说明上次滑动是向上）
            directionChange = 0;
        }
        directionChange += dy;
        Log.e("CustomBehavior1", "dy:" + dy);
        Log.e("CustomBehavior1", "directionChange:" + directionChange);

        if (directionChange > child.getHeight()) {
            Log.e("CustomBehavior1", "上滑");
            hide(child);
        }
        if (directionChange < 0) {
            Log.e("CustomBehavior1", "下滑");
            show(child);
        }
    }


    private void show(final View child) {
        Log.e("CustomBehavior1", "show");
        final ViewPropertyAnimator animator = child.animate()
                .translationY(0)
                .setInterpolator(new FastOutSlowInInterpolator())
                .setDuration(200);
        animator.start();
    }

    private void hide(final View child) {
        final ViewPropertyAnimator animator = child.animate()
                .translationY(child.getHeight())
                .setInterpolator(new FastOutSlowInInterpolator())
                .setDuration(200);
        animator.start();
    }
}

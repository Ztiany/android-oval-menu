package com.ztiany.ovalmenu;

import android.graphics.PointF;


/**
 * Author Ztiany                   <br/>
 * Email ztiany3@gmail.com      <br/>
 * Date 2016-04-23 18:17      <br/>
 * Description：
 */
public class OvalMath {
    private static final String TAG = OvalMath.class.getSimpleName();
    private float mA;
    private float mB;

    private float mCenterX;
    private float mCenterY;

    boolean isChanged;

    OvalMath() {

    }

    public void initSize(float a, float b, float centerX, float centerY) {
        if (mA != a || mB != b || mCenterX != centerX || mCenterY != centerY) {
            isChanged = true;
        } else {
            isChanged = false;
            return;
        }

        mA = a;
        mB = b;
        mCenterX = centerX;
        mCenterY = centerY;
    }

    public void calcPoint(float angle, PointF pointF) {
        float newX = (float) (Math.cos(Math.toRadians(angle)) * mA + mCenterX);
        float newY = (float) (Math.sin(Math.toRadians(angle)) * mB + mCenterY);
        pointF.set(newX, newY);
    }

    /**
     * 根据触摸的位置，计算角度
     *
     * @param xTouch
     * @param yTouch
     * @return
     */
    public float getAngle(float xTouch, float yTouch) {
        double x = xTouch - (mCenterX);
        double y = yTouch - (mCenterY);
        return (float) (Math.asin(y / Math.hypot(x, y)) * 180 / Math.PI);
    }


}

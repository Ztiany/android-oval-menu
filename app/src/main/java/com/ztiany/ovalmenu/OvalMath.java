package com.ztiany.ovalmenu;

import android.graphics.PointF;


public class OvalMath {

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
     * @param xTouch x点
     * @param yTouch y点
     * @return 角度
     */
    public float getAngle(float xTouch, float yTouch) {
        double x = xTouch - (mCenterX);
        double y = yTouch - (mCenterY);
        return (float) (Math.asin(y / Math.hypot(x, y)) * 180 / Math.PI);
    }

}

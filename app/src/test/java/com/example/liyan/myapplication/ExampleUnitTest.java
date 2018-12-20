package com.example.liyan.myapplication;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    int mInt;
    int mCopy = mInt;

    public int getInt() {
        return mInt;
    }

    public void setInt(int anInt) {
        mInt = anInt;
    }

    @Test
    public void addition_isCorrect() {
        System.out.print("before mInt = " + mInt);
        System.out.print("before mCopy = " + mCopy);

        setInt(100);
        System.out.print("after mInt = " + mInt);
        System.out.print("after mCopy = " + mCopy);
    }

}
package com.bignerdranch.android.criminalintent;

import android.text.format.DateFormat;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Jacob on 2/23/2016.
 */
public class Crime {
    private UUID mID;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    DateFormat dateFormat;

    public Crime() {
        mID = UUID.randomUUID();
        mDate = new Date();
        dateFormat = new DateFormat();
    }

    public UUID getID() {
        return mID;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}

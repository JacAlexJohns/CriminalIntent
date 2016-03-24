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
    private String mSuspect;
    private Long suspectID;

    public Crime() {
        this(UUID.randomUUID());
        dateFormat = new DateFormat();
    }

    public Crime(UUID id) {
        mID = id;
        mDate = new Date();
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

    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String suspect) {
        mSuspect = suspect;
    }

    public Long getSuspectID() {
        return suspectID;
    }

    public void setSuspectID(Long suspectID) {
        this.suspectID = suspectID;
    }

    public String getPhotoFilename() {
        return "IMG_" + getID().toString() + ".jpg";
    }
}

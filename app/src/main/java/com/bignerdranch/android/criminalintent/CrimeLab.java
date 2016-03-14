package com.bignerdranch.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

/**
 * Created by Jacob on 2/29/2016.
 */
public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private Stack<Crime> CRIME_STACK = new Stack<>();

    private List<Crime> mCrimes;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
    }

    public void addCrime(Crime c) {
        mCrimes.add(c);
    }

    public void delCrime(Crime c) {
        CRIME_STACK.push(c);
        mCrimes.remove(c);
    }

    public Crime undoDel() {
        if (CRIME_STACK.size() < 1) {
            return null;
        }
        Crime c = CRIME_STACK.pop();
        return c;
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getID().equals(id)) {
                return crime;
            }
        }
        return null;
    }
}

package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import java.util.Date;

/**
 * Created by Jacob on 3/12/2016.
 */
public class SureDeleteFragment extends DialogFragment {

    public static final String EXTRA_DELETE =
            "com.bignerdranch.android.criminalintent.delete";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.sure_delete_title)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sendNewResult(Activity.RESULT_OK, true);
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sendNewResult(Activity.RESULT_OK, false);
                    }
                })
                .create();
    }

    private void sendNewResult(int resultCode, boolean toDelete) {
        if (getTargetFragment() == null) {
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_DELETE, toDelete);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }

}

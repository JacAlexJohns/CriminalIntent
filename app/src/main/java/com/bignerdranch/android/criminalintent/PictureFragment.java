package com.bignerdranch.android.criminalintent;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by Jacob on 3/14/2016.
 */
public class PictureFragment extends DialogFragment {

    private static final String ARG_IMAGE = "image";

    public static PictureFragment newInstance(File image) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_IMAGE, image);

        PictureFragment fragment = new PictureFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        File imageFile = (File) getArguments().getSerializable(ARG_IMAGE);

        Bitmap imagePhoto = PictureUtils.getScaledBitmap(imageFile.getPath(), getActivity());

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_image, null);

        ImageView mImageView = (ImageView) v.findViewById(R.id.dialog_image_view);
        mImageView.setImageBitmap(imagePhoto);

        return new AlertDialog.Builder(getActivity())
                .setView(mImageView)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }

}

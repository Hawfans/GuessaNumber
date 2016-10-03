package com.algonquincollege.medh0003.guessanumber;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Medhurst on 2016-09-29.
 */

public class AboutDialogFragment extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("About")
                .setMessage("David Medhurt (medh0003)")
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
            }
        });

        return builder.create();
    }
}

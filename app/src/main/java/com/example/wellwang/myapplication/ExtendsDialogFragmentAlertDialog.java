package com.example.wellwang.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Well Wang on 2017/12/30.
 */

public class ExtendsDialogFragmentAlertDialog extends DialogFragment {

    EditText mUser;
    EditText mPass;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.alertdialog,null);
        mUser = (EditText) view.findViewById(R.id.user_edit);
        mPass = (EditText) view.findViewById(R.id.pass_edit);
        builder.setView(view)
                .setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LoginInputListener listener = (LoginInputListener) getActivity();
                        listener.onLoginInputComplete(mUser
                                .getText().toString(), mPass
                                .getText().toString());
                    }
                }).setNegativeButton("Cancel",null);
        return builder.create();
    }
}

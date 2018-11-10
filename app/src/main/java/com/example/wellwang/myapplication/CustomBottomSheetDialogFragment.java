package com.example.wellwang.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jdsm on 2018/1/24.
 */

public class CustomBottomSheetDialogFragment extends BottomSheetDialogFragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("sffef","zzzz");

        String tag=getTag();
        Log.d("sffef","tag="+tag);
        View view=null;
        if (tag.equals("adc")){
             view=inflater.inflate(R.layout.bottom_sheet1,null);
        }else if (tag.equals("dialog")){
             view=inflater.inflate(R.layout.bottom_sheet,null);
        }
//        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
//
//        dialog.setContentView(view);
//
//        ((View) view.getParent()).setBackgroundColor(getResources().getColor(android.R.color.transparent));


        return view;
    }
}
package com.example.wellwang.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



    }

    @OnClick({R.id.button_dialog1, R.id.button_dialog2, R.id.button_dialog3, R.id.button_dialog4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_dialog1:
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
                break;
            case R.id.button_dialog2:
                ExtendsDialog dialog=new ExtendsDialog(this);
                dialog.setContentView(R.layout.extendsdialog_dialog);
                dialog.show();
                break;
            case R.id.button_dialog3:
                ExtendsDialogFragment dialogFragment=new ExtendsDialogFragment();
                dialogFragment.show(getFragmentManager(),"dd");
                break;
            case R.id.button_dialog4:
                break;
        }
    }
}

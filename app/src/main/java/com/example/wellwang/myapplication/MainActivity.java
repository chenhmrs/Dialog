package com.example.wellwang.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity implements LoginInputListener {
    ExtendsDialogFragment dialogFragment;
    BottomSheetBehavior behavior;
    @BindView(R.id.bottom_sheet)
    Button mShowBottomSheet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
       dialogFragment= new ExtendsDialogFragment();

        //获取到Bottom Sheet对象
        View bottomSheet = findViewById(R.id.design_bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
        //默认设置为隐藏
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);

    }

    @OnClick({R.id.button_dialog1, R.id.button_dialog2, R.id.button_dialog3, R.id.button_dialog4,R.id.bottom_sheet,R.id.dialogfragment_sheet})
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
                Log.d("MainActivity","1"+dialogFragment.isAdded());
                dialogFragment.show(getFragmentManager(),"dd");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            sleep(3000);
                        }catch (Exception e){

                        }finally {
                            Log.d("MainActivity","2"+dialogFragment.isAdded());
                           // dialogFragment.show(getFragmentManager(),"dd");这样就会重复添加了
                        }
                    }
                }).start();
                break;
            case R.id.button_dialog4:
                ExtendsDialogFragmentAlertDialog dialog1=new ExtendsDialogFragmentAlertDialog();
                dialog1.show(getFragmentManager(),"dialogLogin");
                break;
            case R.id.bottom_sheet:
                if (behavior.getState() == BottomSheetBehavior.STATE_HIDDEN) {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    mShowBottomSheet.setText("hide");
                } else {
                    behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                    mShowBottomSheet.setText("show");
                }
                break;
            case R.id.dialogfragment_sheet:
                CustomBottomSheetDialogFragment fragment=new CustomBottomSheetDialogFragment();
                fragment.show(getSupportFragmentManager(),"dialog");
                break;
        }

    }

    @Override
    public void onLoginInputComplete(String username, String password) {
        Toast.makeText(this, "帐号：" + username + ",  密码 :" + password,
                Toast.LENGTH_SHORT).show();
    }
}

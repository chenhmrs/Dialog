package com.example.wellwang.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Well Wang on 2017/12/27.
 */

public class DialogActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_main);
        ButterKnife.bind(this);
        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay(); // 为获取屏幕宽、高
        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.height = (int) (d.getHeight() * 0.7); // 高度设置为屏幕的0.7,高度设小了导致下方布局显示不出来
        p.width = (int) (d.getWidth() * 0.7); // 宽度设置为屏幕的0.7
        //默认已上下，左右居中，除非特殊需求改
        p.gravity = Gravity.CENTER;
        getWindow().setAttributes(p);
    }

    @OnClick({R.id.apply_close_btn, R.id.apply_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.apply_close_btn:
            case R.id.apply_ok:
                finish();
                break;
        }
    }
}

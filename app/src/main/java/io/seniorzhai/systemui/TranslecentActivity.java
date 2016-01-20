package io.seniorzhai.systemui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TranslecentActivity extends AppCompatActivity {

    private View root;
    private TextView log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        root = findViewById(R.id.root);
        log = (TextView) findViewById(R.id.log);
        show2(null);
//        setTranslucentStatus(true);
    }

    /*
     *  Android 4.1 API level 16以后，可以使用setSystemUiVisibility来隐藏statusbar
     *  对于一个Activity Flag是唯一的，切换后会被清除
     *  要实现内容在statusbar下面，且statusbar切换时不影响内容区域，需要使用SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
     *
     */

    public void toogleFits(View v) {
        root.setFitsSystemWindows(!root.getFitsSystemWindows());
        ((Button) v).setText("Frits:" + root.getFitsSystemWindows());
    }

    public void show1(View v) {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void show2(View v) {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_VISIBLE;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void hide1(View v) {
        View decorView = getWindow().getDecorView();
        int uiOptions =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |// hide nav bar
                        View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;// hide status bar

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            uiOptions |= View.SYSTEM_UI_FLAG_IMMERSIVE;
        }
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void hide2(View v) {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }


    public void clear(View v) {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_VISIBLE;
        decorView.setSystemUiVisibility(uiOptions);
        root.setPadding(0, 0, 0, 0);
    }

    public void logPadding(View v) {
        log.setText(
                String.format("Width:%d\tHeight%d\nPadding:Top:%d Bottom:%d Left:%d Right:%d",
                        root.getHeight(), root.getWidth(),
                        root.getPaddingTop(), root.getPaddingBottom(), root.getPaddingLeft(), root.getPaddingRight()));
    }

    public void next(View v) {
        startActivity(new Intent(this, FragmentActivity.class));
    }

//    private SystemBarTintManager tintManager;
//
//    protected void setTranslucentStatus(boolean on) {
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
//            Window win = getWindow();
//            win.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            tintManager = new SystemBarTintManager(this);
//            if (on) {
//                tintManager.setStatusBarTintEnabled(true);
//                tintManager.setNavigationBarTintEnabled(true);
//                tintManager.setStatusBarTintColor(Color.parseColor("#33333333"));
//                tintManager.setNavigationBarTintColor(Color.parseColor("#33333333"));
//            } else {
//                tintManager.setStatusBarTintEnabled(false);
//                tintManager.setNavigationBarTintEnabled(false);
//            }
//        }
//    }
}

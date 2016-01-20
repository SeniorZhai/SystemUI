package io.seniorzhai.systemui;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by zhai on 16/1/20.
 */
public class MyFragment extends Fragment {

    private View root;
    private TextView log;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment, container, false);
        log = (TextView) root.findViewById(R.id.log);
        root.findViewById(R.id.toogleFits).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toogleFits(v);
            }
        });
        root.findViewById(R.id.show1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show1(v);
            }
        });
        root.findViewById(R.id.hide1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide1(v);
            }
        });
        root.findViewById(R.id.show2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show2(v);
            }
        });
        root.findViewById(R.id.hide2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide2(v);
            }
        });
        root.findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear(v);
            }
        });
        root.findViewById(R.id.logPadding).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logPadding(v);
            }
        });
        return root;
    }

    public void toogleFits(View v) {
        root.setFitsSystemWindows(!root.getFitsSystemWindows());
        ((Button) v).setText("Frits:" + root.getFitsSystemWindows());
    }

    public void show1(View v) {
        View decorView = getActivity().getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void hide1(View v) {
        View decorView = getActivity().getWindow().getDecorView();
        int uiOptions =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |// hide nav bar
                        View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;// hide status bar

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            uiOptions |= View.SYSTEM_UI_FLAG_IMMERSIVE;
        }
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void hide2(View v) {
        View decorView = getActivity().getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void show2(View v) {
        View decorView = getActivity().getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_VISIBLE;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void clear(View v) {
        View decorView = getActivity().getWindow().getDecorView();
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
}

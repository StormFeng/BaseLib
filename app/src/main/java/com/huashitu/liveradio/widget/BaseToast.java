package com.huashitu.liveradio.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.huashitu.liveradio.R;

/**
 * Created by Administrator on 2016/11/10 0010.
 */

public class BaseToast{
    public static final int LENGTH_SHORT = Toast.LENGTH_SHORT;
    public static final int LENGTH_LONG = Toast.LENGTH_LONG;

    public static void show(Context context,String s) {
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.BOTTOM, 0, 50);// 位置会比原来的Toast偏上一些
        View toastRoot = LayoutInflater.from(context).inflate(R.layout.layout_basetoast, null);
        TextView toastTextField = (TextView) toastRoot.findViewById(R.id.tv);
        toast.setView(toastRoot);
        toastTextField.setText(s);
        toast.setDuration(LENGTH_SHORT);
        toast.show();
    }
}

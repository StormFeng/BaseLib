package com.huashitu.liveradio.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.apkfuns.logutils.LogUtils;
import com.huashitu.liveradio.R;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/27 0027.
 */

public class DialogSendMessage extends Dialog implements View.OnClickListener {

    @BindView(R.id.et_Content)
    EditText etContent;
    @BindView(R.id.btn_SendMessage)
    Button btnSendMessage;
    private Context context;
    private int[] location = new int[2];
    private int[] flag = new int[]{0,0};


    public DialogSendMessage(Context context) {
        super(context, R.style.aaa);
        init(context);
    }

    public DialogSendMessage(Context context, int themeResId) {
        super(context, R.style.bottom_dialog);
        init(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    }

    private void init(Context context) {
        this.context = context;
        Window w = this.getWindow();
        WindowManager.LayoutParams lp = w.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        w.setAttributes(lp);
        this.setCanceledOnTouchOutside(true);
        View v = View.inflate(context, R.layout.dialog_sendmessage, null);
        this.setContentView(v);
        ButterKnife.bind(this, v);
        btnSendMessage.setOnClickListener(this);
    }

    @Override
    public void show() {
        super.show();
        etContent.getLocationOnScreen(location);
    }

    public EditText getEtContent() {
        return etContent;
    }

    @Override
    public void onClick(View v) {
        InputMethodManager inputMethodManager=(InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        LogUtils.e(inputMethodManager.isAcceptingText());
        LogUtils.e(inputMethodManager.isActive());

    }
}
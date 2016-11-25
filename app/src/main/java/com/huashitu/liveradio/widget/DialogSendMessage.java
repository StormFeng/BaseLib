package com.huashitu.liveradio.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.huashitu.liveradio.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/27 0027.
 */

public class DialogSendMessage extends Dialog {

    @BindView(R.id.et_Content)
    EditText etContent;
    private Context context;

    public DialogSendMessage(Context context) {
        super(context, R.style.diy_dialog);
        init(context);
    }

    public DialogSendMessage(Context context, int themeResId) {
        super(context, R.style.bottom_dialog);
        init(context);
    }

    public DialogSendMessage(Context context, String title, String content, String imageUrl, String targetUrl) {
        super(context, R.style.bottom_dialog);
        init(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE |
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    private void init(Context context) {
        this.context = context;
        Window w = this.getWindow();
        WindowManager.LayoutParams lp = w.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        w.setAttributes(lp);
        this.setCanceledOnTouchOutside(true);
        View v = View.inflate(context, R.layout.dialog_sendmessage, null);
        this.setContentView(v);
        ButterKnife.bind(this, v);
    }

    public EditText getEtContent(){
        return etContent;
    }
}

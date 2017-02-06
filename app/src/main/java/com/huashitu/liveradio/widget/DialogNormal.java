package com.huashitu.liveradio.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.huashitu.liveradio.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/10/28 0028.
 */

public class DialogNormal extends Dialog {

    @BindView(R.id.tv_notice)
    TextView tvNotice;
    @BindView(R.id.btn_cancel)
    Button btnCancel;
    @BindView(R.id.btn_ok)
    Button btnOk;
    private Context context;

    public DialogNormal(Context context) {
        super(context, R.style.diy_dialog);
        init(context);
    }

    public DialogNormal(Context context, int themeResId) {
        super(context, R.style.diy_dialog);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        Window w = this.getWindow();
        WindowManager.LayoutParams lp = w.getAttributes();
        lp.gravity = Gravity.CENTER;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        w.setAttributes(lp);
        this.setCanceledOnTouchOutside(true);
        View v = View.inflate(context, R.layout.dialog_notice, null);
        this.setContentView(v);
        ButterKnife.bind(this, v);
    }

    public DialogNormal setTitle(String title){
        tvNotice.setText(title);
        return this;
    }

    public DialogNormal setBtnOkEvent(View.OnClickListener onClickListener){
        btnOk.setOnClickListener(onClickListener);
        return this;
    }

    @OnClick({R.id.btn_cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel:
                dismiss();
                break;
        }
    }
}

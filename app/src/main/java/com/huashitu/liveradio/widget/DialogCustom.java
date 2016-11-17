package com.huashitu.liveradio.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.huashitu.liveradio.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/10/28 0028.
 */

public class DialogCustom extends Dialog implements TextWatcher {

    @BindView(R.id.btn_cancel)
    Button btnCancel;
    @BindView(R.id.btn_ok)
    Button btnOk;
    @BindView(R.id.tv_TicketCount)
    TextView tvTicketCount;
    @BindView(R.id.et_ticketCount)
    EditText etTicketCount;
    @BindView(R.id.tv_diamondsCount)
    TextView tvDiamondsCount;
    private Context context;

    public DialogCustom(Context context) {
        super(context, R.style.diy_dialog);
        init(context);
    }

    public DialogCustom(Context context, int themeResId) {
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
        View v = View.inflate(context, R.layout.dialog_custom, null);
        this.setContentView(v);
        ButterKnife.bind(this, v);
        etTicketCount.addTextChangedListener(this);
    }


    public View getOkButton() {
        return btnOk;
    }

    public String getetTicketCount() {
        return etTicketCount.getText().toString();
    }

    public String gettvDiamondsCount() {
        return tvDiamondsCount.getText().toString();
    }

    @OnClick({R.id.btn_cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel:
                this.dismiss();
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        LogUtils.e(s.toString());
        if("".equals(s.toString())){
            btnOk.setTextColor(Color.parseColor("#BCB8BC"));
            btnOk.setClickable(false);
        }else{
            btnOk.setTextColor(Color.parseColor("#A856CF"));
            btnOk.setClickable(true);
        }
    }
}

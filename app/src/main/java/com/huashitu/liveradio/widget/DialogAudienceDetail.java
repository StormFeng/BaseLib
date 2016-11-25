package com.huashitu.liveradio.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.huashitu.liveradio.R;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/10/28 0028.
 */

public class DialogAudienceDetail extends Dialog {

    @BindView(R.id.tv_Report)
    TextView tvReport;
    @BindView(R.id.iv_Exit)
    ImageView ivExit;
    @BindView(R.id.iv_Head)
    RoundedImageView ivHead;
    @BindView(R.id.iv_Head1)
    RoundedImageView ivHead1;
    @BindView(R.id.tv_Name)
    TextView tvName;
    @BindView(R.id.iv_Sex)
    ImageView ivSex;
    @BindView(R.id.tv_Grade)
    TextView tvGrade;
    @BindView(R.id.tv_Account)
    TextView tvAccount;
    @BindView(R.id.tv_Position)
    TextView tvPosition;
    @BindView(R.id.tv_Sign)
    TextView tvSign;
    @BindView(R.id.tv_Attention)
    TextView tvAttention;
    @BindView(R.id.tv_Fans)
    TextView tvFans;
    @BindView(R.id.tv_Ticket)
    TextView tvTicket;
    @BindView(R.id.tv_Diamonds)
    TextView tvDiamonds;
    @BindView(R.id.btn_Attentioned)
    Button btnAttentioned;
    @BindView(R.id.btn_PrivateLetter)
    Button btnPrivateLetter;
    @BindView(R.id.tv_CallTa)
    Button tvCallTa;
    @BindView(R.id.tv_HomePage)
    Button tvHomePage;
    private Context context;

    public DialogAudienceDetail(Context context) {
        super(context, R.style.diy_dialog);
        init(context);
    }

    public DialogAudienceDetail(Context context, int themeResId) {
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
        View v = View.inflate(context, R.layout.dialog_audiencedetail, null);
        this.setContentView(v);
        ButterKnife.bind(this, v);
    }

    @OnClick({R.id.tv_Report, R.id.iv_Exit, R.id.btn_Attentioned, R.id.btn_PrivateLetter, R.id.tv_CallTa, R.id.tv_HomePage})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_Report:
                new DialogNormal(context).show();
                break;
            case R.id.iv_Exit:
                dismiss();
                break;
            case R.id.btn_Attentioned:
                break;
            case R.id.btn_PrivateLetter:
                break;
            case R.id.tv_CallTa:
                break;
            case R.id.tv_HomePage:
                break;
        }
    }
}

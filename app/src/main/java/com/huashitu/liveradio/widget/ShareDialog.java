package com.huashitu.liveradio.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.apkfuns.logutils.LogUtils;
import com.huashitu.liveradio.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/10/27 0027.
 */

public class ShareDialog extends Dialog {

    @BindView(R.id.tv_Circle)
    TextView tvCircle;
    @BindView(R.id.tv_QQZone)
    TextView tvQQZone;
    @BindView(R.id.tv_WeChat)
    TextView tvWeChat;
    @BindView(R.id.tv_QQ)
    TextView tvQQ;
    @BindView(R.id.tv_Sina)
    TextView tvSina;
    private Context context;
    private String title;
    private String content;
    private String imageUrl;
    private String targetUrl;
    //imageurl不能为空

    public ShareDialog(Context context) {
        super(context, R.style.bottom_dialog);
        init(context);
    }

    public ShareDialog(Context context, int themeResId) {
        super(context, R.style.bottom_dialog);
        init(context);
    }

    public ShareDialog(Context context, String title, String content, String imageUrl, String targetUrl) {
        super(context, R.style.bottom_dialog);
        init(context);
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.targetUrl = targetUrl;
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
        View v = View.inflate(context, R.layout.dialog_share, null);
        this.setContentView(v);
        ButterKnife.bind(this, v);
    }

    UMShareListener listener = new UMShareListener() {
        @Override
        public void onResult(SHARE_MEDIA share_media) {
            LogUtils.d("share_media:" + share_media);
            Toast.makeText(context, share_media + " 分享成功", Toast.LENGTH_SHORT).show();
            dismiss();
        }

        @Override
        public void onError(SHARE_MEDIA share_media, Throwable throwable) {
            LogUtils.e("share_media:" + share_media + throwable.getMessage());
            Toast.makeText(context, share_media + " 分享失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media) {
            LogUtils.e("share_media:" + share_media);
            Toast.makeText(context, share_media + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };

    public void share(SHARE_MEDIA platform, String title, String content, String imageUrl, String targetUrl) {
        new ShareAction((Activity) context).setPlatform(platform)
                .withTitle(title)
                .withText(content)
                .withMedia(new UMImage(context, imageUrl))
                .withTargetUrl(targetUrl)
                .setCallback(listener)
                .share();
    }

    @OnClick({R.id.tv_Circle, R.id.tv_QQZone, R.id.tv_WeChat, R.id.tv_QQ, R.id.tv_Sina})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_Circle:
                share(SHARE_MEDIA.WEIXIN_CIRCLE, title, content, imageUrl, targetUrl);
                break;
            case R.id.tv_QQZone:
                share(SHARE_MEDIA.QZONE, title, content, imageUrl, targetUrl);
                break;
            case R.id.tv_WeChat:
                share(SHARE_MEDIA.WEIXIN, title, content, imageUrl, targetUrl);
                break;
            case R.id.tv_QQ:
                share(SHARE_MEDIA.QQ, title, content, imageUrl, targetUrl);
                break;
            case R.id.tv_Sina:
                share(SHARE_MEDIA.SINA, title, content, imageUrl, targetUrl);
                break;
        }
    }
}

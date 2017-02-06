package com.huashitu.liveradio.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huashitu.liveradio.R;
import com.huashitu.liveradio.activity.Activity_WatchRadio;
import com.huashitu.liveradio.bean.HotBean;
import com.huashitu.liveradio.widget.DialogNormal;
import com.midian.base.util.NetworkUtils;
import com.midian.base.util.UIHelper;
import java.util.List;


/**
 * 热门
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class Adapter_Hot extends BaseQuickAdapter<HotBean.ListBean> {

    private Context context;

    public Adapter_Hot(Context context, List<HotBean.ListBean> data) {
        super(R.layout.item_hotbot, data);
        this.context = context;

    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, final HotBean.ListBean item) {
        baseViewHolder.setText(R.id.tv_Name,item.getMyname())
                .setText(R.id.tv_Count,item.getAllnum()+"")
                .setText(R.id.tv_Adress,item.getGps())
                .setOnClickListener(R.id.ll_Item, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(NetworkUtils.isWifi(context)){
                            Bundle bundle=new Bundle();
                            bundle.putString("url",item.getFlv());
                            UIHelper.jump((Activity) context,Activity_WatchRadio.class,bundle);
                        }else{
                            final DialogNormal dialogNormal = new DialogNormal(context);
                            dialogNormal.setTitle("当前为移动网络，继续观看直播吗？").setBtnOkEvent(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialogNormal.dismiss();
                                    Bundle bundle=new Bundle();
                                    bundle.putString("url",item.getFlv());
                                    UIHelper.jump((Activity) context,Activity_WatchRadio.class,bundle);
                                }
                            }).show();
                        }
                    }
                });
        Glide.with(context).load(item.getSmallpic()).into((ImageView) baseViewHolder.getView(R.id.iv_Head));
        Glide.with(context).load(item.getBigpic()).into((ImageView) baseViewHolder.getView(R.id.iv_Bg));
    }
}

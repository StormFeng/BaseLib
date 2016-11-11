package com.huashitu.liveradio.tpl;
import android.content.Context;
import android.util.AttributeSet;
import com.huashitu.liveradio.R;
import com.midian.base.bean.NetResult;
import com.midian.base.view.BaseTpl;
import com.midian.base.widget.Banner;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 热门
 */
public class Fragment_HotTopTpl extends BaseTpl<NetResult> {

    @BindView(R.id.banner)
    Banner banner;

    private boolean flag=true;

    private ArrayList<String> images=new ArrayList<>();

    public Fragment_HotTopTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Fragment_HotTopTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.item_hottop;
    }

    @Override
    public void setBean(NetResult bean, int position) {
        if(flag){
            flag=false;
            banner.setBannerStyle(Banner.CIRCLE_INDICATOR);//设置圆形指示器
            banner.setIndicatorGravity(Banner.CENTER);
            banner.isAutoPlay(true);
            banner.setDelayTime(5000);//设置轮播间隔时间
            for (int i = 0; i < 3; i++) {
                images.add("http://img4.imgtn.bdimg.com/it/u=1600867707,3464380193&fm=21&gp=0.jpg");
            }
            banner.setImages(images.toArray());
        }
    }
}

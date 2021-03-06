package jessefu.me.component_base.router;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;

/**
 * @author Jesse Fu
 * @date 2020/12/3
 * @description 路由回调适配器
 * {@link com.alibaba.android.arouter.launcher.ARouter}
 */
public abstract class NavCallbackAdapter implements NavigationCallback {

    @Override
    public void onFound(Postcard postcard) {

    }

    @Override
    public void onArrival(Postcard postcard) {

    }

    @Override
    public void onLost(Postcard postcard) {

    }

    @Override
    public void onInterrupt(Postcard postcard) {

    }
}

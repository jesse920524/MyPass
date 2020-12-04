package jessefu.me.component_base.router;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;

/**
 * @author Jesse Fu
 * @date 2020/12/3
 * @description
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

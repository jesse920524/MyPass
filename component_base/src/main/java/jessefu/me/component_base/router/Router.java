package jessefu.me.component_base.router;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author Jesse Fu
 * @date 2020/12/3
 * @description
 */
public enum Router {

    INSTANCE;

    /**跳转到编辑页
     * @param id {@link jessefu.me.component_base.orm.entity.RecordEntity#uid}*/
    public void navToEdit(@NonNull Context context, @NonNull long id, @Nullable NavigationCallback callback){
        ARouter.getInstance().build(RouterConstants.MODULE_PASS + RouterConstants.ACTIVITY_EDIT)
                .withLong(RouterConstants.KEY_EDIT_ID, id)
                .navigation(context, callback);
    }

    /**跳转到详情页
     * @param id {@link jessefu.me.component_base.orm.entity.RecordEntity#uid}*/
    public void navToDetail(@NonNull Context context, @NonNull long id, @Nullable NavigationCallback callback){
        ARouter.getInstance().build(RouterConstants.MODULE_PASS + RouterConstants.ACTIVITY_DETAIL)
                .withLong(RouterConstants.MODULE_PASS + RouterConstants.ACTIVITY_DETAIL, id)
                .navigation(context, callback);
    }
}

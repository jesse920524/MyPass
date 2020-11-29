package jessefu.me.component_base.base;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.AppUtils;

import jessefu.me.component_base.orm.database.AppDatabase;

/**
 * @author Jesse Fu
 * @date 2020/11/27
 * @description
 */
public class BaseApp extends Application {

    private static Context mContext;

    private static AppDatabase mAppDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        initRoom();
        initRouter();
    }

    private void initRouter() {
        if (AppUtils.isAppDebug()){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    private void initRoom(){
        mAppDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "db-name").build();
    }
}

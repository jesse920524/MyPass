package jessefu.me.component_base.base;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

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
    }

    private void initRoom(){
        mAppDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "db-name").build();
    }
}

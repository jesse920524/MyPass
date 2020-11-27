package jessefu.me.component_base.orm.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import jessefu.me.component_base.orm.dao.RecordDao;

/**
 * @author Jesse Fu
 * @date 2020/11/27
 * @description
 */
public abstract class AppDatabase extends RoomDatabase {

    public abstract RecordDao recordDao();
}

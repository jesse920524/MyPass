package jessefu.me.mypass.pages.main_page;

import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

import jessefu.me.component_base.base.BaseApp;
import jessefu.me.component_base.base.BaseRepository;
import jessefu.me.component_base.orm.dao.RecordDao;
import jessefu.me.component_base.orm.entity.RecordEntity;

/**
 * @author Jesse Fu
 * @date 2020/11/30
 * @description
 */
public class MainPageRepository extends BaseRepository {
    private static final String TAG = "MainPageRepository";

    private RecordDao mRecordDao = BaseApp.getAppDataBase().recordDao();

    public LiveData<List<RecordEntity>> readAllData(){
        LiveData<List<RecordEntity>> result = mRecordDao.getAll();
        Log.d(TAG, "readAllData: " + result.getValue());
        return result;
    }

    public LiveData<List<RecordEntity>> readByTag(String tag){
        LiveData<List<RecordEntity>> result = mRecordDao.findByTag(tag);
        Log.d(TAG, "readByTag: " + result.getValue());
        return result;
    }

    public LiveData<List<RecordEntity>> readByCategory(String category){
        LiveData<List<RecordEntity>> result = mRecordDao.findByCategory(category);
        Log.d(TAG, "readByCategory: " + result.getValue());
        return result;
    }
}

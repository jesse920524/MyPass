package jessefu.me.mypass.pages.edit;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import jessefu.me.component_base.base.BaseApp;
import jessefu.me.component_base.base.BaseRepository;
import jessefu.me.component_base.orm.dao.RecordDao;
import jessefu.me.component_base.orm.entity.RecordEntity;

/**
 * @author Jesse Fu
 * @date 2020/12/8
 * @description
 */
public class EditRepository extends BaseRepository {
    private static final String TAG = "EditRepository";

    private RecordDao mRecordDao = BaseApp.getAppDataBase().recordDao();
    public EditRepository() {
    }

    public LiveData<RecordEntity> queryById(@NonNull long id){
        return mRecordDao.findById(id);
    }

    public int update(RecordEntity entity){
        return mRecordDao.update(entity);
    }

    public void add(RecordEntity entity){
        mRecordDao.insert(entity);
    }
}

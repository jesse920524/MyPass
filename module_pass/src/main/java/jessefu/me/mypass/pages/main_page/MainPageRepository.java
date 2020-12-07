package jessefu.me.mypass.pages.main_page;

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

    private RecordDao mRecordDao = BaseApp.getAppDataBase().recordDao();

    public List<RecordEntity> readAllData(){
        return mRecordDao.getAll();
    }
}

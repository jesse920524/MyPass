package jessefu.me.mypass.pages.edit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import jessefu.me.component_base.base.BaseViewModel;
import jessefu.me.component_base.orm.entity.RecordEntity;

/**
 * @author Jesse Fu
 * @date 2020/12/8
 * @description
 */
public class EditVM extends BaseViewModel {
    private static final String TAG = "EditVM";

    private EditRepository mRepository = new EditRepository();

    private MutableLiveData<RecordEntity> mRecordEntityData = new MutableLiveData<>();
    public EditVM() {
    }

    public MutableLiveData<RecordEntity> queryById(long id){
        RecordEntity entity = mRepository.queryById(id)
                .getValue();
        mRecordEntityData.setValue(entity);
        return mRecordEntityData;
    }
}

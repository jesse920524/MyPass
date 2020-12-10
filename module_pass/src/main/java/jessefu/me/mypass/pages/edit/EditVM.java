package jessefu.me.mypass.pages.edit;

import android.icu.text.AlphabeticIndex;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.blankj.utilcode.util.ObjectUtils;

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

    public void save(String name,
                     String account,
                     String pwd,
                     String desc){
        if(ObjectUtils.isEmpty(mRecordEntityData.getValue())){
            RecordEntity entity = new RecordEntity();
            entity.name = name;
            entity.account = account;
            entity.encryptedPwd = pwd;
            entity.desc = desc;
            mRepository.add(entity);
        }else{
            RecordEntity entity = mRecordEntityData.getValue();
            entity.name = name;
            entity.account = account;
            entity.encryptedPwd = pwd;
            entity.desc = desc;
            mRepository.update(entity);
        }
    }
}

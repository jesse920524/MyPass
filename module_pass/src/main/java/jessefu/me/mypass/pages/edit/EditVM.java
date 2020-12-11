package jessefu.me.mypass.pages.edit;

import android.icu.text.AlphabeticIndex;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.blankj.utilcode.util.ObjectUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.schedulers.Schedulers;
import jessefu.me.component_base.base.BaseViewModel;
import jessefu.me.component_base.orm.entity.RecordEntity;
import kotlin.Unit;

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

    public Observable<RecordEntity> save(String name,
                     String account,
                     String pwd,
                     String desc){
        return Observable.create(new ObservableOnSubscribe<RecordEntity>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<RecordEntity> emitter) throws Throwable {
                RecordEntity entity = new RecordEntity();
                entity.name = name;
                entity.account = account;
                entity.encryptedPwd = pwd;
                entity.desc = desc;
                if(ObjectUtils.isEmpty(mRecordEntityData.getValue())){
                    mRepository.add(entity);
                }else{
                    mRepository.update(entity);
                }
                emitter.onNext(entity);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}

package jessefu.me.mypass.pages.edit;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
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

    private MutableLiveData<RecordEntity> mRecordEntityData = new MediatorLiveData<>();

    private MutableLiveData<Long> mUpdateData = new MutableLiveData<>();

    private MutableLiveData<Long> mAddData = new MutableLiveData<>();

    private MutableLiveData<Integer> mDeleteData = new MutableLiveData<>();

    public EditVM() {
    }

    /**查询成功后, 保存*/
    public void cachedEntity(RecordEntity entity){
        mRecordEntityData.setValue(entity);
    }

    public LiveData<RecordEntity> queryById(long id){
        return mRepository.queryById(id);
    }

    public LiveData<Long> save(String name,
                     String account,
                     String pwd,
                     String desc){
        RecordEntity entity = new RecordEntity();
        entity.name = name;
        entity.account = account;
        entity.encryptedPwd = pwd;
        entity.desc = desc;
        mRepository.add(entity)
                 .subscribe(new Observer<Long>() {
                     @Override
                     public void onSubscribe(@NonNull Disposable d) {

                     }

                     @Override
                     public void onNext(@NonNull Long aLong) {
                         mAddData.setValue(aLong);
                     }

                     @Override
                     public void onError(@NonNull Throwable e) {
                         Log.d(TAG, "onError: " + e.getLocalizedMessage());
                     }

                     @Override
                     public void onComplete() {

                     }
                 });
         return mAddData;
    }

    public LiveData<Long> update(
            long id,
            String name,
            String account,
            String pwd,
            String desc){
        RecordEntity entity = mRecordEntityData.getValue();
        entity.name = name;
        entity.account = account;
        entity.encryptedPwd = pwd;
        entity.desc = desc;
        mRepository.update(entity)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        mUpdateData.setValue(System.currentTimeMillis());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return mUpdateData;
    }

    public LiveData<Integer> delete(){
        mRepository.deleteById(mRecordEntityData.getValue())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        mDeleteData.setValue(integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return mDeleteData;
    }
}

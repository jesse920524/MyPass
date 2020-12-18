package jessefu.me.mypass.pages.edit;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
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
        Log.d(TAG, "EditRepository: " + mRecordDao);
    }
//
    public LiveData<RecordEntity> queryById(@NonNull long id){
        Log.d(TAG, "queryById: " + id);
        return mRecordDao.findById(id);
    }

    public Observable<Integer> update(RecordEntity entity){
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@io.reactivex.rxjava3.annotations.NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                int affectRows = mRecordDao.update(entity);
                emitter.onNext(affectRows);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    public Observable<Long> add(RecordEntity entity){
        return Observable.create(new ObservableOnSubscribe<Long>() {
            @Override
            public void subscribe(@io.reactivex.rxjava3.annotations.NonNull ObservableEmitter<Long> emitter) throws Throwable {
                long id = mRecordDao.insert(entity);
                emitter.onNext(id);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Integer> deleteById(RecordEntity recordEntity){
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@io.reactivex.rxjava3.annotations.NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                int affectRows = mRecordDao.delete(recordEntity);
                emitter.onNext(affectRows);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

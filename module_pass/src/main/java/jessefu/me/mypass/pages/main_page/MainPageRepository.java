package jessefu.me.mypass.pages.main_page;

import android.util.Log;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Future;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
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

    public Observable<List<RecordEntity>> readAll(){
        return Observable.create(new ObservableOnSubscribe<List<RecordEntity>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<RecordEntity>> emitter) throws Throwable {
                emitter.onNext(mRecordDao.getAll());
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

//    public LiveData<List<RecordEntity>> readAllData(){
//        LiveData<List<RecordEntity>> result = mRecordDao.getAll();
//        Log.d(TAG, "readAllData: " + result.getValue());
//        return result;
//    }
//
//    public LiveData<List<RecordEntity>> readByTag(String tag){
//        LiveData<List<RecordEntity>> result = mRecordDao.findByTag(tag);
//        Log.d(TAG, "readByTag: " + result.getValue());
//        return result;
//    }

    public LiveData<List<RecordEntity>> readByCategory(String category){
        LiveData<List<RecordEntity>> result = mRecordDao.findByCategory(category);
        Log.d(TAG, "readByCategory: " + result.getValue());
        return result;
    }

    public Observable<Long> mockInsert(){
        return Observable.create((ObservableOnSubscribe<Long>)emitter->{
            RecordEntity recordEntity = new RecordEntity();
            recordEntity.name = String.valueOf(System.currentTimeMillis());
            recordEntity.account = "account";
            recordEntity.encryptedPwd = "pwd";
            recordEntity.desc = "desc";
            long v = mRecordDao.insert(recordEntity);
            emitter.onNext(v);
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

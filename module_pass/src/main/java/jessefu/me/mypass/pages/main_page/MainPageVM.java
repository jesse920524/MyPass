package jessefu.me.mypass.pages.main_page;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import jessefu.me.component_base.base.BaseViewModel;
import jessefu.me.component_base.orm.entity.RecordEntity;

/**
 * @author Jesse Fu
 * @date 2020/11/30
 * @description
 */
public class MainPageVM extends BaseViewModel {
    private static final String TAG = "MainPageVM";

    private MainPageRepository mRepository = new MainPageRepository();
    private MutableLiveData<List<RecordEntity>> mRecordsLiveData = new MutableLiveData<>();

    public MainPageVM() {

    }

    public MutableLiveData<List<RecordEntity>> readAllData(){
        mRepository.readAll()
                .subscribe(records -> {
                    mRecordsLiveData.setValue(records);
                },
                        throwable -> {
                            Log.d(TAG, "readAllData: " + throwable.getLocalizedMessage());
                });
        return mRecordsLiveData;
    }



    public Observable<Long> mockInsert(){
        return mRepository.mockInsert()
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Throwable {
                        readAllData();
                    }
                });
    }
}

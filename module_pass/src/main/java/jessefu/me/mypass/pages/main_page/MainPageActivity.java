package jessefu.me.mypass.pages.main_page;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import jessefu.me.component_base.base.BaseActivity;
import jessefu.me.component_base.orm.entity.RecordEntity;
import jessefu.me.component_base.router.NavCallbackAdapter;
import jessefu.me.component_base.router.Router;
import jessefu.me.component_base.router.RouterConstants;
import jessefu.me.module_pass.R;
import jessefu.me.mypass.pages.main_page.adapter.MainPageRvAdapter;

/**
 * author: Jesse Fu
 * date: 2020/11/28 17:10
 * description:
 */
@Route(path = RouterConstants.MODULE_PASS + RouterConstants.ACTIVITY_MAIN_PAGE)
public class MainPageActivity extends BaseActivity {
    private static final String TAG = "MainPageActivity";

    private SwipeRefreshLayout mSrl;
    private RecyclerView mRecyclerView;
    private FloatingActionButton mFab;

    private MainPageRvAdapter mAdapter;

    private MainPageVM mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        mViewModel = new ViewModelProvider.NewInstanceFactory().create(MainPageVM.class);
        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        readAllDatas();
    }

    private void initViews() {
        mSrl = findViewById(R.id.srl_amp);
        mRecyclerView = findViewById(R.id.rv_amp);
        mFab = findViewById(R.id.fab_amp);

        mFab.setOnClickListener(v->{
//            mViewModel.mockInsert();
            Router.INSTANCE.navToEdit(MainPageActivity.this, -1, null);
        });

        mSrl.setOnRefreshListener(()->{
            readAllDatas();
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        mAdapter = new MainPageRvAdapter();
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                RecordEntity item = (RecordEntity) adapter.getData().get(position);
                Router.INSTANCE.navToEdit(MainPageActivity.this, item.uid, null);
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    private void readAllDatas(){
        mViewModel.readAllData().observe(this, new Observer<List<RecordEntity>>() {
            @Override
            public void onChanged(List<RecordEntity> recordEntities) {
                Log.d(TAG, "onChanged: " + recordEntities);
                if (mSrl.isRefreshing()){
                    mSrl.setRefreshing(false);
                }
                mAdapter.setNewInstance(recordEntities);
            }
        });
    }
}

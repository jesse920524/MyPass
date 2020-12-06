package jessefu.me.mypass.pages.main_page;

import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import jessefu.me.component_base.base.BaseActivity;
import jessefu.me.component_base.router.RouterConstants;
import jessefu.me.module_pass.R;

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

    private MainPageVM mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        initViews();
    }

    private void initViews() {
        mSrl = findViewById(R.id.srl_amp);
        mRecyclerView = findViewById(R.id.rv_amp);
        mFab = findViewById(R.id.fab_amp);

        mFab.setImageResource(R.drawable.ic_baseline_edit_24);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }


}

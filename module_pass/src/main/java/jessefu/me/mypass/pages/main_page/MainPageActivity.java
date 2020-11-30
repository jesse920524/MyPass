package jessefu.me.mypass.pages.main_page;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }
}

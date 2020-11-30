package jessefu.me.mypass.pages.edit;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;

import jessefu.me.component_base.base.BaseActivity;
import jessefu.me.component_base.router.RouterConstants;
import jessefu.me.module_pass.R;

/**
 * author: Jesse Fu
 * date: 2020/11/30 21:38
 * description: 编辑页
 */
@Route(path = RouterConstants.MODULE_PASS + RouterConstants.ACTIVITY_EDIT)
public class EditActivity extends BaseActivity {
    private static final String TAG = "EditActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
    }
}

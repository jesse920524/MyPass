package jessefu.me.mypass.pages.edit;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.textfield.TextInputEditText;

import jessefu.me.component_base.base.BaseActivity;
import jessefu.me.component_base.orm.entity.RecordEntity;
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

    @Autowired(name = RouterConstants.KEY_EDIT_ID)
    long mId;//记录的id.

    private ImageView mIvCancel;
    private ImageView mIvConfirm;

    private TextInputEditText mEtName;
    private TextInputEditText mEtAccount;
    private TextInputEditText mEtPwd;
    private TextInputEditText mEtDesc;

    private EditVM mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        initViews();
        mViewModel = new ViewModelProvider.NewInstanceFactory().create(EditVM.class);
        mViewModel.queryById(mId).observe(EditActivity.this, new Observer<RecordEntity>() {
            @Override
            public void onChanged(RecordEntity recordEntity) {
                Log.d(TAG, "onChanged: " + recordEntity);
            }
        });


    }

    private void initViews() {
        mIvCancel = findViewById(R.id.iv_ae_close);
        mIvConfirm = findViewById(R.id.iv_ae_save);

        mEtName = findViewById(R.id.et_ae_name)
        initClicks();
    }

    private void initClicks() {
        mIvConfirm.setOnClickListener(v->{
            mViewModel.save(mEtName.getText().toString(),
                    mEtAccount.getText().toString(),
                    mEtPwd.getText().toString(),
                    mEtDesc.getText().toString());
        });

        mIvCancel.setOnClickListener(v->{
            finish();
        });
    }


}

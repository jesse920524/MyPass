package jessefu.me.mypass.pages.edit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LongDef;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ObjectUtils;
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
    private TextView mTvTitle;

    private TextInputEditText mEtName;
    private TextInputEditText mEtAccount;
    private TextInputEditText mEtPwd;
    private TextInputEditText mEtDesc;
    private Button mBtnDelete;

    private EditVM mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        initViews();
        mViewModel = new ViewModelProvider.NewInstanceFactory().create(EditVM.class);
        handleEdit();
    }

    /**若id != -1, 为编辑模式. 否则为新增模式*/
    private void handleEdit() {
        if (isEditMode(mId)){
            mTvTitle.setText(getResources().getString(R.string.edit));
            mBtnDelete.setVisibility(View.VISIBLE);
            queryById(mId);
        }else{
            mTvTitle.setText(getResources().getString(R.string.add));
            mBtnDelete.setVisibility(View.GONE);
        }
    }

    private void initViews() {
        mTvTitle = findViewById(R.id.tv_ae_header_title);
        mIvCancel = findViewById(R.id.iv_ae_close);
        mIvConfirm = findViewById(R.id.iv_ae_save);
        mEtAccount = findViewById(R.id.et_ae_account);
        mEtPwd = findViewById(R.id.et_ae_pwd);
        mEtName = findViewById(R.id.et_ae_name);
        mEtDesc = findViewById(R.id.et_ae_desc);
        mBtnDelete = findViewById(R.id.btn_ae_delete);

        initClicks();
    }

    private void initClicks() {
        mIvConfirm.setOnClickListener(v->{
            if (isEditMode(mId)){
                update();
            }else{
                save();
            }
        });

        mIvCancel.setOnClickListener(v->{
            finish();
        });

        mBtnDelete.setOnLongClickListener(v->{
//            delete(mId);
            return true;
        });
    }

    private void queryById(long id){
        mViewModel.queryById(id).observe(EditActivity.this, new Observer<RecordEntity>() {
            @Override
            public void onChanged(RecordEntity recordEntity) {
                Log.d(TAG, "onChanged: query by id: " + recordEntity);
                if (ObjectUtils.isNotEmpty(recordEntity)){
                    mEtName.setText(recordEntity.name);
                    mEtAccount.setText(recordEntity.account);
                    mEtPwd.setText(recordEntity.encryptedPwd);
                    mEtDesc.setText(recordEntity.desc);
                }
            }
        });
    }

    private void save() {
        mViewModel.save(mEtName.getText().toString(),
                mEtAccount.getText().toString(),
                mEtPwd.getText().toString(),
                mEtDesc.getText().toString())
        .observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long l) {
                Log.d(TAG, "onChanged: 保存成功!");
                finish();
            }
        });
    }

    private void update(){
        mViewModel.update(mEtName.getText().toString(),
                mEtAccount.getText().toString(),
                mEtPwd.getText().toString(),
                mEtDesc.getText().toString())
                .observe(this, l->{
                    Log.d(TAG, "update: 更新成功!");
                });
    }

    private void delete(RecordEntity entity){
        mViewModel.delete(entity)
                .observe(this, i->{
                    Log.d(TAG, "delete: 删除成功!");
                    finish();
                });
    }

    /**@return true: 编辑模式 false: 新增模式
     * */
    private boolean isEditMode(long id){
        if (id != -1){
            return true;
        }
        return false;
    }
}

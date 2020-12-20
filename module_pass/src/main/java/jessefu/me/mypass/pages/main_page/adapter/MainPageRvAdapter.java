package jessefu.me.mypass.pages.main_page.adapter;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.blankj.utilcode.util.ColorUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

import jessefu.me.component_base.orm.entity.RecordEntity;
import jessefu.me.module_pass.R;

/**
 * author: Jesse Fu
 * date: 2020/12/13 22:06
 * description:
 */
public class MainPageRvAdapter extends BaseQuickAdapter<RecordEntity, BaseViewHolder> {
    private static final String TAG = "MainPageRvAdapter";

    private ColorGenerator mColorGenerator;
    public MainPageRvAdapter(){
        this(R.layout.main_item_rv_star);
        mColorGenerator = ColorGenerator.MATERIAL;
    }

    public MainPageRvAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, RecordEntity recordEntity) {
        ImageView mIvSee = baseViewHolder.getView(R.id.iv_item_star_see);
        ImageView mIvAvatar = baseViewHolder.getView(R.id.iv_item_star_avatar);
        TextView mTvName = baseViewHolder.getView(R.id.tv_item_star_title);
        TextView mTvAccount = baseViewHolder.getView(R.id.tv_item_star_account);
        TextView mTvPwd = baseViewHolder.getView(R.id.tv_item_star_pwd);

        mTvName.setText(recordEntity.name);
        mTvAccount.setText(recordEntity.account);
        mTvPwd.setText(getContext().getResources().getString(R.string.password_hide));

        String sInitial = recordEntity.name.substring(0, 1);
        TextDrawable textDrawable = TextDrawable.builder()
                .beginConfig()
                .textColor(ColorUtils.getColor(R.color.white))
                .fontSize(SizeUtils.dp2px(17))
                .toUpperCase()
                .endConfig()
                .buildRound(sInitial, mColorGenerator.getRandomColor());
        mIvAvatar.setImageDrawable(textDrawable);

        mIvSee.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d(TAG, "onTouch: ");
                        mTvPwd.setText(recordEntity.encryptedPwd);
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(TAG, "onTouch: ");
                        mTvPwd.setText(getContext().getResources().getString(R.string.password_hide));
                        break;
                    default:
                        return false;
                }
                return true;
            }

        });
    }

}

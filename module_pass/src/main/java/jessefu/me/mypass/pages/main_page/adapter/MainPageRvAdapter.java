package jessefu.me.mypass.pages.main_page.adapter;

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

    public MainPageRvAdapter(){
        this(R.layout.main_item_rv_star);
    }

    public MainPageRvAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, RecordEntity recordEntity) {

    }
}

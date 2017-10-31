package de.carey.desigggn.ui.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import de.carey.desigggn.R;
import de.carey.desigggn.entity.ShotEntity;
import de.carey.desigggn.helper.ImageLoader;

public class ShotsAdapter extends BaseQuickAdapter<ShotEntity, BaseViewHolder> {

    public ShotsAdapter() {
        super(R.layout.item_shots);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShotEntity item) {
        ImageView ivPreView = helper.getView(R.id.iv_item_shot_preview);
        ImageLoader.loadShot(item, ivPreView);
        helper.addOnClickListener(R.id.iv_item_shot_preview);
    }
}

package de.carey.desigggn.ui.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import de.carey.desigggn.R;
import de.carey.desigggn.entity.ShotEntity;

public class ShotsAdapter extends BaseQuickAdapter<ShotEntity, BaseViewHolder> {

    public ShotsAdapter() {
        super(R.layout.item_shots);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShotEntity item) {
        ImageView ivPreView = helper.getView(R.id.iv_item_shot_preview);
        if (item.isAnimated()) {
            helper.setVisible(R.id.iv_item_shot_gif, true);
            Glide.with(mContext)
                    .asGif()
                    .load(item.getImages().getNormal())
                    .into(ivPreView);
        } else {
            helper.setVisible(R.id.iv_item_shot_gif, false);
            Glide.with(mContext).load(item.getImages().getNormal()).into(ivPreView);
        }
        helper.addOnClickListener(R.id.iv_item_shot_preview);
    }
}

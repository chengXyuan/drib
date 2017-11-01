package de.carey.desigggn.ui.activity;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.jaeger.library.StatusBarUtil;

import java.util.List;

import de.carey.desigggn.R;
import de.carey.desigggn.base.BaseMVPActivity;
import de.carey.desigggn.databinding.ActivityShotDetailBinding;
import de.carey.desigggn.entity.CommentEntity;
import de.carey.desigggn.entity.ImageEntity;
import de.carey.desigggn.entity.ShotEntity;
import de.carey.desigggn.ui.adapter.CommentAdapter;
import de.carey.desigggn.ui.contract.ShotDetailContract;
import de.carey.desigggn.ui.presenter.ShotDetailPresenter;
import de.carey.desigggn.widget.ColorView;
import de.carey.desigggn.widget.DividerItemDecoration;

public class ShotDetailActivity extends BaseMVPActivity<ShotDetailPresenter, ActivityShotDetailBinding>
        implements ShotDetailContract.View {

    public static final String EXTRA_SHOT_ENTITY = "extra_shot_entity";
    private CommentAdapter mCommentAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_shot_detail;
    }

    @Override
    protected void initStatusBar() {
        StatusBarUtil.setTranslucentForCoordinatorLayout(this, 0);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        ShotEntity shot = (ShotEntity) getIntent().getSerializableExtra(EXTRA_SHOT_ENTITY);
        initShotAndPalette(shot);
        mViewBinding.setShot(shot);
        mCommentAdapter = new CommentAdapter();
        mViewBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mViewBinding.recyclerView.setHasFixedSize(true);
        mViewBinding.recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.LIST_VERTICAL, 1));
        mViewBinding.recyclerView.setAdapter(mCommentAdapter);
        mPresenter.getComments(shot.getCommentsUrl());
    }

    private void initShotAndPalette(ShotEntity shot) {
        ImageEntity image = shot.getImages();
        String url = TextUtils.isEmpty(image.getHidpi()) ? image.getNormal() : image.getHidpi();
        Glide.with(this)
                .load(url)
                .into(new DrawableImageViewTarget(mViewBinding.ivShotView) {
                    @Override
                    public void onResourceReady(Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        super.onResourceReady(resource, transition);
                        Palette.from(((BitmapDrawable) resource).getBitmap())
                                .maximumColorCount(8)
                                .generate(palette -> initShotColors(palette.getSwatches()));
                    }
                });
    }

    private void initShotColors(List<Palette.Swatch> swatches) {
        if (swatches.size() < 2) {
            mViewBinding.paletteDivider.setVisibility(View.GONE);
            mViewBinding.llPalette.setVisibility(View.GONE);
            return;
        }
        for (int i = 0; i < swatches.size(); i++) {
            ColorView colorView = new ColorView(this, swatches.get(i).getRgb());
            if (i % 2 == 0)
                mViewBinding.llLeftColors.addView(colorView);
            else
                mViewBinding.llRightColors.addView(colorView);
        }
    }

    @Override
    public void showComments(List<CommentEntity> data) {
        mCommentAdapter.setNewData(data);
    }
}

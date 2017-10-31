package de.carey.desigggn.ui.activity;

import android.os.Bundle;

import com.jaeger.library.StatusBarUtil;

import java.util.List;

import de.carey.desigggn.R;
import de.carey.desigggn.base.BaseMVPActivity;
import de.carey.desigggn.databinding.ActivityShotDetailBinding;
import de.carey.desigggn.entity.CommentEntity;
import de.carey.desigggn.entity.ShotEntity;
import de.carey.desigggn.helper.ImageLoader;
import de.carey.desigggn.ui.contract.ShotDetailContract;
import de.carey.desigggn.ui.presenter.ShotDetailPresenter;

public class ShotDetailActivity extends BaseMVPActivity<ShotDetailPresenter, ActivityShotDetailBinding>
        implements ShotDetailContract.View {

    public static final String EXTRA_SHOT_ENTITY = "extra_shot_entity";

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_shot_detail;
    }

    @Override
    protected void initStatusBar() {
        StatusBarUtil.setTranslucentForCoordinatorLayout(this,0);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        ShotEntity shot = (ShotEntity) getIntent().getSerializableExtra(EXTRA_SHOT_ENTITY);
        ImageLoader.loadShot(shot, mViewBinding.ivShotView);
        mViewBinding.setShot(shot);
        mPresenter.getComments(shot.getCommentsUrl());
    }

    @Override
    public void showComments(List<CommentEntity> data) {

    }
}

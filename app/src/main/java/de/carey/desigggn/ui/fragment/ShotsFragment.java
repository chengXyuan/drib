package de.carey.desigggn.ui.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import de.carey.desigggn.R;
import de.carey.desigggn.app.Cons;
import de.carey.desigggn.base.BaseMVPListFragment;
import de.carey.desigggn.databinding.FragmentShotsBinding;
import de.carey.desigggn.entity.ShotEntity;
import de.carey.desigggn.ui.activity.ShotDetailActivity;
import de.carey.desigggn.ui.adapter.ShotsAdapter;
import de.carey.desigggn.ui.contract.ShotsContract;
import de.carey.desigggn.ui.presenter.ShotsPresenter;
import de.carey.desigggn.util.SPUtils;
import de.carey.desigggn.widget.SpinnerTextView;

public class ShotsFragment extends BaseMVPListFragment<ShotsPresenter, FragmentShotsBinding>
        implements ShotsContract.View, SpinnerTextView.OnItemSelectedListener {

    private String mType = "";
    private String mSort = "";
    private String mTime = "";

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_shots;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mViewBinding.recyclerView.setHasFixedSize(true);
        setLayoutManager(SPUtils.getInt(Cons.SP_VIEW_MODE, Cons.VIEW_MODE_SMALL));
        ShotsAdapter shotsAdapter = new ShotsAdapter();
        setupList(mViewBinding.swipeRefreshLayout, mViewBinding.recyclerView, shotsAdapter);
        shotsAdapter.setEmptyView(R.layout.layout_loading, (ViewGroup) mViewBinding.recyclerView.getParent());
        shotsAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            Intent intent = new Intent(mActivity, ShotDetailActivity.class);
            ShotEntity shot = shotsAdapter.getData().get(position);
            intent.putExtra(ShotDetailActivity.EXTRA_SHOT_ENTITY, shot);
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(mActivity, view, "share");
            startActivity(intent, options.toBundle());
        });
    }

    private void setLayoutManager(int viewMode) {
        switch (viewMode) {
            case Cons.VIEW_MODE_SMALL:
                mViewBinding.recyclerView.setLayoutManager(new GridLayoutManager(mActivity, 2));
                break;
            case Cons.VIEW_MODE_LARGE:
                mViewBinding.recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
                break;
        }
        SPUtils.putInt(Cons.SP_VIEW_MODE, viewMode);
    }

    @Override
    public void onSpinnerItemSelected(View view, int position, String item) {
        switch (view.getId()) {
            case R.id.spinner_type:
                mType = item;
                break;
            case R.id.spinner_sort:
                mSort = item;
                break;
            case R.id.spinner_time:
                mTime = item;
                break;
        }
        mViewBinding.swipeRefreshLayout.setRefreshing(true);
        requestData(true);
    }

    @Override
    protected void requestData(boolean isRefresh) {
        super.requestData(isRefresh);
        mPresenter.getShots(mType, mSort, mTime, mPageIndex);
    }

    @Override
    public void showShots(List<ShotEntity> shots) {
        setData(shots);
    }
}

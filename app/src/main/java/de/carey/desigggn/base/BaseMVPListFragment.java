package de.carey.desigggn.base;

import android.databinding.ViewDataBinding;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import de.carey.desigggn.R;
import de.carey.desigggn.app.Cons;
import de.carey.desigggn.widget.CustomLoadMoreView;

public abstract class BaseMVPListFragment<P extends BasePresenter, B extends ViewDataBinding> extends BaseMVPFragment<P, B> implements BaseQuickAdapter.RequestLoadMoreListener {

    private SwipeRefreshLayout mRefreshLayout;
    private BaseQuickAdapter mAdapter;

    protected boolean mIsRefresh;
    protected int mPageIndex = 1;

    private View mErrorView;
    private View mEmptyView;
    private TextView mTvErrorMsg;

    protected void setupList(SwipeRefreshLayout refreshLayout, RecyclerView recyclerView, BaseQuickAdapter adapter) {
        mAdapter = adapter;
        LayoutInflater inflater = LayoutInflater.from(getContext());

        /* 没有数据 */
        mEmptyView = inflater.inflate(R.layout.layout_empty_view, (ViewGroup) recyclerView.getParent(), false);
        TextView tvEmptyMsg = mEmptyView.findViewById(R.id.tv_empty_view_msg);
        tvEmptyMsg.setText("暂无数据");

        /* 加载失败 */
        mErrorView = inflater.inflate(R.layout.layout_error_view, (ViewGroup) recyclerView.getParent(), false);
        mTvErrorMsg = mErrorView.findViewById(R.id.tv_error_view_msg);
        mErrorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRefreshLayout.setRefreshing(true);
                requestData(true);
            }
        });

        /* 刷新 */
        mRefreshLayout = refreshLayout;
        mRefreshLayout.setColorSchemeColors(ContextCompat.getColor(getContext(), R.color.colorAccent));
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestData(true);
            }
        });

        /* 加载更多 */
        mAdapter.setLoadMoreView(new CustomLoadMoreView());
        mAdapter.setOnLoadMoreListener(this, recyclerView);

        recyclerView.setAdapter(adapter);

        /* 首次进入自动刷新 */
        mRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                //mRefreshLayout.setRefreshing(true);
                requestData(true);
            }
        }, 200);
    }

    protected void requestData(boolean isRefresh) {
        mIsRefresh = isRefresh;
        if (mIsRefresh)
            mPageIndex = 1;
        else
            mPageIndex++;
    }

    protected int getPageSize() {
        return Cons.PAGE_SIZE;
    }

    @Override
    public void onLoadMoreRequested() {
        requestData(false);
    }

    @SuppressWarnings("unchecked")
    protected <T> void setData(List<T> datas) {
        if (mIsRefresh) {
            mAdapter.setNewData(datas);
            mAdapter.disableLoadMoreIfNotFullPage();
            if (datas == null || datas.size() == 0) {
                mAdapter.setEmptyView(mEmptyView);
            }
        } else {
            mAdapter.addData(datas);
        }
        if (datas == null || datas.size() < getPageSize()) {
            mAdapter.loadMoreEnd();
        } else {
            mAdapter.loadMoreComplete();
        }
    }

    public void showError(String msg) {
        if (mIsRefresh) {
            mTvErrorMsg.setText(msg);
            mAdapter.setEmptyView(mErrorView);
        } else {
            mAdapter.loadMoreFail();
        }
    }

    public void onComplete() {
        mRefreshLayout.setRefreshing(false);
    }
}

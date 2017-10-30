package de.carey.desigggn.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;

import java.util.List;

import de.carey.desigggn.R;
import de.carey.desigggn.app.Cons;
import de.carey.desigggn.base.BaseMVPActivity;
import de.carey.desigggn.databinding.ActivityMainBinding;
import de.carey.desigggn.databinding.NavHeaderBinding;
import de.carey.desigggn.entity.SelectorEntity;
import de.carey.desigggn.entity.UserEntity;
import de.carey.desigggn.helper.UserInfoManager;
import de.carey.desigggn.ui.contract.MainContract;
import de.carey.desigggn.ui.fragment.ShotsFragment;
import de.carey.desigggn.ui.presenter.MainPresenter;
import de.carey.desigggn.util.JsonUtil;
import de.carey.desigggn.util.SPUtils;
import de.carey.desigggn.util.UrlUtils;

public class MainActivity extends BaseMVPActivity<MainPresenter, ActivityMainBinding> implements MainContract.View {

    public static final String EXTRA_AUTHORIZE_CODE = "extra_authorize_code";
    public static final int REQUEST_CODE_AUTHORIZE = 0x101;

    private long mExitTime;
    private NavHeaderBinding mNavHeaderBinding;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        initSpinner();
        initNavDrawer();
        initUserInfo();
    }

    private void initSpinner() {
        ShotsFragment shotsFragment = new ShotsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, shotsFragment).commit();
        mViewBinding.spinnerType.setItem(JsonUtil.json2List(Cons.TYPE_JSON, new TypeToken<List<SelectorEntity>>() {
        }.getType()), shotsFragment);
        mViewBinding.spinnerSort.setItem(JsonUtil.json2List(Cons.SORT_JSON, new TypeToken<List<SelectorEntity>>() {
        }.getType()), shotsFragment);
        mViewBinding.spinnerTime.setItem(JsonUtil.json2List(Cons.TIME_JSON, new TypeToken<List<SelectorEntity>>() {
        }.getType()), shotsFragment);
    }

    private void initNavDrawer() {
        mViewBinding.ivMainMenu.setOnClickListener(view -> mViewBinding.drawer.openDrawer(Gravity.START));
        //mViewBinding.ivViewMode.setOnClickListener(view -> openViewModeMenu());
        mViewBinding.navView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    break;
                case R.id.nav_followed:
                    break;
                case R.id.nav_collection:
                    break;
                case R.id.nav_favorite:
                    break;
                case R.id.nav_setting:
                    break;
                case R.id.nav_about:
                    break;
            }
            mViewBinding.drawer.closeDrawer(GravityCompat.START);
            return true;
        });

        initDrawerHeader();
    }

    private void initDrawerHeader() {
        View headerView = mViewBinding.navView.getHeaderView(0);
        mNavHeaderBinding = DataBindingUtil.bind(headerView);
        refreshUserInfo(UserInfoManager.getCurrentUser());
        mNavHeaderBinding.btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), AuthorizeActivity.class);
            intent.putExtra(WebActivity.WEB_LOAD_URL, UrlUtils.getAuthorizeUrl());
            startActivityForResult(intent, REQUEST_CODE_AUTHORIZE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_AUTHORIZE) {
            String code = data.getStringExtra(EXTRA_AUTHORIZE_CODE);
            mPresenter.getAccessToken(code);
            mNavHeaderBinding.btnLogin.setVisibility(View.GONE);
            mNavHeaderBinding.tvLoginWelcome.setText("欢迎回来!");
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onBackPressed() {
        if (mViewBinding.drawer.isDrawerOpen(GravityCompat.START)) {
            mViewBinding.drawer.closeDrawer(GravityCompat.START);
        } else if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(this, "再次点击退出应用", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            super.onBackPressed();
        }
    }

    private void initUserInfo() {
        if (!TextUtils.isEmpty(SPUtils.getString(Cons.SP_ACCESS_TOKEN, "")))
            mPresenter.getUserInfo();
    }

    @Override
    public void refreshUserInfo(UserEntity user) {
        mNavHeaderBinding.setUser(user);
    }
}

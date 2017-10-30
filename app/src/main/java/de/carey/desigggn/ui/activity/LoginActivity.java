package de.carey.desigggn.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import de.carey.desigggn.R;
import de.carey.desigggn.base.BaseMVPActivity;
import de.carey.desigggn.databinding.ActivityLoginBinding;
import de.carey.desigggn.ui.contract.LoginContract;
import de.carey.desigggn.ui.presenter.LoginPresenter;
import de.carey.desigggn.util.UrlUtils;

public class LoginActivity extends BaseMVPActivity<LoginPresenter, ActivityLoginBinding> implements LoginContract.View {

    public static final String EXTRA_AUTHORIZE_CODE = "extra_authorize_code";
    public static final int REQUEST_CODE_AUTHORIZE = 1;


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mViewBinding.ibBack.setOnClickListener(v -> finish());
        mViewBinding.btnLogin.setOnClickListener(v -> toAuthorize());
    }

    private void toAuthorize() {
        Intent intent = new Intent(this, AuthorizeActivity.class);
        intent.putExtra(WebActivity.WEB_LOAD_URL, UrlUtils.getAuthorizeUrl());
        startActivityForResult(intent, REQUEST_CODE_AUTHORIZE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_AUTHORIZE) {
            String code = data.getStringExtra(EXTRA_AUTHORIZE_CODE);
            mPresenter.getAccessToken(code);
            mViewBinding.progressBar.setVisibility(View.VISIBLE);
            mViewBinding.progressBar.setIndeterminate(true);
            mViewBinding.btnLogin.setVisibility(View.GONE);
            mViewBinding.tvLoginWelcome.setText("欢迎回来!");
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

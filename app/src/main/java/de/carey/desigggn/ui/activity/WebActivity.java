package de.carey.desigggn.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import de.carey.desigggn.R;
import de.carey.desigggn.base.BaseActivity;
import de.carey.desigggn.databinding.ActivityWebBinding;

public class WebActivity extends BaseActivity<ActivityWebBinding> {

    public static final String WEB_TITLE = "web_title";
    public static final String WEB_LOAD_URL = "web_load_url";

    protected String mTitle;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_web;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        initToolbar();
        initWebView();
    }

    private void initToolbar() {
        mTitle = getIntent().getStringExtra(WEB_TITLE);
        mViewBinding.titleBar.setOnLeftTextClickListener(v -> onBackPressed());
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {
        WebSettings settings = mViewBinding.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);

        mViewBinding.webView.setWebChromeClient(getWebChromeClient());
        mViewBinding.webView.setWebViewClient(getWebViewClient());
        mViewBinding.webView.loadUrl(getIntent().getStringExtra(WEB_LOAD_URL));
    }


    protected WebChromeClient getWebChromeClient() {
        return new MyWebChromeClient();
    }

    protected WebViewClient getWebViewClient() {
        return new MyWebViewClient();
    }

    protected class MyWebChromeClient extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                mViewBinding.progressBar.setVisibility(View.GONE);
            } else {
                if (mViewBinding.progressBar.getVisibility() == View.GONE) {
                    mViewBinding.progressBar.setVisibility(View.VISIBLE);
                }
                mViewBinding.progressBar.setProgress(newProgress);
            }
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            if (TextUtils.isEmpty(mTitle)) {
                mViewBinding.titleBar.setTitleMainText(title);
            }
        }
    }

    protected class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        public void onPageFinished(WebView view, String url) {
            mViewBinding.titleBar.setTitleMainText(view.getTitle());
        }
    }

    @Override
    public void onBackPressed() {
        if (mViewBinding.webView.canGoBack()) {
            mViewBinding.webView.goBack();
            return;
        }
        super.onBackPressed();
    }
}

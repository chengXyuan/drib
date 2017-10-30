package de.carey.desigggn.ui.activity;

import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.orhanobut.logger.Logger;

import de.carey.desigggn.app.Cons;

public class AuthorizeActivity extends WebActivity {

    @Override
    protected WebViewClient getWebViewClient() {
        return new MyWebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.contains("code")) {
                    String code = url.replace(Cons.REDIRECT_URI + "?code=", "")
                            .replace("&state=hunter", "");
                    Logger.d(code);
                    Intent intent = new Intent();
                    intent.putExtra(LoginActivity.EXTRA_AUTHORIZE_CODE, code);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    view.loadUrl(url);
                }
                return true;
            }
        };
    }
}

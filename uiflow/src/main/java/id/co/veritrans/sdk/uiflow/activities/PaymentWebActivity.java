package id.co.veritrans.sdk.uiflow.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import id.co.veritrans.sdk.uiflow.R;
import id.co.veritrans.sdk.coreflow.core.Constants;
import id.co.veritrans.sdk.coreflow.core.VeritransSDK;
import id.co.veritrans.sdk.uiflow.fragments.WebviewFragment;
import id.co.veritrans.sdk.uiflow.widgets.VeritransDialog;

public class PaymentWebActivity extends BaseActivity {
    private Toolbar toolbar;
    private FragmentManager fragmentManager;
    private VeritransSDK veritransSDK;
    private RelativeLayout webviewContainer;
    private String webUrl;
    private String type = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_web);
        saveCurrentFragment = true;
        initializeTheme();
        webUrl = getIntent().getStringExtra(Constants.WEBURL);
        if (getIntent().getStringExtra(Constants.TYPE) != null && !getIntent().getStringExtra(Constants.TYPE).equals("")) {
            type = getIntent().getStringExtra(Constants.TYPE);
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fragmentManager = getSupportFragmentManager();
        toolbar.setTitle(R.string.processing_payment);

        setSupportActionBar(toolbar);
        WebviewFragment webviewFragment;
        if (!type.equals("")) {
            webviewFragment = WebviewFragment.newInstance(webUrl, type);
        } else {
            webviewFragment = WebviewFragment.newInstance(webUrl);
        }
        replaceFragment(webviewFragment, R.id.webview_container, true, false);
    }


    @Override
    public void onBackPressed() {
        VeritransDialog veritransDialog = new VeritransDialog(this,getString(R.string.cancel_transaction),
                getString(R.string.cancel_transaction_message),getString(android.R.string.yes),getString(android.R.string.no));
        veritransDialog.setOnAcceptButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentManager.getBackStackEntryCount() == 1) {
                    finish();
                } else {
                    if (currentFragmentName.equalsIgnoreCase(WebviewFragment.class.getName())) {
                        if (((WebviewFragment) currentFragment).webView.canGoBack()) {
                            ((WebviewFragment) currentFragment).webviewBackPressed();
                        } else {
                            PaymentWebActivity.super.onBackPressed();
                        }
                    } else {
                        PaymentWebActivity.super.onBackPressed();
                    }
                }
            }
        });
        veritransDialog.show();

    }

}

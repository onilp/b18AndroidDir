package com.calvert.paymentgateway;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

//import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.simplify.android.sdk.CardEditor;
import com.simplify.android.sdk.CardToken;
import com.simplify.android.sdk.Simplify;

//import io.fabric.sdk.android.Fabric;

public class CustomerPayActivity extends AppCompatActivity {
    private static final String TAG = CustomerPayActivity.class.getSimpleName();
    private Button payButton;
    private CardEditor cardEditor;
    private Simplify simplify;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_customer_pay);

        MobileAds.initialize(this, getString(R.string.YOUR_ADMOB_APP_ID));

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("0FA20932AFE1095798444FD9AAB7D425").build();
        mAdView.loadAd(adRequest);

        cardEditor = findViewById(R.id.card_editor);
        cardEditor.addOnStateChangedListener(new CardEditor.OnStateChangedListener() {
            @Override
            public void onStateChange(CardEditor cardEditor) {
                payButton.setEnabled(cardEditor.isValid());
            }
        });

        simplify = new Simplify();
        simplify.setApiKey(getString(R.string.simplify_public_key));

        payButton = findViewById(R.id.pay_button);
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simplify.createCardToken(cardEditor.getCard(), new CardToken.Callback() {
                    @Override
                    public void onSuccess(CardToken cardToken) {
                        Log.d(TAG, "Transaction ID: " + cardToken.getId());
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Log.d(TAG, "Transaction Failure: " + throwable.getMessage());
                    }
                });
            }
        });
    }

//    public void forceCrash(View view) {
//        throw new RuntimeException("This is a crash");
//    }
}

package com.calvert.paymentgateway;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.simplify.android.sdk.Card;
import com.simplify.android.sdk.CardToken;
import com.simplify.android.sdk.Simplify;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Simplify simplify;
    private Button payButton;
    private EditText cardNumEditText, cardExpiryMonthEditText, cardExpiryYearEditText, cardCVCEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardNumEditText = findViewById(R.id.cardNum_et);
        cardExpiryMonthEditText = findViewById(R.id.expiryMonth_et);
        cardExpiryYearEditText = findViewById(R.id.expiryYear_et);
        cardCVCEditText = findViewById(R.id.cvc_et);

        //initialize simplify and set public key
        simplify = new Simplify();
        simplify.setApiKey(getString(R.string.simplify_public_key));

        payButton = findViewById(R.id.pay_btn);
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get card details from user inputs
                Card card = new Card()
                        .setNumber(cardNumEditText.getText().toString())
                        .setExpMonth(cardExpiryMonthEditText.getText().toString())
                        .setExpYear(cardExpiryYearEditText.getText().toString())
                        .setCvc(cardCVCEditText.getText().toString());

                simplify.createCardToken(card, new CardToken.Callback() {
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
}

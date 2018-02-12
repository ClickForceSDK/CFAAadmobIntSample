package com.force.click.cfaadmobIntsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    private InterstitialAd admob_InterstitialAd;
    private Button iBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        admob_InterstitialAd = new InterstitialAd(this);
        admob_InterstitialAd.setAdUnitId("ca-app-pub-7236340530869760/3893597888");
        admob_InterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdFailedToLoad(int errorCode) {
                Toast.makeText(MainActivity.this,
                        "Error loading custom event interstitial, code " + errorCode,
                        Toast.LENGTH_SHORT).show();
            }
        });

        iBtn = findViewById(R.id.r1);
        iBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAD();
            }
        });
//        interstitialAd.loadAd(new AdRequest.Builder().build());

        if (admob_InterstitialAd != null && admob_InterstitialAd.isLoaded()){
            admob_InterstitialAd.show();
        }else {
            if (!admob_InterstitialAd.isLoading()&&!admob_InterstitialAd.isLoaded()){
                AdRequest adRequest = new AdRequest.Builder().build();
                AdMobIntCustomAD.getActivity(this);
                admob_InterstitialAd.loadAd(adRequest);
            }
        }



    }

    private void showAD(){
        if (admob_InterstitialAd != null && admob_InterstitialAd.isLoaded()){
            admob_InterstitialAd.show();
        }else {
            if (!admob_InterstitialAd.isLoading()&&!admob_InterstitialAd.isLoaded()){
                AdRequest adRequest = new AdRequest.Builder().build();
//                AdMobIntCustomAD.getActivity(this);
                admob_InterstitialAd.loadAd(adRequest);
            }

        }

    }


}

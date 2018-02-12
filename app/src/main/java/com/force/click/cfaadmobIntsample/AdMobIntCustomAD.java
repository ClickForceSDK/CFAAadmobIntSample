package com.force.click.cfaadmobIntsample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;


import com.clickforce.ad.AdInterstitialView;
import com.clickforce.ad.Listener.AdInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitial;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener;

/**
 * Created by YaoChang on 2017/7/20.
 */


public class AdMobIntCustomAD implements CustomEventInterstitial {
    private AdInterstitialView fullad ;
    private static Activity mActivity ;


    public static void getActivity(Activity activity){
        mActivity = activity;
    }

    @Override
    public void requestInterstitialAd(Context context,
                                      CustomEventInterstitialListener listener,
                                      String serverParameter,
                                      com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest,
                                      Bundle customEventExtras) {
        /*
         * In this method, you should:
         *
         * 1. Create your interstitial ad.
         * 2. Set your ad network's listener.
         * 3. Make an ad request.
         *
         * When setting your ad network's listener, don't forget to send the following callbacks:
         *
         * listener.onAdLoaded(this);
         * listener.onAdFailedToLoad(this, AdRequest.ERROR_CODE_*);
         * listener.onAdOpened(this);
         * listener.onAdLeftApplication(this);
         * listener.onAdClosed(this);
         */

//      Log.d("Parameter", serverParameter);

        fullad = new AdInterstitialView(context);
        fullad.getFullScreenAd(Integer.parseInt(serverParameter));
        fullad.init(mActivity);
//        listener.onAdLoaded();
        fullad.setOnAdInterstitialListener(new AdInterstitialListener() {
            @Override
            public void onCloseFullAd() {

            }

            @Override
            public void onFailToFullAd() {

            }

            @Override
            public void onSuccessToFullAd() {

                fullad.show();
            }

            @Override
            public void onClickToFullAd() {

            }
        });

    }

    @Override
    public void showInterstitial() {
        // Show your interstitial ad.
//        mSampleInterstitial.show();
    }

    @Override
    public void onDestroy() {
//        if (sampleInterstitial != null) {
//            sampleInterstitial.destroy();
//        }
    }

    /**
     * The app is being paused. This call is only forwarded to the adapter if the developer
     * notifies AdMob Mediation that the app is being paused.
     */
    @Override
    public void onPause() {
        // The sample ad network doesn't have an onPause method, so it does nothing.
    }

    /**
     * The app is being resumed. This call is only forwarded to the
     * adapter if the developer notifies AdMob Mediation that the app is
     * being resumed.
     */
    @Override
    public void onResume() {
        // The sample ad network doesn't have an onResume method, so it does nothing.
    }
}

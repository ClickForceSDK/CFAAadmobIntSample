package com.force.click.cfaadmobIntsample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;


import com.clickforce.ad.AdInterstitialView;
import com.clickforce.ad.Listener.AdInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitial;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener;



public class AdMobIntCustomAD implements CustomEventInterstitial {
    private AdInterstitialView fullad ;
    private static Activity mActivity ;
    private CustomEventInterstitialListener listenertoCF;

    public static void getActivity(Activity activity){
        mActivity = activity;
    }

    @Override
    public void requestInterstitialAd(final Context context,
                                      CustomEventInterstitialListener listener,
                                      String serverParameter,
                                      com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest,
                                      Bundle customEventExtras) {

//      Log.d("Parameter", serverParameter);

        fullad = new AdInterstitialView(context);
        fullad.getFullScreenAd(Integer.parseInt(serverParameter));
        fullad.init(mActivity);

        listenertoCF = listener;
        listener.onAdLoaded();
        fullad.setOnAdInterstitialListener(new AdInterstitialListener() {
            @Override
            public void onCloseFullAd() {
                listenertoCF.onAdClosed();
            }

            @Override
            public void onFailToFullAd() {
                listenertoCF.onAdFailedToLoad(2);
            }

            @Override
            public void onSuccessToFullAd() {
                fullad.show();
                showInterstitial();
            }

            @Override
            public void onClickToFullAd() {
                listenertoCF.onAdClicked();
            }
        });

    }

    @Override
    public void showInterstitial() {
        // Show your interstitial ad.
//        mSampleInterstitial.show();
            listenertoCF.onAdLoaded();
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

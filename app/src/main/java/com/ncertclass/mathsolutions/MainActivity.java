package com.ncertclass.mathsolutions;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3780736957915970/4737000051");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            private static final String AD_UNIT_ID ="ca-app-pub-3780736957915970/4737000051" ;

            @Override
            public void onAdClosed() {
                AdRequest adRequest = new AdRequest.Builder().addTestDevice(AD_UNIT_ID).build();
                mInterstitialAd.loadAd(adRequest);
            }
        });


        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(MainActivity.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(MainActivity.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid


            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(0);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }


                    Intent intent = new Intent(MainActivity.this, ActivityOne.class);
                    startActivity(intent);


                }

            }); CardView cardView1 = (CardView) mainGrid.getChildAt(1);
        cardView1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if (mInterstitialAd.isLoaded()) {
                                                mInterstitialAd.show();
                                            } else {
                                                Log.d("TAG", "The interstitial wasn't loaded yet.");
                                            }

                                            Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                                            startActivity(intent);

                                        }

                                    }
            );
        CardView cardView2 = (CardView) mainGrid.getChildAt(2);
        cardView2.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             if (mInterstitialAd.isLoaded()) {
                                                 mInterstitialAd.show();
                                             } else {
                                                 Log.d("TAG", "The interstitial wasn't loaded yet.");
                                             }

                                             Intent intent = new Intent(MainActivity.this, ActivityThree.class);
                                             startActivity(intent);

                                         }

                                     }
        );
        CardView cardView3 = (CardView) mainGrid.getChildAt(3);
        cardView3.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             if (mInterstitialAd.isLoaded()) {
                                                 mInterstitialAd.show();
                                             } else {
                                                 Log.d("TAG", "The interstitial wasn't loaded yet.");
                                             }

                                             Intent intent = new Intent(MainActivity.this, ActivityFour.class);
                                             startActivity(intent);

                                         }

                                     }
        );
        CardView cardView4 = (CardView) mainGrid.getChildAt(4);
        cardView4.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             if (mInterstitialAd.isLoaded()) {
                                                 mInterstitialAd.show();
                                             } else {
                                                 Log.d("TAG", "The interstitial wasn't loaded yet.");
                                             }

                                             Intent intent = new Intent(MainActivity.this, ActivityFive.class);
                                             startActivity(intent);

                                         }

                                     }
        );


        }
    }

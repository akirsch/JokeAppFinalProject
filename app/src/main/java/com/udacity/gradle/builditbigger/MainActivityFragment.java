package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.jokedisplay.JokeDisplayActivity;
import com.example.jokelib.JavaJoke;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener, RetrieveJokeAsyncTask.AsyncResponse {

    public static final String JOKE_STRING_KEY = "joke_string";
    private String jokeFromServer;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);

        if (BuildConfig.FLAVOR.equals("free")){
            // Create an ad request. Check logcat output for the hashed device ID to
            // get test ads on a physical device. e.g.
            // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build();
            mAdView.loadAd(adRequest);
        }
        else{
            mAdView.setVisibility(View.GONE);
        }


        Button jokeButton = root.findViewById(R.id.joke_button);
        jokeButton.setOnClickListener(this);

        return root;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.joke_button:
                JavaJoke javaJoke = new JavaJoke();
                Toast.makeText(getContext(), javaJoke.getJavaJoke(), Toast.LENGTH_SHORT).show();

                // create intent to launch new Activity from Android Library
                RetrieveJokeAsyncTask asyncTask = new RetrieveJokeAsyncTask(getContext(), this);
                asyncTask.execute();


                    break;
                }


        }


    @Override
    public void supplyJoke(String joke) {
        jokeFromServer = joke;
        if (jokeFromServer != null) {
            Intent intent = new Intent(getContext(), JokeDisplayActivity.class);
            intent.putExtra(JOKE_STRING_KEY, jokeFromServer);
            startActivity(intent);

        }
    }
}

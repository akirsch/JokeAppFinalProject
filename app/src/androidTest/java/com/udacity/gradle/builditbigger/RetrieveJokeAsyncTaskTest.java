package com.udacity.gradle.builditbigger;


import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RetrieveJokeAsyncTaskTest implements RetrieveJokeAsyncTask.AsyncResponse {

    private String jokeFromServer = null;

    @Test
    public void checkRetrieveJokeAsyncTaskResponse(){
        RetrieveJokeAsyncTask asyncTask = new RetrieveJokeAsyncTask(InstrumentationRegistry.getContext(), this);
        asyncTask.execute();
    }


    @Override
    public void supplyJoke(String joke) {
        jokeFromServer = joke;
        assertNotNull(jokeFromServer);
        assertTrue(joke,joke.length()>0);

    }
}

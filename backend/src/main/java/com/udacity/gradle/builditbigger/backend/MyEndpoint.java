package com.udacity.gradle.builditbigger.backend;

import com.example.jokelib.JavaJoke;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that retrieves a joke from the Java library */
    @ApiMethod(name = "pullJoke")
    public MyBean pullJoke() {

        MyBean response = new MyBean();
        JavaJoke javaJoke = new JavaJoke();
        String data = javaJoke.getJavaJoke();
        response.setData(data);

        return response;
    }

}

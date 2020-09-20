package com.iamvickyav.jarvis.googlesignin;

import android.content.Intent;

import java.io.Serializable;

public class FBResponse implements Serializable {

    String id;
    String first_name;
    String last_name;
    String email;
    String url;

    @Override
    public String toString() {
        return "FBResponse{" +
                "id='" + id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
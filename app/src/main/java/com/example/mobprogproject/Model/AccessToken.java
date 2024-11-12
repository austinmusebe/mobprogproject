package com.example.mobprogproject.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccessToken {
    @SerializedName("")
    @Expose
    public String accessToken;
    @SerializedName("")
    @Expose
    private String expiresIn;

    public AccessToken(String accessToken, String expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }
}

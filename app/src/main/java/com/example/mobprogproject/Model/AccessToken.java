package com.example.mobprogproject.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccessToken {
    @SerializedName("ANJmlWDTs4CgYL3jhtP0qyv4AZv9")
    @Expose
    public String accessToken;
    @SerializedName("3599")
    @Expose
    private String expiresIn;

    public AccessToken(String accessToken, String expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }
}

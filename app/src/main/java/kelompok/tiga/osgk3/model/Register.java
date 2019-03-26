package kelompok.tiga.osgk3.model;

import com.google.gson.annotations.SerializedName;

public class Register {

    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
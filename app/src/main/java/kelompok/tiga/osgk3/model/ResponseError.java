package kelompok.tiga.osgk3.model;

import com.google.gson.annotations.SerializedName;

public class ResponseError {

    @SerializedName("error")
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
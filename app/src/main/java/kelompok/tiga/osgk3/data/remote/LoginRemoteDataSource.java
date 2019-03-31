package kelompok.tiga.osgk3.data.remote;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import kelompok.tiga.osgk3.data.DataSource;
import kelompok.tiga.osgk3.model.ResponseError;
import kelompok.tiga.osgk3.model.ResponseLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * *********************************************
 * Created by ukie on 3/26/19 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 * *********************************************
 * © 2019 | All Right Reserved
 */
public class LoginRemoteDataSource implements DataSource {
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    private String username;
    private String password;

    public LoginRemoteDataSource() {
    }

    //create constructor to passing username, password
    public void setEmailPass(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void getResponse(GetResponseCallback callback) {
        Call<ResponseLogin> call = apiInterface.postLogin(username, password);
        call.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                //check response
                if (response.code() == 400) {
                    Gson gson = new GsonBuilder().create();
                    try {
                        ResponseError mError = gson.fromJson(response.errorBody().string(), ResponseError.class);
                        callback.onDataNotAvailable("Login - " + mError.getError());

                    } catch (IOException e) {
                        // handle failure to read error
                    }
                } else {
                    callback.onResponseLoaded(response.body());
                }

            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {

                callback.onDataNotAvailable(t.toString());

            }
        });

    }

}

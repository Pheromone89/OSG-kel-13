package kelompok.tiga.osgk3.data.remote;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import kelompok.tiga.osgk3.data.DataSource;
import kelompok.tiga.osgk3.model.ResponseError;
import kelompok.tiga.osgk3.model.ResponseRegister;
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
public class RegisterRemoteDataSource implements DataSource {
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    private String username;
    private String password;

    public RegisterRemoteDataSource() {
    }

    //create constructor to passing username, password
    public void setEmailPass(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void getResponse(GetResponseCallback callback) {
        Call<ResponseRegister> call = apiInterface.postRegister(username, password);
        call.enqueue(new Callback<ResponseRegister>() {
            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                //check response
                if (response.code() == 400) {
                    Gson gson = new GsonBuilder().create();
                    try {
                        ResponseError mError = gson.fromJson(response.errorBody().string(), ResponseError.class);
                        callback.onDataNotAvailable("Register - " + mError.getError());

                    } catch (IOException e) {
                        // handle failure to read error
                    }
                } else {
                    callback.onResponseLoaded(response.body());
                }

            }

            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {

                callback.onDataNotAvailable(t.toString());

            }
        });

    }

    @Override
    public void getUserResponse(GetUserCallback callback) {

    }
}

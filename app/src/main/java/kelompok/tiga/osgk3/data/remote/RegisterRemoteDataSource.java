package kelompok.tiga.osgk3.data.remote;


import kelompok.tiga.osgk3.data.DataSource;
import kelompok.tiga.osgk3.model.Register;
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
        Call<Register> call = apiInterface.postRegister(username, password);
        call.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                callback.onResponseLoaded(response.body());
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                callback.onDataNotAvailable(t.toString());

            }
        });

    }
}

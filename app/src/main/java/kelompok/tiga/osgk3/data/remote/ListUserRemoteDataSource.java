package kelompok.tiga.osgk3.data.remote;


import kelompok.tiga.osgk3.data.DataSource;
import kelompok.tiga.osgk3.model.user.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 30, March, 2019
 */
public class ListUserRemoteDataSource implements DataSource {
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    @Override
    public void getUserResponse(GetUserCallback callback) {
        Call<UserResponse> call = apiInterface.getList(2);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                callback.onResponsesLoaded(response.body());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                callback.onDataNotAvailable(t.toString());
            }
        });
    }

    @Override
    public void getResponse(GetResponseCallback callback) {

    }
}

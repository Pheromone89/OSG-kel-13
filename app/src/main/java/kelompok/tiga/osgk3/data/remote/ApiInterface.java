package kelompok.tiga.osgk3.data.remote;

import kelompok.tiga.osgk3.model.ResponseLogin;
import kelompok.tiga.osgk3.model.ResponseRegister;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * *********************************************
 * Created by ukie on 3/26/19 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 * *********************************************
 * © 2019 | All Right Reserved
 */
public interface ApiInterface {

    @FormUrlEncoded
    @POST("register")
    Call<ResponseRegister> postRegister(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("login")
    Call<ResponseLogin> postLogin(@Field("email") String email, @Field("password") String password);
}

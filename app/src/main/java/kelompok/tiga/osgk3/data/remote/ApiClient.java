package kelompok.tiga.osgk3.data.remote;

import java.util.concurrent.TimeUnit;

import kelompok.tiga.osgk3.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * *********************************************
 * Created by ukie on 3/26/19 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 * *********************************************
 * © 2019 | All Right Reserved
 */
public class ApiClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkhttp())
                .build();

        return retrofit;
    }

    //add http log
    public static OkHttpClient createOkhttp() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(60, TimeUnit.SECONDS);
        builder.readTimeout(60, TimeUnit.SECONDS);
        builder.writeTimeout(60, TimeUnit.SECONDS);
        builder.hostnameVerifier((hostname, session) -> true);

        builder.retryOnConnectionFailure(true);
        builder.addInterceptor(loggingInterceptor);
        return builder.build();
    }
}

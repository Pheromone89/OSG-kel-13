package kelompok.tiga.osgk3.data;

import android.util.Log;

import kelompok.tiga.osgk3.data.remote.RegisterRemoteDataSource;
import kelompok.tiga.osgk3.model.Login;

/**
 * *********************************************
 * Created by ukie on 3/26/19 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 * *********************************************
 * © 2019 | All Right Reserved
 */
public class RegisterRepository implements DataSource {
    private RegisterRemoteDataSource registerRemoteDataSource;
    private Login login;

    public RegisterRepository(RegisterRemoteDataSource registerRemoteDataSource,
                              Login login) {
        this.registerRemoteDataSource = registerRemoteDataSource;
        this.login = login;
    }

    @Override
    public void getResponse(GetResponseCallback callback) {
        registerRemoteDataSource.setEmailPass(login.getEmail(), login.getPassword());
        registerRemoteDataSource.getResponse(new GetResponseCallback() {
            @Override
            public void onResponseLoaded(Object data) {
                callback.onResponseLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                callback.onDataNotAvailable(errorMessage);

            }
        });
    }
}

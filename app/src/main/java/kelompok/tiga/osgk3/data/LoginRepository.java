package kelompok.tiga.osgk3.data;

import kelompok.tiga.osgk3.data.remote.LoginRemoteDataSource;
import kelompok.tiga.osgk3.model.Login;

/**
 * *********************************************
 * Created by ukie on 3/26/19 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 * *********************************************
 * © 2019 | All Right Reserved
 */
public class LoginRepository implements DataSource {
    private LoginRemoteDataSource loginRemoteDataSource;
    private Login login;

    public LoginRepository(LoginRemoteDataSource loginRemoteDataSource,
                           Login login) {
        this.loginRemoteDataSource = loginRemoteDataSource;
        this.login = login;
    }

    @Override
    public void getResponse(GetResponseCallback callback) {
        loginRemoteDataSource.setEmailPass(login.getEmail(), login.getPassword());
        loginRemoteDataSource.getResponse(new GetResponseCallback() {
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

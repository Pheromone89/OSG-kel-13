package kelompok.tiga.osgk3;

import kelompok.tiga.osgk3.data.LoginRepository;
import kelompok.tiga.osgk3.data.RegisterRepository;
import kelompok.tiga.osgk3.data.remote.LoginRemoteDataSource;
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
public class Injection {
    public static RegisterRepository provideRegisterRepository(Login login) {
        return new RegisterRepository(new RegisterRemoteDataSource(), login);
    }

    public static LoginRepository provideLoginRepository(Login login) {
        return new LoginRepository(new LoginRemoteDataSource(), login);
    }
}

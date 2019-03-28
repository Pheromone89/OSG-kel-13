package kelompok.tiga.osgk3.view.landing;

import kelompok.tiga.osgk3.model.ResponseLogin;
import kelompok.tiga.osgk3.model.ResponseRegister;

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 21, March, 2019
 */
public interface NavigatorLanding {

    void onSuccessRegister(ResponseRegister responseRegister);

    void onSuccessLogin(ResponseLogin responseLogin);

    void onFailed(String message);

}

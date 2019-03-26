package kelompok.tiga.osgk3.view.landing;

import kelompok.tiga.osgk3.model.Register;

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 21, March, 2019
 */
public interface NavigatorLanding {

    void onSuccessRegister(Register register);

    void onSuccessLogin();

    void onFailed(String message);

}

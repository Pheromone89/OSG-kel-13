package kelompok.tiga.osgk3.viewmodel;

import android.content.Context;
import android.text.TextUtils;

import kelompok.tiga.osgk3.data.DataSource;
import kelompok.tiga.osgk3.data.RegisterRepository;
import kelompok.tiga.osgk3.model.Login;
import kelompok.tiga.osgk3.model.Register;
import kelompok.tiga.osgk3.view.landing.NavigatorLanding;

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 21, March, 2019
 */
public class LandingViewModel {

    public final static String FAILED_VALIDASI = "Harap isi email dan password";
    private Context context;
    private Login login;
    private NavigatorLanding navigatorLanding;
    private RegisterRepository registerRepository;

    public LandingViewModel(Context context, Login login, RegisterRepository registerRepository) {
        this.context = context;
        this.login = login;
        this.registerRepository = registerRepository;
    }

    public void updateModel(String email, String password) {
        login.setEmail(email);
        login.setPassword(password);
    }

    public void validLogin() {

        if (!TextUtils.isEmpty(login.getEmail()) && !TextUtils.isEmpty(login.getPassword())) {
            postLogin(login);
        } else {
            navigatorLanding.onFailed(FAILED_VALIDASI);
        }

    }

    public void validRegistrasi() {

        if (!TextUtils.isEmpty(login.getEmail()) && !TextUtils.isEmpty(login.getPassword())) {
            postRegister();
        } else {
            navigatorLanding.onFailed(FAILED_VALIDASI);
        }

    }


    public void setNavigator(NavigatorLanding navigator) {
        navigatorLanding = navigator;
    }

    private void postLogin(Login login) {
        navigatorLanding.onSuccessLogin();
    }

    private void postRegister() {
        registerRepository.getResponse(new DataSource.GetResponseCallback() {
            @Override
            public void onResponseLoaded(Object data) {
                navigatorLanding.onSuccessRegister((Register) data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                navigatorLanding.onFailed(errorMessage);
            }
        });

    }

}

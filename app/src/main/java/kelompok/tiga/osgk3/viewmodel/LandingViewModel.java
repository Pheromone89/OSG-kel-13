package kelompok.tiga.osgk3.viewmodel;

import android.content.Context;
import android.text.TextUtils;

import kelompok.tiga.osgk3.data.DataSource;
import kelompok.tiga.osgk3.data.LoginRepository;
import kelompok.tiga.osgk3.data.RegisterRepository;
import kelompok.tiga.osgk3.model.Login;
import kelompok.tiga.osgk3.model.ResponseLogin;
import kelompok.tiga.osgk3.model.ResponseRegister;
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
    private LoginRepository loginRepository;

    public LandingViewModel(Context context,
                            Login login,
                            RegisterRepository registerRepository,
                            LoginRepository loginRepository) {
        this.context = context;
        this.login = login;
        this.registerRepository = registerRepository;
        this.loginRepository = loginRepository;
    }

    public void updateModel(String email, String password) {
        login.setEmail(email);
        login.setPassword(password);
    }

    public void validLogin() {

        //skip password check to get error from API
        if (!TextUtils.isEmpty(login.getEmail())) {
            postLogin();
        } else {
            navigatorLanding.onFailed(FAILED_VALIDASI);
        }

    }

    public void validRegistrasi() {

        //skip password check to get error from API
        if (!TextUtils.isEmpty(login.getEmail())) {
            postRegister();
        } else {
            navigatorLanding.onFailed(FAILED_VALIDASI);
        }

    }


    public void setNavigator(NavigatorLanding navigator) {
        navigatorLanding = navigator;
    }

    private void postLogin() {
        loginRepository.getResponse(new DataSource.GetResponseCallback() {
            @Override
            public void onResponseLoaded(Object data) {
                navigatorLanding.onSuccessLogin((ResponseLogin) data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                navigatorLanding.onFailed(errorMessage);
            }
        });
    }

    private void postRegister() {
        registerRepository.getResponse(new DataSource.GetResponseCallback() {
            @Override
            public void onResponseLoaded(Object data) {
                navigatorLanding.onSuccessRegister((ResponseRegister) data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                navigatorLanding.onFailed(errorMessage);
            }
        });

    }

}

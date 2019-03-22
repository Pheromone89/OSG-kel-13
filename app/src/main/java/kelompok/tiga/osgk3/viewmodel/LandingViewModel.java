package kelompok.tiga.osgk3.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import kelompok.tiga.osgk3.model.Login;
import kelompok.tiga.osgk3.view.landing.NavigatorLanding;

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 21, March, 2019
 */
public class LandingViewModel {

    public final static  String FAILED_VALIDASI = "Harap isi email dan password";
    private Context context;
    private Login login;
    private NavigatorLanding navigatorLanding;

    public LandingViewModel(Context context, Login login) {
        this.context = context;
        this.login = login;
    }

    public void updateModel(String email, String password){

        login.setEmail(email);
        login.setPassword(password);

    }

    public void validLogin(){

        if (!TextUtils.isEmpty(login.getEmail()) && !TextUtils.isEmpty(login.getPassword())){
            postLogin(login);
        } else {
            navigatorLanding.onFailed(FAILED_VALIDASI);
        }

    }

    public void validRegistrasi(){

        if (!TextUtils.isEmpty(login.getEmail()) && !TextUtils.isEmpty(login.getPassword())){
            postRegistrasi(login);
        } else {
            navigatorLanding.onFailed(FAILED_VALIDASI);
        }

    }


    public void setNavigator(NavigatorLanding navigator) {
        navigatorLanding = navigator;
    }

    private void postLogin(Login login){
            navigatorLanding.onSuccess();
    }

    private void postRegistrasi(Login login){
            navigatorLanding.onSuccess();
    }

}

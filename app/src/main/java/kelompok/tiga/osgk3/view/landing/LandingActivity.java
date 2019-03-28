package kelompok.tiga.osgk3.view.landing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import kelompok.tiga.osgk3.Injection;
import kelompok.tiga.osgk3.MainActivity;
import kelompok.tiga.osgk3.R;
import kelompok.tiga.osgk3.databinding.ActivityLandingBinding;
import kelompok.tiga.osgk3.model.Login;
import kelompok.tiga.osgk3.model.ResponseLogin;
import kelompok.tiga.osgk3.model.ResponseRegister;
import kelompok.tiga.osgk3.utils.PrefManager;
import kelompok.tiga.osgk3.viewmodel.LandingViewModel;

public class LandingActivity extends AppCompatActivity implements NavigatorLanding {

    private ActivityLandingBinding binding;
    private LandingViewModel viewModel;
    private PrefManager prefManager;
    private Login login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefManager = new PrefManager(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_landing);

        login = new Login();
        viewModel = new LandingViewModel(this, login,
                Injection.provideRegisterRepository(login),
                Injection.provideLoginRepository(login));
        viewModel.setNavigator(this);


        binding.landingButtonLogin.setOnClickListener((v) -> {
            viewModel.updateModel(Objects.requireNonNull(binding.landingEditTextUsername.getText()).toString()
                    , Objects.requireNonNull(binding.landingEditTextPassword.getText()).toString());
            viewModel.validLogin();
        });

        binding.landingButtonRegistrasi.setOnClickListener((v -> {
            viewModel.updateModel(Objects.requireNonNull(binding.landingEditTextUsername.getText()).toString()
                    , Objects.requireNonNull(binding.landingEditTextPassword.getText()).toString());
            viewModel.validRegistrasi();
        }));
    }

    @Override
    public void onSuccessRegister(ResponseRegister responseRegister) {
        showToast(getString(R.string.register_successfully) + " - Token : " + responseRegister.getToken());
    }

    @Override
    public void onSuccessLogin(ResponseLogin responseLogin) {
        showToast(getString(R.string.login_successfully) + " - Token : " + responseLogin.getToken());
        prefManager.saveString(prefManager.PREF_USER, login.email); //save user in prefManager
        prefManager.saveBoolean(prefManager.PREF_IS_LOGIN, true);
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    @Override
    public void onFailed(String message) {
        showToast(message);
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

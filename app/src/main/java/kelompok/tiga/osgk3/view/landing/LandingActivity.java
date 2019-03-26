package kelompok.tiga.osgk3.view.landing;

import android.os.Bundle;
import android.widget.Toast;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import kelompok.tiga.osgk3.Injection;
import kelompok.tiga.osgk3.R;
import kelompok.tiga.osgk3.databinding.ActivityLandingBinding;
import kelompok.tiga.osgk3.model.Login;
import kelompok.tiga.osgk3.model.Register;
import kelompok.tiga.osgk3.viewmodel.LandingViewModel;

public class LandingActivity extends AppCompatActivity implements NavigatorLanding {

    private ActivityLandingBinding binding;
    private LandingViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_landing);

        Login login = new Login();
        viewModel = new LandingViewModel(this, login, Injection.provideRegisterRepository(login));
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
    public void onSuccessRegister(Register register) {
        showToast(getString(R.string.login_successfully) + " - Token : " + register.getToken());
//        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void onSuccessLogin() {

    }

    @Override
    public void onFailed(String message) {
        showToast(message);
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

package kelompok.tiga.osgk3.view.landing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import kelompok.tiga.osgk3.MainActivity;
import kelompok.tiga.osgk3.R;
import kelompok.tiga.osgk3.model.Login;
import kelompok.tiga.osgk3.viewmodel.LandingViewModel;

public class LandingActivity extends AppCompatActivity implements NavigatorLanding {


    private TextInputEditText edtUsername, edtPassword;
    private MaterialButton btnLogin, btnRegistrasi;

    private LandingViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        setViews();

        Login login = new Login();
        viewModel = new LandingViewModel(this, login);
        viewModel.setNavigator(this);


        btnLogin.setOnClickListener((v)->{
            viewModel.updateModel(Objects.requireNonNull(edtUsername.getText()).toString(), Objects.requireNonNull(edtPassword.getText()).toString());
            viewModel.validLogin();
        });

        btnRegistrasi.setOnClickListener((v -> {
            viewModel.updateModel(Objects.requireNonNull(edtUsername.getText()).toString(), Objects.requireNonNull(edtPassword.getText()).toString());
            viewModel.validRegistrasi();
        }));
    }

    // sementara nanti di ganti jadi databinding
    void setViews(){
        edtUsername = findViewById(R.id.landingEditTextUsername);
        edtPassword = findViewById(R.id.landingEditTextPassword);
        btnLogin = findViewById(R.id.landingButtonLogin);
        btnRegistrasi = findViewById(R.id.landingButtonRegistrasi);

    }

    @Override
    public void onSuccess() {
        showToast("BERHASIL LOGIN");
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void onFailed(String message) {
        showToast(message);
    }


    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

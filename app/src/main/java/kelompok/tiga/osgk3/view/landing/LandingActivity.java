package kelompok.tiga.osgk3.view.landing;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kelompok.tiga.osgk3.R;

public class LandingActivity extends AppCompatActivity {

    @BindView(R.id.landingEditTextUsername)
    TextInputEditText landingEditTextUsername;
    @BindView(R.id.landingEditTextPassword)
    TextInputEditText landingEditTextPassword;
    @BindView(R.id.landingButtonLogin)
    MaterialButton landingButtonLogin;
    @BindView(R.id.landingButtonRegistrasi)
    MaterialButton landingButtonRegistrasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        ButterKnife.bind(this);


    }



    void validasi (){

    }





    @OnClick({R.id.landingButtonLogin, R.id.landingButtonRegistrasi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.landingButtonLogin:

                break;
            case R.id.landingButtonRegistrasi:

                break;
        }
    }
}

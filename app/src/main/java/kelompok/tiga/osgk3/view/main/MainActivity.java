package kelompok.tiga.osgk3.view.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import kelompok.tiga.osgk3.R;
import kelompok.tiga.osgk3.databinding.ActivityMainBinding;
import kelompok.tiga.osgk3.utils.PrefManager;
import kelompok.tiga.osgk3.view.landing.LandingActivity;

public class MainActivity extends AppCompatActivity {

    private PrefManager prefManager;

    private MyListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        prefManager = new PrefManager(this);

        if (!prefManager.getBoolean(prefManager.PREF_IS_LOGIN)) {
            startActivity(new Intent(getApplicationContext(), LandingActivity.class));
            finish();
        }

        listener = new MyListener(this);
        binding.setListener(listener);
    }


}

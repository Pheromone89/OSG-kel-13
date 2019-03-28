package kelompok.tiga.osgk3;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import kelompok.tiga.osgk3.utils.PrefManager;
import kelompok.tiga.osgk3.view.landing.LandingActivity;

public class MainActivity extends AppCompatActivity {
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefManager = new PrefManager(this);

        if (!prefManager.getBoolean(prefManager.PREF_IS_LOGIN)) {
            startActivity(new Intent(getApplicationContext(), LandingActivity.class));
            finish();
        }
    }
}

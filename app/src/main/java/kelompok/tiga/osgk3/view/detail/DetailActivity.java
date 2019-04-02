package kelompok.tiga.osgk3.view.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import kelompok.tiga.osgk3.R;
import kelompok.tiga.osgk3.databinding.ActivityDetailBinding;
import kelompok.tiga.osgk3.model.user.Data;

import android.os.Bundle;

import com.google.gson.Gson;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
    private Data data = new Data();
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        String extra =  getIntent().getStringExtra("key");
        data = gson.fromJson(extra, Data.class);

        binding.imgTaskbarBack.setOnClickListener( v -> onBackPressed());

        binding.setUs(data);

    }
}

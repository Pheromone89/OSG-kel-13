package kelompok.tiga.osgk3.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kelompok.tiga.osgk3.Injection;
import kelompok.tiga.osgk3.R;
import kelompok.tiga.osgk3.databinding.ActivityMainBinding;
import kelompok.tiga.osgk3.model.user.Data;
import kelompok.tiga.osgk3.utils.PrefManager;
import kelompok.tiga.osgk3.view.landing.LandingActivity;
import kelompok.tiga.osgk3.view.main.adapter.AdapterUser;
import kelompok.tiga.osgk3.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity implements NavigatorMain {

    private MainViewModel viewModel;
    private AdapterUser adapterUser;
    private RecyclerView recyclerUser;
    private List<Data> dataList;
    private ActivityMainBinding binding;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefManager = new PrefManager(this);

        if (!prefManager.getBoolean(prefManager.PREF_IS_LOGIN)) {
            startActivity(new Intent(getApplicationContext(), LandingActivity.class));
            finish();
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new MainViewModel(Injection.provideListUserRepository(this), this);
        dataList = new ArrayList<>();

        viewModel.setNavigator(this);
        viewModel.getListUser();

        binding.setVm(viewModel);
        initAdapter();
    }

    @Override
    public void loadListUser(List<Data> list) {
        dataList.addAll(list);
        adapterUser.notifyDataSetChanged();
    }

    @Override
    public void errorLoadListUser(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void initAdapter(){
        adapterUser = new AdapterUser(dataList);
        recyclerUser = binding.recyclerUser;
        recyclerUser.setLayoutManager(new LinearLayoutManager(this));
        recyclerUser.addItemDecoration(new DividerItemDecoration(this,   DividerItemDecoration.VERTICAL));
        recyclerUser.setAdapter(adapterUser);
    }
}

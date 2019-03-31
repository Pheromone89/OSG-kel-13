package kelompok.tiga.osgk3.view.list;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kelompok.tiga.osgk3.Injection;
import kelompok.tiga.osgk3.R;
import kelompok.tiga.osgk3.databinding.ActivityListUserBinding;
import kelompok.tiga.osgk3.model.user.Data;
import kelompok.tiga.osgk3.view.list.adapter.AdapterUser;
import kelompok.tiga.osgk3.viewmodel.ListViewModel;

public class ListActivity extends AppCompatActivity implements NavigatorList {

    private ListViewModel viewModel;
    private AdapterUser adapterUser;
    private RecyclerView recyclerUser;
    private List<Data> dataList;
    private ActivityListUserBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_user);

        viewModel = new ListViewModel(Injection.provideListUserRepository(this), this);
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

    }

    private void initAdapter(){
        adapterUser = new AdapterUser(dataList);
        recyclerUser = binding.recyclerUser;
        recyclerUser.setLayoutManager(new LinearLayoutManager(this));
        recyclerUser.addItemDecoration(new DividerItemDecoration(this,   DividerItemDecoration.VERTICAL));
        recyclerUser.setAdapter(adapterUser);

    }
}

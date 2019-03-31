package kelompok.tiga.osgk3.view.list.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import kelompok.tiga.osgk3.R;
import kelompok.tiga.osgk3.databinding.ItemListUsersBinding;
import kelompok.tiga.osgk3.model.user.Data;

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 30, March, 2019
 */
public class AdapterUser extends RecyclerView.Adapter<AdapterUser.ViewHolder> {

    private List<Data> listDataUser;
    private LayoutInflater layoutInflater;

    public AdapterUser(List<Data> listDataUser) {
        this.listDataUser = listDataUser;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemListUsersBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_list_users, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setUs(listDataUser.get(position));
    }

    @Override
    public int getItemCount() {
        return listDataUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemListUsersBinding binding;

        public ViewHolder(ItemListUsersBinding itemListUsersBinding) {
            super(itemListUsersBinding.getRoot());
            this.binding = itemListUsersBinding;
        }
    }
}

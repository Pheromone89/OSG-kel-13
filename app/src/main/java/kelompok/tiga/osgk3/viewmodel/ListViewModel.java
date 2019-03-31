package kelompok.tiga.osgk3.viewmodel;

import android.content.Context;

import kelompok.tiga.osgk3.data.DataSource;
import kelompok.tiga.osgk3.data.ListUserRepository;
import kelompok.tiga.osgk3.data.UserDataSource;
import kelompok.tiga.osgk3.model.user.UserResponse;
import kelompok.tiga.osgk3.view.list.NavigatorList;

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 30, March, 2019
 */
public class ListViewModel {
    private ListUserRepository userRepository;
    private Context context;
    private NavigatorList navigatorList;

    public ListViewModel(ListUserRepository userRepository, Context context) {
        this.userRepository = userRepository;
        this.context = context;
    }

    public void setNavigator(NavigatorList navigator){
        navigatorList = navigator;
    }

    public void getListUser(){
        userRepository.getUserResponse(new UserDataSource.GetUserCallback() {
            @Override
            public void onResponsesLoaded(UserResponse data) {
                navigatorList.loadListUser(data.getData());
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                navigatorList.errorLoadListUser(errorMessage);
            }
        });
    }
}

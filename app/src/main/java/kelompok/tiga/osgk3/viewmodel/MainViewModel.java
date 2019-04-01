package kelompok.tiga.osgk3.viewmodel;

import android.content.Context;

import kelompok.tiga.osgk3.data.DataSource;
import kelompok.tiga.osgk3.data.ListUserRepository;
import kelompok.tiga.osgk3.model.user.UserResponse;
import kelompok.tiga.osgk3.view.main.NavigatorMain;

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 30, March, 2019
 */
public class MainViewModel {
    private ListUserRepository userRepository;
    private Context context;
    private NavigatorMain navigatorMain;

    public MainViewModel(ListUserRepository userRepository, Context context) {
        this.userRepository = userRepository;
        this.context = context;
    }

    public void setNavigator(NavigatorMain navigator){
        navigatorMain = navigator;
    }

    public void getListUser(){
        userRepository.getUserResponse(new DataSource.GetUserCallback() {
            @Override
            public void onResponsesLoaded(UserResponse data) {
                navigatorMain.loadListUser(data.getData());
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                navigatorMain.errorLoadListUser(errorMessage);
            }
        });
    }
}

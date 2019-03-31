package kelompok.tiga.osgk3.data;

import kelompok.tiga.osgk3.data.remote.ListUserRemoteDataSource;
import kelompok.tiga.osgk3.model.user.UserResponse;

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 30, March, 2019
 */
public class ListUserRepository implements UserDataSource {

    private ListUserRemoteDataSource listUserRemoteDataSource;

    public ListUserRepository(ListUserRemoteDataSource listUserRemoteDataSource) {
        this.listUserRemoteDataSource = listUserRemoteDataSource;
    }

    @Override
    public void getUserResponse(GetUserCallback callback) {
        listUserRemoteDataSource.getUserResponse(new GetUserCallback() {
            @Override
            public void onResponsesLoaded(UserResponse data) {
                callback.onResponsesLoaded(data);
            }
            @Override
            public void onDataNotAvailable(String errorMessage) {
                callback.onDataNotAvailable(errorMessage);
            }
        });
    }
}

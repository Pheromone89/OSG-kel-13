package kelompok.tiga.osgk3.data;

import kelompok.tiga.osgk3.model.user.UserResponse;

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 30, March, 2019
 */
public interface UserDataSource {

    void getUserResponse(GetUserCallback callback);

    interface GetUserCallback{
        void onResponsesLoaded(UserResponse data);

        void onDataNotAvailable(String errorMessage);
    }
}

package kelompok.tiga.osgk3.data;

import kelompok.tiga.osgk3.model.user.UserResponse;

/**
 * *********************************************
 * Created by ukie on 3/26/19 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 * *********************************************
 * © 2019 | All Right Reserved
 */


public interface DataSource {

    void getResponse(GetResponseCallback callback);

    interface GetResponseCallback {
        void onResponseLoaded(Object data); //Using object to pass any Object Type

        void onDataNotAvailable(String errorMessage);
    }

    void getUserResponse(GetUserCallback callback);

    interface GetUserCallback{
        void onResponsesLoaded(UserResponse data);

        void onDataNotAvailable(String errorMessage);
    }

}

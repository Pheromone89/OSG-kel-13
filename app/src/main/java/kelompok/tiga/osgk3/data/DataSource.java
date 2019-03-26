package kelompok.tiga.osgk3.data;

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
}

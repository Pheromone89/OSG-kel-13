package kelompok.tiga.osgk3.view.list;

import java.util.List;

import kelompok.tiga.osgk3.model.user.Data;

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 30, March, 2019
 */
public interface NavigatorList {

    void loadListUser(List<Data> list);
    void errorLoadListUser(String message);

}

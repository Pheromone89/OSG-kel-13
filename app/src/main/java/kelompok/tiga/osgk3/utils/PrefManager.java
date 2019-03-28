package kelompok.tiga.osgk3.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * *********************************************
 * Created by ukie on 3/28/19 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 * *********************************************
 * © 2019 | All Right Reserved
 */
public class PrefManager {
    public String PREF_USER = "user";
    public String PREF_IS_LOGIN = "isLogin";

    private Context context;
    private SharedPreferences sharedPreferences;

    public PrefManager() {
    }

    public PrefManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("OSG-K-13", Context.MODE_PRIVATE);
    }

    public void saveString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public void clear() {
        sharedPreferences.edit().clear().apply();
    }


    public void saveBoolean(String key, Boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public Boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }
}

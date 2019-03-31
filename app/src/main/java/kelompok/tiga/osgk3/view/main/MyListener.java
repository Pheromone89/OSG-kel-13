package kelompok.tiga.osgk3.view.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import kelompok.tiga.osgk3.view.list.ListActivity;

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 30, March, 2019
 */
public class MyListener {
    private Context context;

    public MyListener(Context context) {
        this.context = context;
    }

    public void onIntent(View view){
        context.startActivity(new Intent(context, ListActivity.class));
    }
}

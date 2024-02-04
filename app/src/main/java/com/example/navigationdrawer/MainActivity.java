package com.example.navigationdrawer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);

        DrawerLayout mDrawerLayout = findViewById(R.id.drawer_layout);
        ListView mDrawerList = findViewById(R.id.drawer_list);

        List<String> drawerItems = Arrays.asList("Item 1", "Item 2"); // Замените этот список на ваши элементы меню


        DrawerListAdapter adapter = new DrawerListAdapter(this, R.layout.drawer_list_item, drawerItems);
        mDrawerList.setAdapter(adapter);

//        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // Обработка нажатий на элементы Navigation Drawer
//                // Здесь можно добавить код для обработки нажатий на пункты меню
//                // Например, переход на другую активность или выполнение определенных действий
//            }
//        });

        // region Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        // endregion
    }
}

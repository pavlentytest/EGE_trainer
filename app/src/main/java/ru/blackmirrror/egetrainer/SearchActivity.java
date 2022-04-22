package ru.blackmirrror.egetrainer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import ru.blackmirrror.egetrainer.Fragments.AccountFragment;
import ru.blackmirrror.egetrainer.Fragments.AchievementsFragment;
import ru.blackmirrror.egetrainer.Fragments.FavoriteFragment;
import ru.blackmirrror.egetrainer.Fragments.SearchFragment;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final FragmentManager fm = getSupportFragmentManager();

        BottomNavigationView bottomNavBar = findViewById(R.id.navigation_menu);
        bottomNavBar.bringToFront();
        bottomNavBar.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.item_search:
                    fragment = new SearchFragment();
                    break;
                case R.id.item_achievements:
                    fragment = new AchievementsFragment();
                    break;
                case R.id.item_favorite:
                    fragment = new FavoriteFragment();
                    break;
                case R.id.item_account:
                    fragment = new AccountFragment();
                    break;
            }
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_field, fragment);
            ft.commit();
            return true;
        });
        bottomNavBar.setSelectedItemId(R.id.item_search);
    }



}
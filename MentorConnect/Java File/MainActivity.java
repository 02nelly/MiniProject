package org.techtown.mentorconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    Fragment[] fragments = new Fragment[5]; // 배열 선언 크기 = 5

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 액션바에 로고 넣기
        getSupportActionBar().setIcon(R.drawable.logo_mini_white);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Fragment 객체를 생성하여 배열에 저장
        fragments[0] = new fragment_main();
        fragments[1] = new fragment_chat();
        fragments[2] = new fragment_notice();
        fragments[3] = new fragment_session();
        fragments[4] = new fragment_rank();

        // 맨 처음 뜰 fragment
        getSupportFragmentManager().beginTransaction().add(R.id.containers,fragments[0]).commit();

        BottomNavigationView bnv = findViewById(R.id.bottom_navigation);
        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.bottom_main)getSupportFragmentManager().beginTransaction().replace(R.id.containers,fragments[0]).commit();
                else if(item.getItemId() == R.id.bottom_chat)getSupportFragmentManager().beginTransaction().replace(R.id.containers,fragments[1]).commit();
                else if(item.getItemId() == R.id.bottom_notice)getSupportFragmentManager().beginTransaction().replace(R.id.containers,fragments[2]).commit();
                else if(item.getItemId() == R.id.bottom_session)getSupportFragmentManager().beginTransaction().replace(R.id.containers,fragments[3]).commit();
                else if(item.getItemId() == R.id.bottom_rank)getSupportFragmentManager().beginTransaction().replace(R.id.containers,fragments[4]).commit();

                return true;
            }
        });
    }
}
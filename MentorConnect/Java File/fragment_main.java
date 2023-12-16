package org.techtown.mentorconnect;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_main#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_main extends Fragment {

    Fragment[] main_navi = new Fragment[3];
    BottomNavigationView main_top;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_main() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_main.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_main newInstance(String param1, String param2) {
        fragment_main fragment = new fragment_main();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        main_navi[0] = new fragment_mainall();
        main_navi[1] = new fragment_mainkorea();
        main_navi[2] = new fragment_mainoverseas();

        // 시작할 때 보여줄 프래그먼트를 추가
        getChildFragmentManager().beginTransaction().add(R.id.containers, main_navi[0]).commit();

        main_top = rootView.findViewById(R.id.main_top);
        main_top.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.btn_main_all:
                        getChildFragmentManager().beginTransaction().replace(R.id.containers, main_navi[0]).commit();
                        break;
                    case R.id.btn_main_korea:
                        getChildFragmentManager().beginTransaction().replace(R.id.containers, main_navi[1]).commit();
                        break;
                    case R.id.btn_main_overseas:
                        getChildFragmentManager().beginTransaction().replace(R.id.containers, main_navi[2]).commit();
                        break;
                }
                return true;
            }
        });

        return rootView;
    }

}
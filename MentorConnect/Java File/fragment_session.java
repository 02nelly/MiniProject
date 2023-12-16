package org.techtown.mentorconnect;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_session#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_session extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_session() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_session.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_session newInstance(String param1, String param2) {
        fragment_session fragment = new fragment_session();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_session, container, false);

        Button button1 = view.findViewById(R.id.btn_session_1);
        Button button2 = view.findViewById(R.id.btn_session_2);
        Button button3 = view.findViewById(R.id.btn_session_3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // AlertDialog 생성
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("확인");
                builder.setMessage("예약 중으로 변경하시겠습니까?");

                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 예 버튼을 눌렀을 때
                        updateButtonColors(button1, button2, button3);
                        button1.setBackgroundResource(R.drawable.change_button);
                    }
                });

                builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 아니요 버튼을 눌렀을 때
                        dialog.dismiss(); // 다이얼로그를 닫음
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // AlertDialog 생성
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("확인");
                builder.setMessage("진행 중으로 변경하시겠습니까?");

                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 예 버튼을 눌렀을 때
                        updateButtonColors(button1, button2, button3);
                        button2.setBackgroundResource(R.drawable.change_button);
                    }
                });

                builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 아니요 버튼을 눌렀을 때
                        dialog.dismiss(); // 다이얼로그를 닫음
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // AlertDialog 생성
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("확인");
                builder.setMessage("완료상태로 변경하시겠습니까?");

                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 예 버튼을 눌렀을 때
                        updateButtonColors(button1, button2, button3);
                        button3.setBackgroundResource(R.drawable.change_button);
                    }
                });

                builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 아니요 버튼을 눌렀을 때
                        dialog.dismiss(); // 다이얼로그를 닫음
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        return view;
    }

    private void updateButtonColors(Button button1, Button button2, Button button3) {
        button1.setBackgroundResource(R.drawable.radius_button);
        button2.setBackgroundResource(R.drawable.radius_button);
        button3.setBackgroundResource(R.drawable.radius_button);
    }
}




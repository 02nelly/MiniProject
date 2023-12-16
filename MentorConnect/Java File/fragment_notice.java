package org.techtown.mentorconnect;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class fragment_notice extends Fragment {

    public fragment_notice() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notice, container, false);

        Button btn_notice_write = rootView.findViewById(R.id.btn_notice_write);

        btn_notice_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), WriteActivity.class);
                startActivity(intent);
            }
        });

        ListView listView = rootView.findViewById(R.id.noticeListView1);

        // 데이터 담을 List
        List<String> itemList = new ArrayList<>();

        // 데이터 추가
        itemList.add("1등 인기글)  " + "우리 멘토쌤 자랑 좀" );
        itemList.add("2등 인기글)  " + "헬스장 등록할 때 뭐가 제일 중요해?" );
        itemList.add("3등 인기글)  " + "취미 입문 쉬운 거 추천해주세요" );
        itemList.add("9919번   " + "다들 점심 뭐먹음?");
        itemList.add("9918번   " + "배드민턴 라켓 추천 해주세요");
        itemList.add("9917번   " + "다들 수능 화이팅!");
        itemList.add("9916번   " + "수능 점심 뭐 싸가?");
        itemList.add("9915번   " + "뉴비입니당 잘부탁드려요");
        itemList.add("9914번   " + "뉴진스 콘서트 티켓 2매 팔아요");
        itemList.add("9913번   " + "같이 롤 할 사람");
        itemList.add("9912번   " + "아이폰12 케이스 ㅊㅊ 좀");
        itemList.add("9911번   " + "페이커는 신인가?");

        // listView 클릭 시 게시글로 화면 전환
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0) { // 첫 번째 게시글 클릭 했을 때
                    Intent intent = new Intent(requireContext(), ListNotice1Activity.class);
                    startActivity(intent);
                } else if (position == 1) { // 두 번째 게시글 클릭 했을 때
                    Intent intent = new Intent(requireContext(), ListNotice2Activity.class);
                    startActivity(intent);
                }
            }
        });

        // adapter 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, itemList);

        // listView랑 adapter 연결
        listView.setAdapter(adapter);

        return rootView;
    }
}
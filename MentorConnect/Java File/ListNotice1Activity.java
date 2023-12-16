package org.techtown.mentorconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListNotice1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_notice1);

        Button btn_notice1_back = findViewById(R.id.btn_notice2_back);
        btn_notice1_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListNotice1Activity.this ,  fragment_notice.class);
                startActivity(intent);
            }
        });

        ListView listView = findViewById(R.id.notice2ListView);

        // 데이터 담을 List
        List<String> itemList = new ArrayList<String>();

        // 데이터 추가
        itemList.add("익명1   오 !! 무료라고? 대박이네");
        itemList.add("익명2   어디 살아? 나도 받고싶다 ㅠㅠ");
        itemList.add("익명3   근데 일정이 너무 빡센 거 아니야?");
        itemList.add("익명4   채팅 좀 봐줄 수 있어?");
        itemList.add("익명5   나도 내 멘티한테 더 잘 해줘야겠다..");
        itemList.add("익명6   태권도도 배우네 ㅋㅋㅋ 너 몇살이야?");

        // adapter 생성
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList);

        // listView랑 adapter 연결
        listView.setAdapter(adapter);

    }
}
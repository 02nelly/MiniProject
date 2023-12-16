package org.techtown.mentorconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListNotice2Activity extends AppCompatActivity {

    ArrayAdapter<String> adapter; // 어댑터 선언
    List<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_notice2);

        Button btn_notice2_back = findViewById(R.id.btn_notice2_back);
        btn_notice2_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListNotice2Activity.this ,  fragment_notice.class);
                startActivity(intent);
            }
        });

        ListView listView = findViewById(R.id.notice2ListView);

        // 데이터 담을 List
        itemList = new ArrayList<String>();

        // 데이터 추가
        itemList.add("익명1   난 사람 적은 곳.. 그래야 기구 쓰고싶을 때 쓸 수 있어");
        itemList.add("익명2   가까운게 최고야!");
        itemList.add("익명3   헬린이면 PT 한번 받아봐 10회정도 추천");
        itemList.add("익명4   난 시설 좋은 곳!");
        itemList.add("익명5   난 제일 싼 곳 ㅎㅎ");
        itemList.add("익명6   아무곳이나 ㄲ 도긴개긴임");

        // adapter 생성
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList);

        // listView랑 adapter 연결
        listView.setAdapter(adapter);

        // 댓글 작성

        EditText editComment = findViewById(R.id.editComment2);
        Button btn_Notice2comment = findViewById(R.id.btn_notice2comment);

        btn_Notice2comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String comment = editComment.getText().toString().trim();   // 댓글 텍스트 가져오기

                // 댓글이 비어있는지 확인
                if (!comment.isEmpty()) {
                    itemList.add(comment);

                    // 어댑터에 데이터셋 변경을 알리기
                    adapter.notifyDataSetChanged();

                    editComment.getText().clear();
                }
            }
        });
    }
}
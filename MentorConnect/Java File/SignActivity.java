package org.techtown.mentorconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        EditText edit_sign_name = findViewById(R.id.edit_sign_name);
        EditText edit_sign_id = findViewById(R.id.edit_sign_id);
        EditText edit_sign_pw = findViewById(R.id.edit_sign_pw);
        EditText edit_sign_pwch = findViewById(R.id.edit_sign_pwch);

        Button btn_sign_back = findViewById(R.id.btn_notice2_back);
        btn_sign_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignActivity.this, LoginActivity.class); // SignActivity 로 이동
                startActivity(intent);
            }
        });

        Button btn_sign_sign = findViewById(R.id.btn_sign_sign);
        btn_sign_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit_sign_name.getText().toString().equals("") || edit_sign_id.getText().toString().equals("") ||
                        edit_sign_pw.getText().toString().equals("") || edit_sign_pwch.getText().toString().equals("")) {
                    Toast.makeText(SignActivity.this, "정보를 모두 입력하세요.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignActivity.this, "회원가입을 성공하셨습니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignActivity.this, LoginActivity.class); // SignActivity 로 이동
                    startActivity(intent);
                }
            }
        });
    }
}
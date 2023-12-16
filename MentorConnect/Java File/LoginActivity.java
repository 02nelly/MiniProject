package org.techtown.mentorconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public final String userID = "test123";
    public final String userPW = "test123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText edit_ID = findViewById(R.id.edit_ID);
        EditText edit_PW = findViewById(R.id.edit_PW);

        Button btn_rogin = findViewById(R.id.btn_login_login);
        Button btn_sign = findViewById(R.id.btn_login_signup);

        btn_rogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit_ID.getText().toString().equals(userID) && edit_PW.getText().toString().equals(userPW)) {   // ID 와 PW 가 맞다면
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class); // MainActivity 로 이동
                    startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "ID 또는 PW 가 올바르지 않습니다.", Toast.LENGTH_SHORT).show();
                    }
            }
        });

        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignActivity.class); // SignActivity 로 이동
                startActivity(intent);
            }
        });
    }
}
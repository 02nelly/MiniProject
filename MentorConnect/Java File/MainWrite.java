package org.techtown.mentorconnect;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;

public class MainWrite extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_write);

        Button btn_write_ok = findViewById(R.id.btn_wrtie_ok);
        btn_write_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainWrite.this, fragment_mainall.class); // 화면 전환
                startActivity(intent);

                Toast.makeText(MainWrite.this, "글이 작성되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        imageView = findViewById(R.id.write_imageView);

        Button btn_write_image = findViewById(R.id.btn_write_image);
        btn_write_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });
    }

    // 13주차에 배운 앨범 열고 사진 선택해서 첨부하기
    public void openGallery() {
        Intent intent = new Intent();
        intent.setType(" image/* ");
        intent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(intent, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101) {
            if(resultCode == RESULT_OK) {
                Uri fileUri = data.getData();

                ContentResolver resolver = getContentResolver();

                try {
                    InputStream instream = resolver.openInputStream(fileUri);
                    Bitmap imgBitmap = BitmapFactory.decodeStream(instream);
                    imageView.setImageBitmap(imgBitmap);

                    instream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
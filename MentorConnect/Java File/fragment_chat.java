package org.techtown.mentorconnect;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_chat#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_chat extends Fragment {

    private ListView messageListView;
    private EditText messageEditText;
    private Button btn_chat_ok;
    private List<String> messageList;
    private MessageAdapter adapter; // MessageAdapter로 수정

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public fragment_chat() {
        // Required empty public constructor
    }

    public static fragment_chat newInstance(String param1, String param2) {
        return new fragment_chat();
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
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        messageListView = view.findViewById(R.id.messageListView);
        messageEditText = view.findViewById(R.id.messageEditText);
        btn_chat_ok = view.findViewById(R.id.btn_chat_ok);

        messageList = new ArrayList<>();
        adapter = new MessageAdapter(requireContext(), messageList); // MessageAdapter로 수정
        messageListView.setAdapter(adapter);

        btn_chat_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageEditText.getText().toString().trim();
                if (!message.isEmpty()) {
                    messageList.add(message);
                    adapter.notifyDataSetChanged();
                    messageEditText.setText("");
                    messageListView.smoothScrollToPosition(messageList.size() - 1);
                }
            }
        });

        return view;
    }

    public class MessageAdapter extends ArrayAdapter<String> {
        private Context context;
        private List<String> messages;

        public MessageAdapter(Context context, List<String> messages) {
            super(context, 0, messages);
            this.context = context;
            this.messages = messages;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.message_item, parent, false);
            }

            String message = messages.get(position);
            TextView messageTextView = view.findViewById(R.id.messageTextView);
            messageTextView.setText(message);

            // 메시지 구분을 위한 배경색 및 위치 조정
            /*
            if (position % 2 == 0) {

                messageTextView.setBackgroundResource(R.drawable.bubble_background);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );
                params.addRule(RelativeLayout.ALIGN_PARENT_END); // 오른쪽 정렬을 위한 부분
                messageTextView.setLayoutParams(params);
            } else {
                messageTextView.setBackgroundResource(R.drawable.bubble_background);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );
                params.addRule(RelativeLayout.ALIGN_PARENT_START); // 왼쪽 정렬을 위한 부분
                messageTextView.setLayoutParams(params);
            }

             */

            messageTextView.setBackgroundResource(R.drawable.bubble_background);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.ALIGN_PARENT_START); // 왼쪽 정렬을 위한 부분
            messageTextView.setLayoutParams(params);

            return view;
        }
    }
}
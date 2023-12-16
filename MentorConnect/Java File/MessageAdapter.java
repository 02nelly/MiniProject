package org.techtown.mentorconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<String> {
    private Context context;
    private List<String> messages;

    public MessageAdapter(Context context, List<String> messages) {
        super(context, 0, messages);
        this.context = context;
        this.messages = messages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.message_item, null);
        }

        String message = messages.get(position);
        TextView messageTextView = view.findViewById(R.id.messageTextView);
        messageTextView.setText(message);

        // 메시지 구분을 위한 배경색 및 위치 조정
        if (position % 2 == 0) {
            messageTextView.setBackgroundResource(R.drawable.bubble_background);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            params.addRule(RelativeLayout.ALIGN_PARENT_START);
            messageTextView.setLayoutParams(params);
        } else {
            messageTextView.setBackgroundResource(R.drawable.other_bubble_background);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            params.addRule(RelativeLayout.ALIGN_PARENT_END);
            messageTextView.setLayoutParams(params);
        }

        return view;
    }
}
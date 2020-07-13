package com.bytedance.todolist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bytedance.todolist.R;
import com.bytedance.todolist.database.TodoListDao;
import com.bytedance.todolist.database.TodoListDatabase;
import com.bytedance.todolist.database.TodoListEntity;

import java.util.Date;
import java.util.List;

public class AddItemActivity extends AppCompatActivity {
    private Button confirm_button;
    private TextView input_text;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item_layout);

        confirm_button = findViewById(R.id.confirm_button);
        input_text = findViewById(R.id.input_text);

        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = input_text.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("INPUT", input);
                if (input.isEmpty()) {
                    setResult(RESULT_CANCELED, intent);
                } else {
                    setResult(RESULT_OK, intent);
                }
                finish();
            }
        });



    }

}

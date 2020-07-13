package com.bytedance.todolist.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.todolist.R;
import com.bytedance.todolist.database.TodoListEntity;

import com.bytedance.todolist.database.interface1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author wangrui.sh
 * @since Jul 11, 2020
 */
public class TodoListItemHolder extends RecyclerView.ViewHolder {
    private TextView mContent;
    private TextView mTimestamp;
    private CheckBox checkbox;
    private ImageButton del_button;
    private final interface1 tool;

    public TodoListItemHolder(@NonNull View itemView, interface1 intfc) {
        super(itemView);
        this.tool = intfc;
        mContent = itemView.findViewById(R.id.tv_content);
        mTimestamp = itemView.findViewById(R.id.tv_timestamp);
        checkbox = itemView.findViewById(R.id.checkBox);
        del_button = itemView.findViewById(R.id.delete);
    }




    @SuppressLint("ResourceAsColor")
    public void bind(final TodoListEntity entity) {
        mContent.setText(entity.getContent());
        mTimestamp.setText(formatDate(entity.getTime()));
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mContent.setTextColor(Color.GRAY);
                    mContent.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    mContent.setTextColor(Color.BLACK);
                    mContent.getPaint().setFlags(0);
                }
            }
        });
        del_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tool.deleteEntity(entity);
            }
        });
    }

    private String formatDate(Date date) {
        DateFormat format = SimpleDateFormat.getDateInstance();
        return format.format(date);
    }
}

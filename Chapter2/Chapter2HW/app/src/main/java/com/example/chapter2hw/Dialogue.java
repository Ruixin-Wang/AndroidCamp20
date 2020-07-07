package com.example.chapter2hw;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Dialogue extends Activity {
    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue);
        Log.i(TAG, "LinearLayoutActivity onCreate");
        initView();
    }

    private void initView() {
        String pos =this.getIntent().getStringExtra("pos");
        int index=Integer.parseInt(pos);
        TextView tvindex = findViewById(R.id.tv_index);
        tvindex.setText("Index "+index);
    }
}

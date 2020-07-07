package com.example.chapter2hw.recycler;

import com.example.chapter2hw.R;

import java.util.ArrayList;
import java.util.List;


public class Dataset {

    public static List<Data> getData() {
        List<Data> result = new ArrayList();
        result.add(new Data("联系人1", "内容", "刚刚", R.drawable.avatar1));
        result.add(new Data("联系人2", "内容", "昨天", R.drawable.avatar2));
        result.add(new Data("联系人3", "内容", "12:00", R.drawable.avatar3));
        result.add(new Data("联系人4", "内容", "11:22", R.drawable.avatar4));
        result.add(new Data("联系人5", "内容", "10:08", R.drawable.avatar5));
        result.add(new Data("联系人6", "内容", "9:14", R.drawable.avatar6));
        result.add(new Data("联系人7", "内容", "9:14", R.drawable.avatar7));
        result.add(new Data("联系人8", "内容", "8:10", R.drawable.avatar8));
        result.add(new Data("联系人9", "内容", "7:55", R.drawable.avatar9));
        result.add(new Data("联系人10", "内容", "23:29", R.drawable.avatar3));
        result.add(new Data("联系人11", "内容", "20:08", R.drawable.avatar2));
        result.add(new Data("联系人12", "内容", "20:00", R.drawable.avatar1));
        result.add(new Data("联系人13", "内容", "17:36", R.drawable.avatar8));
        result.add(new Data("联系人14", "内容", "14:27", R.drawable.avatar5));
        result.add(new Data("联系人15", "内容", "12:50", R.drawable.avatar4));
        result.add(new Data("联系人16", "内容", "7:02", R.drawable.avatar9));
        result.add(new Data("联系人17", "内容", "20:32", R.drawable.avatar7));
        result.add(new Data("联系人18", "内容", "18:51", R.drawable.avatar6));
        return result;
    }

}

package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragmentMessages extends Fragment {
    private LottieAnimationView animationView;
    private ListView List;
    private ArrayAdapter ArrAdapter;
    private AnimatorSet animatorSet;


    String[] messages = {
            "消息1", "消息2", "消息3", "消息4", "消息5"
    };



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // TODO ex3-3: 修改 fragment_placeholder_contact，添加 loading 控件和列表视图控件
        View view = inflater.inflate(R.layout.fragment_placeholder_contact, container, false);
        animationView = view.findViewById(R.id.loading_animation);
        List = view.findViewById(R.id.List_view);
        animationView.setAlpha(1.0f);
        List.setAlpha(0.0f);


        ArrAdapter= new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, messages);
        List.setAdapter(ArrAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(animationView,"alpha",1.0f,0.0f,0.0f);
                animator1.setDuration(1000);
                animator1.setRepeatCount(0);
                animator1.setRepeatMode(ObjectAnimator.RESTART);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(List,"alpha",0.0f,1.0f,1.0f);
                animator2.setDuration(1000);
                animator2.setRepeatCount(0);
                animator2.setRepeatMode(ObjectAnimator.RESTART);
                animatorSet = new AnimatorSet();
                animatorSet.playTogether(animator1);
                animatorSet.playTogether(animator2);
                animatorSet.start();
            }
        }, 5000);
    }
}

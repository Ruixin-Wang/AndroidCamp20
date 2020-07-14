package com.bytedance.videoplayer;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;
import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class ImageActivity extends AppCompatActivity {

    private final static String IMAGE_URL = "http://n.sinaimg.cn/sinacn20120/408/w1200h808/20181230/7186-hqwsysz7166883.jpg";
    private ImageView imageview;
    private Button btn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        imageview = findViewById(R.id.image_container);
        btn = findViewById(R.id.button);
        String url = "http://n1.itc.cn/img8/wb/recom/2016/09/03/147285582375143195.JPEG";
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.timg);
        requestOptions.error(R.drawable.fail);
        requestOptions.circleCropTransform();
        requestOptions.centerCrop();
        requestOptions.transforms( new RoundedCorners(50));
        requestOptions.fallback(R.drawable.ic_launcher_background);
        Glide.with(ImageActivity.this)
                .load(url)
                .apply(requestOptions)
                .transition(withCrossFade(1500))
                .into(imageview);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadImage();
            }
        });

    }

    private void loadImage() {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.timg);
        requestOptions.error(R.drawable.fail);
        requestOptions.circleCropTransform();
        requestOptions.centerCrop();
        requestOptions.transforms( new RoundedCorners(50));
        requestOptions.fallback(R.drawable.ic_launcher_background);
        Glide.with(ImageActivity.this)
                .load(IMAGE_URL)
                .apply(requestOptions)
                .transition(withCrossFade(1500))
                .into(imageview);

    }







}

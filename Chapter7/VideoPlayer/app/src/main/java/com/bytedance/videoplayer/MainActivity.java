package com.bytedance.videoplayer;

        import android.content.Intent;
        import android.content.pm.ActivityInfo;
        import android.content.res.Configuration;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;

        import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private Button btn_img;
    private Button btn_video;
    private static String video_url = "https://vdept.bdstatic.com/5577525a655865327871764336497746/74585a684b493556/b6bfff3fb168e000682b78b0b240a3b12f837a0bc28f6bf3fa581022b3406b6a253b168fdc47bc0799a7314b92fcb81f2f5b18f9f38ead336f628aeda67abd23.mp4?auth_key=1594735620-0-0-cee42bf2398be304d25872d6531474fd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView);
        btn_img = findViewById(R.id.btn_img);
        btn_video = findViewById(R.id.btn_video);

        btn_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ImageActivity.class));
            }
        });

        btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoActivity.launch(MainActivity.this, video_url);
            }
        });


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }else{
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }
}

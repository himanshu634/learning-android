package com.example.first_app;


import android.content.Intent;

import android.os.Bundle;

import android.view.Gravity;
import android.view.View;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.first_app.databinding.ActivityMainBinding;

import io.flutter.FlutterInjector;

import io.flutter.embedding.android.FlutterSurfaceView;

import io.flutter.embedding.android.FlutterTextureView;
import io.flutter.embedding.android.FlutterView;

import io.flutter.embedding.engine.FlutterEngine;

import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterRenderer;

public class MainActivity extends AppCompatActivity {
    private FlutterViewEngine flutterViewEngine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.first_app.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FlutterEngine flutterEngine = new FlutterEngine(this);
        flutterEngine.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint
                (FlutterInjector.instance().flutterLoader().findAppBundlePath(),
                        "showCell"));


        flutterViewEngine = new FlutterViewEngine(flutterEngine);

        FlutterView flutterView1 = new FlutterView(this, new FlutterSurfaceView(this, true));

        flutterViewEngine.attachFlutterView(flutterView1);
        flutterViewEngine.attachToActivity(this);

        binding.flView.addView(flutterView1);
        binding.rl.bringChildToFront(binding.button);

//        binding.button.invalidate();


//        Button button = new Button(this);
//        button.setText("From Android");
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        layoutParams.gravity = Gravity.CENTER;
//        button.setLayoutParams(layoutParams);
//
//        binding.rl.addView(button, 0);


//        FlutterView flutterView = binding.flView;
//        flutterViewEngine.attachFlutterView(flutterView);
//        flutterViewEngine.attachToActivity(this);


//        binding.flView.setBackgroundColor(getResources().getColor(R.color.transp));
//        binding.flView.addView(new FlutterSurfaceView(this, true));

//        flutterView.bringToFront();
//        binding.button.bringToFront();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        flutterViewEngine.detachActivity();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        flutterViewEngine.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        flutterViewEngine.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        flutterViewEngine.onUserLeaveHint();
    }

    public void doSomething(View view) {
        Toast.makeText(this, "In Android", Toast.LENGTH_SHORT).show();
    }
}


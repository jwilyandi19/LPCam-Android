package com.example.jasonwilyandi.lpcamandroid;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView imageView;
    ImageButton btnCamera,saveFTP;
    private ConnDetect cd;
    private Boolean upflag = false;
    private Uri selectedImage = null;
    private Bitmap bitmap,bitmapRotate;
    private ProgressDialog pDialog;
    String imagepath = "/images";
    String fname;
    File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //dari line ini sampe selesai cuma buat inisiasi
        cd = new ConnDetect(MainActivity.this);

        btnCamera = (ImageButton) findViewById(R.id.btnCamera);
        imageView = (ImageView)findViewById(R.id.imageView);
        cd = new ConnDetect(getApplicationContext());
        btnCamera.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCamera:
                Intent cameraintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraintent, 101);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try{
            switch (requestCode){
                case 101:
                    if(resultCode == Activity.RESULT_OK){
                        if(data != null){
                            selectedImage = data.getData();
                            if(String.valueOf((Bitmap) data.getExtras().get("data")).equals("null")){
                                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),selectedImage);
                            }
                            else {
                                bitmap = (Bitmap) data.getExtras().get("data");
                            }
                            imageView.setVisibility(View.VISIBLE);
                            imageView.setImageBitmap(bitmapRotate);
                        }
                    }
            }
        }
        }


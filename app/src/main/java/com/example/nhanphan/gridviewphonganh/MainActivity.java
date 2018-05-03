package com.example.nhanphan.gridviewphonganh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnBack;
    ImageView imagZoomIn;
    GridView GridView;
    Bundle myBundle;
    Integer[] Hinhnho = {R.drawable.s_image1,R.drawable.s_image2,R.drawable.s_image3,R.drawable.s_image4,
            R.drawable.s_image5,R.drawable.s_image6,R.drawable.s_image7,R.drawable.s_image8,R.drawable.s_image9};
    Integer[] Hinhto = {R.drawable.s_image1,R.drawable.s_image2,R.drawable.s_image3,R.drawable.s_image4,
            R.drawable.s_image5,R.drawable.s_image6,R.drawable.s_image7,R.drawable.s_image8,R.drawable.s_image9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myBundle = savedInstanceState;
        GridView = (GridView) findViewById(R.id.gridView);
        GridView.setAdapter(new MyImgAdapter(MainActivity.this, Hinhnho));
        GridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showBigScreen(position);
                onDestroy();
            }
        });
    }
    public void showBigScreen(int position){
        setContentView(R.layout.zoom_in);
        imagZoomIn = (ImageView) findViewById(R.id.imgView);
        imagZoomIn.setImageResource(Hinhto[position]);
        btnBack = (Button) findViewById(R.id.btBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreate(myBundle);
            }
        });
    }
}

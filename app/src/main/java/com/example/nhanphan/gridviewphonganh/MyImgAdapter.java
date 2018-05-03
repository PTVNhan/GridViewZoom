package com.example.nhanphan.gridviewphonganh;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class MyImgAdapter extends BaseAdapter{
    private Context context;
    Integer[] smallImg;

    public MyImgAdapter(Context mainActivityContext, Integer[] fileAnh){
        context = mainActivityContext;
        smallImg = fileAnh;
    }
    public Context getContext() {
        return context;
    }
    public int getCount(){// Lấy chiều dài của mảng
        return smallImg.length;
    }
    @Override
    public Object getItem(int position) { //xuất giá trị tại vị trí position trong mảng
        return smallImg[position];
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null){ // Kiểm tra nếu view bằng rỗng thì
            imageView = new ImageView(context); // gán imageview bằng View mà mình đã bấm
            imageView.setLayoutParams(new GridView.LayoutParams(350,325)); // set Layout có dộ dài là 100 độ cao 75
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP); // chỉnh imgaeview nằm chính giữa dù kéo thế nào đi nữa
            imageView.setPadding(5,5,5,5);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(smallImg[position]);
        return imageView;
    }
}

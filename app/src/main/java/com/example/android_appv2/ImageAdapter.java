package com.example.android_appv2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    public int [] imageArray = {

            R.drawable.chicfila, R.drawable.utaad, R.drawable.subway,
            R.drawable.utaad2, R.drawable.pandaexpress, R.drawable.utaad3,
            R.drawable.dickssporting,R.drawable.googleholiday,R.drawable.utabootcamp,
            R.drawable.ring,R.drawable.uniqlo,R.drawable.womantech



    };

    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int i) {
        return imageArray[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(imageArray[i]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams( 340, 350));

        return imageView;
    }
}
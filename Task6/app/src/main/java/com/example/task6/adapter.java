package com.example.task6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adapter extends BaseAdapter {
    private Context context;
    private  int layout;
    private ArrayList<details> imageDetails;

    public adapter(Context context, int layout, ArrayList<details> imageDetails) {
        this.context = context;
        this.layout = layout;
        this.imageDetails = imageDetails;
    }

    @Override
    public int getCount() {
        return imageDetails.size();
    }

    @Override
    public Object getItem(int position) {
        return imageDetails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder = new ViewHolder();
        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.imageView = row.findViewById(R.id.imgMovie);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        details details = imageDetails.get(position);

        byte[] image = details.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
        holder.imageView.setImageBitmap(bitmap);
        return row;
    }
}
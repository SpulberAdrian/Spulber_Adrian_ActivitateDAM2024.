package com.example.seminar4_;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class ImagineAdapter extends BaseAdapter {

    private List<Imagine> Imagine = null;
    private Context ctx;
    private int resurselayout;
    public ImagineAdapter(List<Imagine> list , Context ctx,  int resurse){
        this.Imagine = list;
        this.ctx = ctx;
        this.resurselayout = resurse;
    }

    public View getView(int i, View view, ViewGroup viewGroup){
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(resurselayout, viewGroup,false);

        ImageView image = v.findViewById(R.id.imagineAutobuz);

        Imagine img = (Imagine) getItem(i);

        image.setImageBitmap(img.getImagine());
        return v;
    }
    @Override
    public int getCount() {
        return Imagine.size();
    }

    @Override
    public Object getItem(int i) {
        return Imagine.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}

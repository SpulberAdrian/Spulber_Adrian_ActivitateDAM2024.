package com.example.seminar4_;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class AutocarAdapter extends BaseAdapter {

    private List<Autocar> Autocare = null;
    private Context ctx;
    private int resurseLayout;

    @Override
    public int getCount() {
        return Autocare.size();
    }

    @Override
    public Object getItem(int i) {
        return Autocare.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(resurseLayout,viewGroup, false);

        TextView numeSofer = v.findViewById(R.id.NumeSofer);
        TextView numarPasageri = v.findViewById(R.id.NrPasageri);
        TextView rezervor = v.findViewById(R.id.Rezervor);
        TextView caiPutere = v.findViewById(R.id.CaiPutere);

        Autocar autocar = (Autocar)getItem(i);

        numeSofer.setText(autocar.getNumeSofer());
        numarPasageri.setText(String.valueOf(autocar.getNrLocuri()));
        rezervor.setText(String.valueOf(autocar.getRezervorCapacitate()));
        caiPutere.setText(String.valueOf(autocar.getCaiPutere()));

        return v;
    }

    public AutocarAdapter(List<Autocar> Autocare , Context ctx, int resursa){
        this.Autocare = Autocare;
        this.ctx = ctx;
        this.resurseLayout = resursa;
    }


}

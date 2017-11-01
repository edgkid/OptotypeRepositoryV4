package com.example.edgar.optotypesystemdevelop;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Edgar on 01/11/2017.
 */

public class ListActionOnPatientAdapter extends ArrayAdapter<ListActionOnPatient>{

    Context context;
    int layoutResourceId;
    ListActionOnPatient data[];

    public ListActionOnPatientAdapter(Context context, int layoutResourceId, ListActionOnPatient  [] data){
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    public View getView (int position, View convertView, ViewGroup parent){

        View row = convertView;
        ListActionOnPatientAdapter.ListActionPatientHolder holder = null;

        //verificar entrada de los datos
        if (row == null){

            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ListActionOnPatientAdapter.ListActionPatientHolder();
            holder.photo = (ImageView) row.findViewById(R.id.photoPatientToday);
            holder.name = (TextView) row.findViewById(R.id.completeNamePatient);
            holder.icon = (ImageView) row.findViewById(R.id.crudIconDoctor);
            row.setTag(holder);

        }else{
            holder = (ListActionOnPatientAdapter.ListActionPatientHolder) row.getTag();
        }

        ListActionOnPatient actionPatients = data[position];
        holder.photo.setImageResource(actionPatients.getPhoto());
        holder.name.setText(actionPatients.getName());
        holder.icon.setImageResource(actionPatients.getIcon());

        return row;
    }

    static class ListActionPatientHolder{

        ImageView photo;
        TextView name;
        ImageView icon;
    }

}

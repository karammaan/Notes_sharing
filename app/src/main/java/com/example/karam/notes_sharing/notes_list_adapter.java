package com.example.karam.notes_sharing;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by karam on 30-04-17.
 */

public class notes_list_adapter extends RecyclerView.Adapter<notes_list_view_holder> {

    JSONArray jsarr;
    Activity b;

    public notes_list_adapter(JSONArray jarr, Activity a) {
        jsarr= jarr;
        b=a;
    }

    @Override
    public notes_list_view_holder onCreateViewHolder(ViewGroup parent, int viewType) {

       notes_list_view_holder v = new notes_list_view_holder(LayoutInflater.from(b).inflate(R.layout.cell,parent,false));

        return v ;
    }

    @Override
    public void onBindViewHolder(notes_list_view_holder holder, int position) {


        try {
            JSONObject job = jsarr.getJSONObject(position);

            holder.posted_by.setText(job.getString("posted_by"));
            holder.subject.setText(job.getString("Subject"));
            holder.posted_on.setText(job.getString("Date"));
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return jsarr.length();
    }
}

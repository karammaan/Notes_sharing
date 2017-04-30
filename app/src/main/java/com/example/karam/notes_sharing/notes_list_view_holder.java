package com.example.karam.notes_sharing;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by karam on 30-04-17.
 */

public class notes_list_view_holder extends RecyclerView.ViewHolder
{
    public TextView posted_by, subject, posted_on;

    public notes_list_view_holder(View itemView) {
        super(itemView);

      posted_by =(TextView) itemView.findViewById(R.id.posted_by_id);
        subject =(TextView) itemView.findViewById(R.id.subject_id);
        posted_on =(TextView) itemView.findViewById(R.id.posted_on_id);
    }


}

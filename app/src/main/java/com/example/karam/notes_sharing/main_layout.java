package com.example.karam.notes_sharing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class main_layout extends AppCompatActivity {
    RecyclerView recycle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        recycle = (RecyclerView) findViewById(R.id.recycler_id);

        recycle.setLayoutManager(new LinearLayoutManager(main_layout.this , LinearLayoutManager.VERTICAL , false));

        get_data();

    }

    public void get_data() {

        JSONObject jobj = new JSONObject();

        JsonObjectRequest jobreq = new JsonObjectRequest("http://" + Internet_address.ip + "/notes_sharing/get_all_notes.php", jobj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response);

                try {
                    JSONArray jarr =  response.getJSONArray("result");

                    notes_list_adapter ad = new notes_list_adapter(jarr , main_layout.this);


                    recycle.setAdapter(ad);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        jobreq.setRetryPolicy(new DefaultRetryPolicy(20000,2,2));
        AppController appcont = new AppController(main_layout.this);
        appcont.addToRequestQueue(jobreq);

    }

    public void done (View view) {

        Intent i = new Intent(main_layout.this, profile_edit_layout.class);
        startActivity(i);
    }

}

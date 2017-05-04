package com.example.karam.notes_sharing;


import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class profile_edit_layout extends AppCompatActivity {
    Button done_et;
    EditText  name, email, mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit_layout);

        done_et = (Button)findViewById(R.id.button_done);

        name = (EditText) findViewById(R.id.name_id);
        email = (EditText) findViewById(R.id.email_id);
        mobile = (EditText) findViewById(R.id.mobile_id);

        get_profile();

    }

    public void get_profile()
    {
        SharedPreferences sp = getSharedPreferences("user_info",MODE_PRIVATE);

        String user_id =  sp.getString("user_id","");




        JSONObject job = new JSONObject();
        try {
            job.put("user_id" , user_id);

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(job);
        JsonObjectRequest jobreq =new JsonObjectRequest("http://" + Internet_address.ip + "/notes_sharing/get_profile_edit.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response);
                try {
                    JSONObject job = response.getJSONObject("result");
                    String email_et = job.getString("Email_id");
                    String name_et = job.getString("Username");
                    String contact_et = job.getString("Mobile_no");


                    name.setText( name_et );
                    email.setText( email_et );
                    mobile.setText( contact_et);



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.println(error);
            }
        });
        jobreq.setRetryPolicy(new DefaultRetryPolicy(20000 , 2 , 2));

        AppController app = new AppController(profile_edit_layout.this);
        app.addToRequestQueue(jobreq);





    }

}


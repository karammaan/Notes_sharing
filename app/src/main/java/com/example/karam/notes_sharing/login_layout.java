package com.example.karam.notes_sharing;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class login_layout extends AppCompatActivity {

    private EditText email_edit_text , password_edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);


        email_edit_text = (EditText) findViewById(R.id.email_edit_text);
       password_edit_text = (EditText) findViewById(R.id.password_edit_text);


    }


    public void login( View v)
    {
        String email = email_edit_text.getText().toString();
        String password = password_edit_text.getText().toString();

        JSONObject job = new JSONObject();

        try {
            job.put("email_key", email);
            job.put("password_key" , password);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        JsonObjectRequest jobreq = new JsonObjectRequest("http://"+Internet_address.ip+"/notes_sharing/login_notes_sharing.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    if(response.getString("key").equals("done"))
                    {
                        Toast.makeText(login_layout.this, " done ", Toast.LENGTH_SHORT).show();

                        SharedPreferences.Editor sp = getSharedPreferences("user_info",MODE_PRIVATE).edit();

                        sp.putString("user_id",response.getString("user_id"));

                        sp.commit();

                        Intent i = new Intent(login_layout.this , main_layout.class);

                        startActivity(i);
                        finish();
                    }

                    else {
                        Toast.makeText(login_layout.this, "error", Toast.LENGTH_SHORT).show();

                    }
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

        jobreq.setRetryPolicy(new DefaultRetryPolicy(20000, 2, 2));

        AppController app = new AppController(login_layout.this);

        app.addToRequestQueue(jobreq);
    }

    public void signup(View view) {

        Intent i = new Intent(login_layout.this , sign_up_layout.class);
        startActivity(i);
    }
}


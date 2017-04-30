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

public class sign_up_layout extends AppCompatActivity {


    EditText  mobile, username_id, email_id, password_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_layout);

        mobile = ((EditText) findViewById(R.id.edit_mobile_no));
        username_id = (EditText) findViewById(R.id.edit_username);
        email_id = (EditText) findViewById(R.id.edit_email);
        password_id = (EditText) findViewById(R.id.edit_password);

    }


            public void register(View v) {
                String username = username_id.getText().toString();

                String email = email_id.getText().toString();

                String password = password_id.getText().toString();

                String mobile_no = mobile.getText().toString();

                if(username.equals(""))
                {
                    Toast.makeText(sign_up_layout.this , "please enter your username" , Toast.LENGTH_SHORT).show();
                    return;
                }

                JSONObject job = new JSONObject();

                try {
                    job.put("name_key", username);
                    job.put("pass_key", password);
                    job.put("email_key", email);
                    job.put("mobile_key",mobile_no);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                System.out.println(job);

                JsonObjectRequest jobreq = new JsonObjectRequest("http://"+Internet_address.ip+"/notes_sharing/signup_notes_sharing.php", job, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {


                            if (response.getString("key").equals("1")) {

                                SharedPreferences.Editor sp = getSharedPreferences("user_info", MODE_PRIVATE).edit();

                                sp.putString("user_id", response.getString("user_id"));

                                sp.commit();

                                Intent i = new Intent(sign_up_layout.this, main_layout.class);
                                startActivity(i);
                                finish();
                            } else {

                                Toast.makeText(sign_up_layout.this , "email already exist" , Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                jobreq.setRetryPolicy(new DefaultRetryPolicy(20000, 2, 2));

                AppController app = new AppController(sign_up_layout.this);
                app.addToRequestQueue(jobreq);


            }
        }








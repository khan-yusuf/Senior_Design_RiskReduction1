package com.example.risk_reduction_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.*;
import java.io.*;

//import com.jjoe64.graphview.GraphView;
//import com.jjoe64.graphview.series.DataPoint;
//import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView displayDataAsText;
//    GraphView graphView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayDataAsText = findViewById(R.id.display_data);
        EditText inputField = findViewById(R.id.input_field);
        Button sendButton = findViewById(R.id.post_button);


        //Set SEND button on click behavior
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //call post data to send data from input field

                postData(inputField.getText().toString());
            }
        });



    }

    private void postData (String field1Data){
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

        //test API for front end development
        String responseHoster = "https://reqres.in/api/users";

        Response.Listener<String> responseListener = new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response); //create a JSON object from the response we got
                    String field1 = jsonResponse.getString("field1");
                    //String field2 = jsonResponse.getString("field2");
                    displayDataAsText.setText("Field 1 is: "+ field1 + "\n"
                           );
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                displayDataAsText.setText("Error in posting information");
            }
        };

        StringRequest stringRequest = new StringRequest( Request.Method.POST, responseHoster, responseListener, errorListener) {
            @Override
            protected Map<String, String> getParams() {
                //Guessing need a key:value structure in order to use JSON
                //on the response
                Map<String, String> params = new HashMap<String, String>();
                params.put("field1", field1Data);
                //params.put("field2", "Text from field 2");

                return params;
            }
        };

        queue.add(stringRequest);
    }
}
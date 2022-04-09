package com.example.risk_reduction_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.*;
import java.io.*;

//import com.jjoe64.graphview.GraphView;
//import com.jjoe64.graphview.series.DataPoint;
//import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView displayDataAsText;
//    GraphView graphView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.text);
// ...

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://www.google.com";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        textView.setText("Response is: " + response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);


//        //Create intent to start another activity (currently used for uncreated activity)
////        Intent display_data_intent = new Intent(this, DisplayData.class);
////        startActivity(display_data_intent);
//        ArrayList<String> testArrayList = new ArrayList<String>(10);
//        //fill test array with numbers for test printing
//        for (int i = 0; i < 10; i++){
//            testArrayList.add(Integer.toString(i));
//        }
//
//        //Links this java file to "activity_main.xml"
          //setContentView(R.layout.activity_main);
//
//        //Links our pointer to the TextView object "display_data"
//        //in the "activity_main.xml" file
          //displayDataAsText = findViewById(R.id.display_data);
//
//        for (int i=0; i<testArrayList.size(); i++){
//            //Display each element on a separate line
//            /*displayDataAsText.append(testArrayList.get(i));
//            displayDataAsText.append("\n");*/
//
//            //Print each element on one line
//            displayDataAsText.setText(displayDataAsText.getText() + " " + testArrayList.get(i)
//                                      + ", ");
//        }
//
////        DisplayData displayData = new DisplayData(testArrayList);
//        try{
//            URL oracle = new URL("https://www.learningcontainer.com/wp-content/uploads/2020/04/sample-text-file.txt");
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(oracle.openStream()));
//
//            String inputLine;
//            while ((inputLine = in.readLine()) != null)
//                Log.i("text", inputLine);
//            in.close();
//        }
//        catch(Exception e){
//            Log.i("error", "error with reading file from web");
//        }

//        DisplayData displayData = new DisplayData(testArrayList);



//        // on below line we are initializing our graph view.
//        graphView = findViewById(R.id.idGraphView);
//
//        // on below line we are adding data to our graph view.
//        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
//                // on below line we are adding
//                // each point on our x and y axis.
//                new DataPoint(0, 1),
//                new DataPoint(1, 3),
//                new DataPoint(2, 4),
//                new DataPoint(3, 9),
//                new DataPoint(4, 6),
//                new DataPoint(5, 3),
//                new DataPoint(6, 6),
//                new DataPoint(7, 1),
//                new DataPoint(8, 2)
//        });
//
//        // after adding data to our line graph series.
//        // on below line we are setting
//        // title for our graph view.
//        graphView.setTitle("My Graph View");
//
//        // on below line we are setting
//        // text color to our graph view.
//        graphView.setTitleColor(R.color.purple_200);
//
//        // on below line we are setting
//        // our title text size.
//        graphView.setTitleTextSize(18);
//
//        // on below line we are adding
//        // data series to our graph view.
//        graphView.addSeries(series);

    }
}
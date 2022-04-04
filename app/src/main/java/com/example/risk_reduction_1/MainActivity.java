package com.example.risk_reduction_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView displayDataAsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create intent to start another activity (currently used for uncreated activity)
//        Intent display_data_intent = new Intent(this, DisplayData.class);
//        startActivity(display_data_intent);
        ArrayList<String> testArrayList = new ArrayList<String>(10);
        //fill test array with numbers for test printing
        for (int i = 0; i < 10; i++){
            testArrayList.add(Integer.toString(i));
        }

        //Links this java file to "activity_main.xml"
        setContentView(R.layout.activity_main);

        //Links our pointer to the TextView object "display_data"
        //in the "activity_main.xml" file
        displayDataAsText = findViewById(R.id.display_data);

        for (int i=0; i<testArrayList.size(); i++){
            //Display each element on a separate line
            /*displayDataAsText.append(testArrayList.get(i));
            displayDataAsText.append("\n");*/

            //Print each element on one line
            displayDataAsText.setText(displayDataAsText.getText() + " " + testArrayList.get(i)
                                      + ", ");
        }

//        DisplayData displayData = new DisplayData(testArrayList);
    }
}